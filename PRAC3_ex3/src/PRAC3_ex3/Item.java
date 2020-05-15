package PRAC3_ex3;

public class Item {
	
	private static int nextId = 0;
	private double xCoord, yCoord; //location
	private double length, height; // define size of item
	private String spriteImage;
	private Tank tank;
	private String id;
	
	
	protected Item(double xCoord, double yCoord, String spriteImage, double length, double height, Tank tank) throws ItemException {
		setId("I"+nextId); 
		nextId++;
		
		setLocation(xCoord,yCoord);
		setSpriteImage(spriteImage);		
		setLength(length);
		setHeight(height);		
		setTank(tank);
	}
	
	
	/**
	 * Set this item's location.
	 * 
	 * @param xCoord the column coordinate.
	 * @param yCoord the row coordinate.
	 */
	public void setLocation(double xCoord, double yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public double getXCoord() {
		return xCoord;
	}
	
	public double getYCoord() {
		return yCoord;
	}
	
	public double getLength() {
		return length;
	}

	public void setLength(double length) throws ItemException{
		if(length<=0) {
			throw new ItemException(ItemException.MSG_ERR_LENGTH_VALUE);
		}
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) throws ItemException{
		if(height<=0) {
			throw new ItemException(ItemException.MSG_ERR_HEIGHT_VALUE);
		}
		this.height = height;
	}
		
	public void setSpriteImage(String spriteImage) {

		this.spriteImage = spriteImage;
	}
	
	public String getSpriteImage() {		
		return spriteImage;
	}

	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}
/*
	public ItemStatus getStatus() {
		return status;
	}

	private void setStatus(ItemStatus status) {
		this.status = status;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) throws ItemException {
		if(energy<0 || energy>100) throw new ItemException(ItemException.MSG_ERR_ENERGY_RANGE_VALUE);
		
		if(this.energy!=0) {
			this.energy = energy;
		}else {
			throw new ItemException(ItemException.MSG_ERR_ENERGY_ZERO);
		}
		
		if(getEnergy()==0) {
			setStatus(ItemStatus.DEAD);
		}else if(getEnergy()<25) {
			setStatus(ItemStatus.SICK);
		}else {
			setStatus(ItemStatus.HEALTHY);
		}
	}
	
	public void incEnergy(int energy) throws ItemException{
		try{
			if(energy<0) throw new ItemException("[ERROR] Incorrect value!!"); //Este error no estaba especificado en el enunciado y no hacia falta codificarlo/controlarlo
			setEnergy(getEnergy()+energy);
		}catch(Exception e) {
			try{
				setEnergy(100);
			}catch(ItemException e2) {}
			throw new ItemException(ItemException.MSG_WARNING_ENERGY_AUTOMATIC_VALUE+100);
		}
	}
	
	public void decEnergy(int energy) throws ItemException{
		try{
			if(energy<0) throw new ItemException("[ERROR] Incorrect value!!"); //Este error no estaba especificado en el enunciado y no hacia falta codificarlo/controlarlo
			setEnergy(getEnergy()-energy);
		}catch(Exception e) {
			try{
				setEnergy(0);				
			}catch(ItemException e2) {}
			throw new ItemException(ItemException.MSG_WARNING_ENERGY_AUTOMATIC_VALUE+0);
		}
	}
	
	public boolean isDead() {
		return (getEnergy()==0); //TAMBIEN: return getStatus()==ItemStatus.DEAD;
	}
*/
	public Tank getTank() {
		return tank;
	}

	public void setTank(Tank tank){
		if(tank!=null) {
			if(!tank.getItems().contains(this)) {
					tank.getItems().add(this);
			}
		}
		
		if(this.tank!=null) {
			try{
				this.tank.removeItem(this);
			}catch(Exception e) {
				//removeItem: El item no existe ya en el tanque
			}
		}
				
		this.tank = tank;
	}


	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("(" + getXCoord() +",  "+ getYCoord() +") ");
				
		str.append(getId() + " ");
		//str.append(getEnergy() + " ");
		//str.append(getStatus() + " ");
		str.append(getLength() + " ");
		str.append(getHeight() + " ");
		str.append((getTank()!=null)?getTank().getName():"No tank");
		return str.toString();
	}
}