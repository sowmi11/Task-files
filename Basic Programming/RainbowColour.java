package programtask;


public enum RainbowColour {
	VIOLET(1),INDIGO(2),BLUE(3),GREEN(4),YELLOW(5),ORANGE(6),RED(7);
	
	private final int colorCode;
	private RainbowColour(int colourCode) {
		colorCode=colourCode;
	}
	public int getColorCode() {
		return colorCode;
	}
	public static RainbowColour[] getValues() {
		return RainbowColour.values();
	}
}


