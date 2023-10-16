package org.university.lab6;

import java.util.Arrays;

public class Cinema {
    private int[][][] seatingArragement;

    public Cinema(int halls, int rows, int seats) {
        seatingArragement = new int[halls][rows][seats];
    }
    public static void main(String[] args){
        Cinema cinema = new Cinema(5,10,20);

        int[] seatsToBook = {2,3,4};
        System.out.println("Бронювання місць:");
        cinema.bookSeats(0,0,seatsToBook);
        System.out.println("\nСхема розміщення місць після бронювання:");
        cinema.printSeatingArragement(0);

        System.out.println("\nСкасування бронювання:");
        cinema.cancelBooking(0,0,seatsToBook);
        System.out.println("\nСхема розміщення місць після бронювання:");
        cinema.printSeatingArragement(0);

        int seatToCheck = 3;
        boolean isAvailable = cinema.checkAvailability(0, seatToCheck);
        System.out.println("\nПеревірка доступності " + seatToCheck + " місць: " + isAvailable);

        int seatsToBookAutomatically = 4;
        int[] bestseats = cinema.autoBook(1, seatsToBookAutomatically);
        if (bestseats != null) {
            System.out.println("\nАвтоматичне бронювання " + seatsToBookAutomatically + " місць: " + Arrays.toString(bestseats));
        } else {
            System.out.println("\nНе вдалося знайти " + seatsToBookAutomatically + " доступних місць.");
        }
    }
    public boolean bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (seatingArragement[hallNumber][row][seat] == 0) {
                seatingArragement[hallNumber][row][seat] = 1;
            } else {
                System.out.println("Місце " + seat + " у ряду " + row + " в залі " + hallNumber + " вже заброньоване.");
                return false;
            }
        }
        System.out.println("Місце заброньоване");
        return true;
    }

    public boolean cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (seatingArragement[hallNumber][row][seat] == 1) {
                seatingArragement[hallNumber][row][seat] = 0;
            }
        }
        return true;
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int row = 0; row < seatingArragement[hallNumber].length; row++) {
            int nextEmptySeats = 0;
            for (int seat = 0; seat < seatingArragement[hallNumber][row].length; seat++) {
                if (seatingArragement[hallNumber][row][seat] == 0) {
                    nextEmptySeats++;
                    if (nextEmptySeats == numSeats) {
                        return true;
                    }
                } else {
                    nextEmptySeats = 0;
                }
            }
        }
        return false;
    }

    public void printSeatingArragement(int hallNumber) {
        System.out.println("Схема розміщення місць для залу " + hallNumber + ":");
        for (int row = 0; row < seatingArragement[hallNumber].length; row++) {
            for (int seat = 0; seat < seatingArragement[hallNumber][row].length; seat++) {
                if (seatingArragement[hallNumber][row][seat] == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }

    public int[] findBestAvailable(int hallNumber, int numSeats){
        for (int row = 0; row < seatingArragement[hallNumber].length; row++){
            int nextEmptySeats = 0;
            for (int seat = 0; seat < seatingArragement[hallNumber][row].length; seat++){
                if (seatingArragement[hallNumber][row][seat] == 0){
                    nextEmptySeats++;
                    if (nextEmptySeats == numSeats){
                        int[] bestSeats = new int[numSeats];
                        for (int i = 0; i < numSeats; i++){
                            bestSeats[i] = seat - i;
                        }
                        return bestSeats;
                    }
                } else {
                    nextEmptySeats = 0;
                }
            }
        } return null;
    }

    public int[] autoBook(int hallNumber, int numSeats){
        int[] bestSeats = findBestAvailable(hallNumber, numSeats);
        if (bestSeats != null) {
            if (bookSeats(hallNumber, bestSeats[0] / seatingArragement[hallNumber][0].length, bestSeats)){
                return bestSeats;
            }
        }
        return null;
    }

}
