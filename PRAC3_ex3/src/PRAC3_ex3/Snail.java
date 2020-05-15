package PRAC3_ex3;

import java.util.Random;

public class Snail extends Animal {

    private static final int TANK_PANE_HEIGHT = 30;
    
    protected Snail(double xCoord, double yCoord, double length, double height, Gender gender, int age, int energy, Tank tank) throws MovableException, AnimalException, ItemException, Exception{
        super(xCoord, TANK_PANE_HEIGHT, "./images/snail/snail.png", length, height, gender, age, 0.01, 0.1, 0.00000003, energy, tank);
    }

    @Override
    public void moveUp(){

    }
    
    @Override
    public void moveDown(){

    }

    
    private void crawl() {
        if (collideWithTank()==Collision.LEFT || collideWithTank()==Collision.RIGHT) {
            reverse();
        }
        Random rmd = new Random();
        double randomNumber = rmd.nextDouble();
        if (randomNumber<getThresholdReverse()) {
            reverse();
        }
        if (isFacingRight()) {
            moveRight();
        } else{
            moveLeft();
        }
    }

    public void update() {
        crawl();
    }

    @Override
    public int getOxygenConsumption() {
        return 1;
    }

    @Override
    public void breathe() {
        //TODO
    }


}