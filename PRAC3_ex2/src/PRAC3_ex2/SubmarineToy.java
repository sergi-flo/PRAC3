package PRAC3_ex2;

public class SubmarineToy extends Item{

    private double speed;
    private boolean facingRight;
    private double thresholdReverse;

    public SubmarineToy (double xCoord, double yCoord, double length, double height, Tank tank) throws AnimalException, ItemException{
        super(xCoord, yCoord, "./images/submarine/submarine.png", length, height, tank);
        setSpeed(1);
        setFacingRight(true);
        setThresholdReverse(0.0003);
    }

    public void setSpeed(double speed) throws AnimalException{
        if (speed <= 0) {
            throw new AnimalException(AnimalException.MSG_ERROR_SPEED_VALUE);
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

    public void setThresholdReverse (double thresholdReverse) throws AnimalException {
        if (thresholdReverse<0 || thresholdReverse>1) {
            throw new AnimalException(AnimalException.MSG_ERR_THRESHOLD_VALUE);
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
}