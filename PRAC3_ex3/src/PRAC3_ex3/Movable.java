package PRAC3_ex3;

public interface Movable{

    public static final int TANK_PANE_WIDTH = 404;
    public static final int TANK_PANE_HEIGHT = 346;

    public void moveLeft();

    public void moveRight();

    public void moveUp();

    public void moveDown();

    public Collision collideWithTank();

    public void update();

    public void setSpeed(double speed) throws MovableException;

    public double getSpeed();

    public void setThresholdReverse(double thresholdReverse) throws MovableException;

    public double getThresholdReverse();

    public boolean isFacingRight();

    public void reverse();

}