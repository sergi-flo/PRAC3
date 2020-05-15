package PRAC3_ex2;

public class Food extends Item{

    private double speed;
    private boolean eaten;
    private int energy;

    public Food (double xCoord, double yCoord, double length, double height, int energy, Tank tank, String spriteImage) throws AnimalException, ItemException, Exception{
        super(xCoord, yCoord, spriteImage,length, height, tank);
        setSpeed(1.0);
        setEnergy(energy);
    }

    public void setSpeed(double speed) throws AnimalException {
        if (speed <= 0) {
            throw new AnimalException(AnimalException.MSG_ERROR_SPEED_VALUE);
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
}