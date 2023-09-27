package org.university.lab2;

public class DVD extends Item{
    private int duration;

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }
    public int getDuration(){
        return duration;
    }
    @Override
    public String toString(){
        return "Тривалість: " + super.toString() + " хвилин";
    }
}
