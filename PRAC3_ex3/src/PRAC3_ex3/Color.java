package PRAC3_ex3;

public enum Color {
	YELLOW("#FFFF00"), 
	RED("#FF0000"), 
	GREEN("#00FF00"), 
	BLUE("#0000FF"), 
	GRAY ("#888888"),
	WHITE ("#FFFFFF"), 
	BLACK ("#000000"), 
	ORANGE ("#FF8300"), 
	BRONZE ("#CD7F32"),
	NOT_DEFINED ("#");

	private final String code;

	private Color(String code) {
		this.code = code;
	}

	public String getHexCode() {
		return code;
	}

	public static String getColor(String code) {
        for (int i = 0; i < Color.values().length; i++) {
            if (code.equals(Color.values()[i].code))
                return Color.values()[i].name();
        }
        return Color.NOT_DEFINED.name();
    }
} 