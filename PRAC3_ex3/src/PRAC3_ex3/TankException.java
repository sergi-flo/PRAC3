package PRAC3_ex3;

public class TankException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /***/
    public static final String MSG_ERR_NAME_LONGER = "[ERROR] Name cannot be longer than 40 characters!!";
    public static final String MSG_ERR_LENGTH_VALUE = "[ERROR] Length cannot be less than 0.1 cm.!!";
    public static final String MSG_ERR_HEIGHT_VALUE = "[ERROR] Height cannot be less than 0.1 cm.!!";
    public static final String MSG_ERR_WIDTH_VALUE = "[ERROR] Width cannot be less than 0.1 cm.!!";
    public static final String MSG_ERR_PH_VALUE = "[ERROR] PH must be a value between 0 and 14";
    public static final String MSG_ERR_ITEM_NOT_OBJECT = "[ERROR] Item must be an Item object!!";
    public static final String MSG_ERR_ITEM_IN_TANK = "[ERROR] The item which you want to add is already in the tank!!";
    public static final String MSG_ERR_ITEM_NOT_EXIST= "[ERROR] The item does not exist in the tank";
	/***/
 
    public TankException() {
        super();
    }
    public TankException(String msg) {
        super(msg);
    }
}