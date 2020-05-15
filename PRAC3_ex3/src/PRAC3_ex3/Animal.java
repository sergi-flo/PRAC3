package PRAC3_ex3;

public abstract class Animal extends Item implements Movable {

    private Gender gender;
    private int age;
    private boolean facingRight;
    private double speed;
    private double requiredFoodQuantity;
    private double thresholdReverse;
    private int energy;
    private AnimalStatus status;


    protected Animal (double xCoord, double yCoord, String spriteImage, double length, double height, Gender gender, int age, double speed, double requiredFoodQuantity, double thresholdReverse, int energy, Tank tank) throws AnimalException, ItemException, MovableException, Exception{
        super(xCoord, yCoord, spriteImage, length, height, tank);
        setGender(gender);
        setAge(age);
        setFacingRight(true);
        setSpeed(speed);
        setRequiredFoodQuantaty(requiredFoodQuantity);
        setThresholdReverse(thresholdReverse);
        setEnergy(100);
    }

    public void setGender (Gender gender){
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setAge(int age) throws AnimalException {
        if (age<0) {
            throw new AnimalException(AnimalException.MSG_ERR_AGE_VALUE);
        }
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public boolean isFacingRight() {
        return this.facingRight;
    }

    public void setSpeed(double speed) throws MovableException{
        if (speed <= 0){
            throw new MovableException(MovableException.MSG_ERR_SPEED_VALUE);
        }
        this.speed = speed;
    }

    public double getSpeed () {
        return this.speed;
    }

    public void setRequiredFoodQuantaty (double requiredFoodQuantity) {
        this.requiredFoodQuantity = requiredFoodQuantity;
    }

    public double getRequiredFoodQuantity () {
        return this.requiredFoodQuantity;
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

    public AnimalStatus getStatus() {
		return status;
	}

	private void setStatus(AnimalStatus status) {
		this.status = status;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) throws AnimalException {
		if(energy<0 || energy>100) throw new AnimalException(AnimalException.MSG_ERR_ENERGY_RANGE_VALUE);
		
		if(this.energy!=0) {
			this.energy = energy;
		}else {
			throw new AnimalException(AnimalException.MSG_ERR_ENERGY_ZERO);
		}
		
		if(getEnergy()==0) {
			setStatus(AnimalStatus.DEAD);
		}else if(getEnergy()<25) {
			setStatus(AnimalStatus.SICK);
		}else {
			setStatus(AnimalStatus.HEALTHY);
		}
	}
	
	public void incEnergy(int energy) throws AnimalException{
		try{
			if(energy<0) throw new AnimalException("[ERROR] Incorrect value!!"); //Este error no estaba especificado en el enunciado y no hacia falta codificarlo/controlarlo
			setEnergy(getEnergy()+energy);
		}catch(Exception e) {
			try{
				setEnergy(100);
			}catch(AnimalException e2) {}
			throw new AnimalException(AnimalException.MSG_WARNING_ENERGY_AUTOMATIC_VALUE+100);
		}
	}
	
	public void decEnergy(int energy) throws AnimalException{
		try{
			if(energy<0) throw new AnimalException("[ERROR] Incorrect value!!"); //Este error no estaba especificado en el enunciado y no hacia falta codificarlo/controlarlo
			setEnergy(getEnergy()-energy);
		}catch(Exception e) {
			try{
				setEnergy(0);				
			}catch(AnimalException e2) {}
			throw new AnimalException(AnimalException.MSG_WARNING_ENERGY_AUTOMATIC_VALUE+0);
		}
	}
	
	public boolean isDead() {
		return (getEnergy()==0); //TAMBIEN: return getStatus()==ItemStatus.DEAD;
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

    public abstract int getOxygenConsumption();

    public abstract void breathe();

    public void eat() throws AnimalException{
        if (!isDead()) {
            for (Item item : getTank().getFood()){
                if(
                ((getXCoord()-item.getXCoord())<5) && 
                ((getYCoord()-item.getYCoord())<8) &&
                ((getXCoord()-item.getXCoord())>-5) &&
                ((getYCoord()-item.getYCoord())>-8)
                ){
                    Food foodItem = (Food) item;
                    foodItem.eaten();
                    incEnergy(foodItem.getEnergy());
                }
            }
        }
    }

    @Override
	public String toString() {
		StringBuilder str = new StringBuilder("("+getXCoord()+", "+getYCoord()+") ");
	
		if (isFacingRight()){
            str.append("L ");
        } else {
            str.append("R ");
        }
		str.append(getGender()+"\n");
		
		return str.toString();
    }
    
}
