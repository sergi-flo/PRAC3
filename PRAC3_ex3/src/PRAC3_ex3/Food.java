package PRAC3_ex3;

public class Food extends Item implements Movable{

    private double speed;
    private boolean eaten = false;
    private int energy;

    public Food (double xCoord, double yCoord, double length, double height, int energy, Tank tank, String spriteImage) throws AnimalException, ItemException, MovableException, Exception{
        super(xCoord, yCoord, spriteImage,length, height, tank);
        setSpeed(1.0);
        setEnergy(energy);
    }

    public void setSpeed(double speed) throws MovableException {
        if (speed <= 0) {
            throw new MovableException(MovableException.MSG_ERR_SPEED_VALUE);
        }
        this.speed = speed;
    }

    public double getSpeed() {
        return this.speed;
    }

    public boolean isEaten() {
        return this.eaten;
    }

    public void eaten() {
        this.eaten = true;
    }

    private void setEnergy(int energy) throws Exception {
        if (energy<1 || energy>10) {
            throw new Exception("[ERROR] Food cannot be less than 1 either greater than 10!!");
        }
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }
    
    public void moveLeft(){}

    public void moveRight(){}

    public void moveUp(){}

    public void moveDown(){
        setLocation(getXCoord(), getYCoord()+getSpeed());
    }

    public Collision collideWithTank() {
        Collision returnValue = Collision.NO_COLLISION;
        if ((Movable.TANK_PANE_HEIGHT-getYCoord())<20) {
            returnValue = Collision.BOTTOM;
        }

        return returnValue;
    }

    private void sink() {
        if (collideWithTank()==Collision.NO_COLLISION) {
            moveDown();
        }
    }
    public void update(){
        sink();
    }

    public void setThresholdReverse(double thresholdReverse) throws MovableException{}

    public double getThresholdReverse() {
        return 0.01;
    }

    public boolean isFacingRight() {
        return true;
    }

    public void reverse(){}
}