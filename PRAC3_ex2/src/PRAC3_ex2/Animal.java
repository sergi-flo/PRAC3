package PRAC3_ex2;

public class Animal extends Item {

    private AnimalGender gender;
    private int age;
    private boolean facingRight;
    private double speed;
    private double requieredFoodQuantity;
    private double thresholdReverse;
    private int energy;
    private AnimalStatus status;


    protected Animal (double xCoord, double yCoord, String spriteImage, double length, double height, AnimalGender gender, int age, double speed, double requieredFoodQuantity, double thresholdReverse, int energy, Tank tank) throws AnimalException,ItemException{
        super(xCoord, yCoord, spriteImage, length, height, tank);
        setGender(gender);
        setAge(age);
        setFacingRight(true);
        setSpeed(speed);
        setRequiredFoodQuantaty(requieredFoodQuantity);
        setThresholdReverse(thresholdReverse);
        setEnergy(100);
    }

    public void setGender (AnimalGender gender){
        this.gender = gender;
    }

    public AnimalGender getGender() {
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

    public void setSpeed(double speed) throws AnimalException{
        if (speed <= 0){
            throw new AnimalException(AnimalException.MSG_ERROR_SPEED_VALUE);
        }
        this.speed = speed;
    }

    public double getspeed () {
        return this.speed;
    }

    public void setRequiredFoodQuantaty (double requieredFoodQuantity) {
        this.requieredFoodQuantity = requieredFoodQuantity;
    }

    public double getRequiredFoodQuantity () {
        return this.requieredFoodQuantity;
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

}
