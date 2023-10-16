package org.university.lab6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
public class CinemaTest {
    private Cinema cinema;

    @Test
    public void testBooking(){
        cinema = new Cinema(5,10,20);
        int[] seatsToBook = {2,3,4};
        Assertions.assertTrue(cinema.bookSeats(0,0, seatsToBook));
        Assertions.assertTrue(cinema.cancelBooking(0, 0, seatsToBook));

    }

    @Test
    public void testCheckAvailability(){
        cinema = new Cinema(5,10,20);
        int seatsToCheck = 3;
        Assertions.assertTrue(cinema.checkAvailability(0, seatsToCheck));
    }

    @Test
    public void testAutoBooking(){
        cinema = new Cinema(5,10,20);
        int seatsToBook = 4;
        int[] bestSeats = cinema.autoBook(1, seatsToBook);
        Assertions.assertNotNull(bestSeats);
    }
}
