package PRAC3_ex3;

public abstract class Fish  extends Animal{
    
    private Color color;

    protected Fish(double xCoord, double yCoord, String spriteImage, double length, double height, Gender gender, int age, double speed, double requiredFoodQuantity, float thresholdReverse, AnimalStatus status, int energy, Color color, Tank tank) throws MovableException, AnimalException, IllegalAccessError, Exception{
        super(xCoord, yCoord, spriteImage, length, height, gender, age, speed, requiredFoodQuantity, thresholdReverse, energy, tank);

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}