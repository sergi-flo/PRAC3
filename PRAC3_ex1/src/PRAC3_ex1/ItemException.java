package PRAC3_ex1;

public class ItemException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /***/
    public static final String MSG_ERR_ENERGY_RANGE_VALUE = "[ERROR] Item's energy cannot negative either greater than 100!!";
    public static final String MSG_ERR_ENERGY_ZERO = "[ERROR] Item's energy is zero. This value cannot be modified!!";
    public static final String MSG_WARNING_ENERGY_AUTOMATIC_VALUE = "[WARNING] Item's energy has been assigned to ";
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