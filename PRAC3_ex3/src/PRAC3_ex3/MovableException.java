package PRAC3_ex3;

public class MovableException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final String MSG_ERR_SPEED_VALUE = "[ERROR] Speed cannot be 0 or negative !!";
    public static final String MSG_ERR_THRESHOLD_VALUE = "[ERROR] Threshold reverse cannot be negative either greater than 1!!";

    public MovableException() {
        super();
    }

    public MovableException(String msg) {
        super(msg);
    }
}