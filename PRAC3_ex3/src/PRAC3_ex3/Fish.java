package PRAC3_ex3;

import java.util.Random;

public abstract class Fish extends Animal {
    
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

    private void swim() {
        if (isDead()){
            if (collideWithTank()!=Collision.BOTTOM){
                moveDown();
            }
        }else{
            if (collideWithTank()==Collision.LEFT || collideWithTank()==Collision.LEFT) {
                reverse();
            } else if (collideWithTank()==Collision.TOP) {
                moveDown();
            } else if (collideWithTank()==Collision.BOTTOM) {
                moveUp();
            } else {
                Random rmd = new Random();
                double randomNumber = rmd.nextDouble();
                if (randomNumber<getThresholdReverse()) {
                    reverse();
                } else {
                    double randomNumber2 = rmd.nextDouble();
                    if (randomNumber2>=0.9) {
                        moveDown();
                    } else if (randomNumber2>=0.8 && randomNumber2<0.9) {
                        moveUp();
                    } else {
                        if (isFacingRight()) {
                            moveRight();
                        } else{
                            moveLeft();
                        }
                    }
                }
            }
        }
    }

    public void update() throws AnimalException{
        swim();
        eat();
    }

    @Override
	public String toString() {
		StringBuilder str = new StringBuilder("("+getXCoord()+", "+getYCoord()+") ");
	
		if (isFacingRight()){
            str.append("L ");
        } else {
            str.append("R ");
        }
        str.append(getGender()+" : ");
        str.append(color.name()+"\n");
		
		return str.toString();
    }
}