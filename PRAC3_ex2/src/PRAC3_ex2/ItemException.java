package PRAC3_ex2;

public class ItemException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /***/
    public static final String MSG_ERR_THRESHOLD_VALUE = "[ERROR] Threshold reverse cannot be negative either greater than 1!!";
    public static final String MSG_ERROR_SPEED_VALUE = "[ERROR] Speed cannot be 0 or negative!!";
    public static final String MSG_ERR_LENGTH_VALUE = "[ERROR]: Item's length cannot negative either 0!!";
    public static final String MSG_ERR_HEIGHT_VALUE = "[ERROR]: Item's height cannot negative either 0!!";
	/***/

    public ItemException() {
        super();
    }
    public ItemException(String msg) {
        super(msg);
    }
}