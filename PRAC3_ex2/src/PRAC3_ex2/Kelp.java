package PRAC3_ex2;

public class Kelp extends Item{

    private int growStep;

    public Kelp (double xCoord, double yCoord, double length, double height, Tank tank) throws ItemException{
        super(xCoord, yCoord, "./images/kelp/kelp_default.png", length, height, tank);
        growStep=50;
    }
    
}