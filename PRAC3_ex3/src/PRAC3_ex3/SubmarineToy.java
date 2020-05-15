package PRAC3_ex3;

import java.util.Random;

public class SubmarineToy extends Item implements Movable{

    private double speed;
    private boolean facingRight;
    private double thresholdReverse;
    private int balanceMove = 0;
    private final int TURN_BALANÇ_MOVE=100;

    public SubmarineToy (double xCoord, double yCoord, double length, double height, Tank tank) throws AnimalException, ItemException, MovableException {
        super(xCoord, yCoord, "./images/submarine/submarine.png", length, height, tank);
        setSpeed(1);
        setFacingRight(true);
        setThresholdReverse(0.0003);
    }

    public void setSpeed(double speed) throws MovableException{
        if (speed <= 0) {
            throw new MovableException(MovableException.MSG_ERR_SPEED_VALUE);
        }
        this.speed = speed;
    } 

    public double getSpeed() {
        return this.speed;
    }
    
    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public boolean isFacingRight() {
        return this.facingRight;
    }

    public void setThresholdReverse (double thresholdReverse) throws MovableException {
        if (thresholdReverse<0 || thresholdReverse>1) {
            throw new MovableException(MovableException.MSG_ERR_THRESHOLD_VALUE);
        }
        this.thresholdReverse =  thresholdReverse;
    }

    public double getThresholdReverse () {
        return this.thresholdReverse;
    }

    //REVISAR!!!!!REVISAR!!!!REVISAR!!!
    public void reverse () { //REVISAR!!!!!!!!!!!!!!!!REVISAR!!!!!!!!!!!!!
        this.facingRight = !this.facingRight;
    }

    public void moveLeft() {
        setLocation(getXCoord()-getSpeed(), getYCoord()); 
    }

    public void moveRight() {
        setLocation(getXCoord()+getSpeed(), getYCoord()); 
    }
    public void moveUp() {
        setLocation(getXCoord(), getYCoord()-getSpeed()); 
    }
    public void moveDown() {
        setLocation(getXCoord(), getYCoord()+getSpeed()); 
    }

    public Collision collideWithTank() {
        Collision returnValue = Collision.NO_COLLISION;

        if (!isFacingRight() && (getXCoord()<3)){
            returnValue = Collision.LEFT;
        } else if (isFacingRight() && ((Movable.TANK_PANE_WIDTH-getXCoord())<60)) {
            returnValue = Collision.RIGHT;
        } else if (getYCoord()<5) {
            returnValue = Collision.TOP;
        } else if ((Movable.TANK_PANE_HEIGHT-getYCoord())<45) {
            returnValue = Collision.BOTTOM;
        }

        return returnValue;
    }

    private void move() {
        if (this.balanceMove>0) {
            moveDown();
            this.balanceMove += 1;
        } else if (this.balanceMove<0) {
            moveUp();
            this.balanceMove -= 1;
        } else {  
            if (collideWithTank()==Collision.LEFT || collideWithTank()==Collision.RIGHT) {
                reverse();
            } else if (collideWithTank()==Collision.TOP){
                this.balanceMove = TURN_BALANÇ_MOVE;
            } else if (collideWithTank()==Collision.BOTTOM){
                this.balanceMove = TURN_BALANÇ_MOVE*-1;
            } else {
                Random rmd = new Random();
                double randomNumber = rmd.nextDouble();
                if (randomNumber<this.thresholdReverse) {
                    reverse();
                } else {
                    if (isFacingRight()) {
                        moveRight();
                    } else{
                        moveLeft();
                    }
                    double randomNumber2 = rmd.nextDouble();
                    if (randomNumber2<0.48) {
                        moveUp();
                    } else {
                        moveDown();
                    } 
                }
            }
        }
    }

    public void update() {
        move();
    }
}