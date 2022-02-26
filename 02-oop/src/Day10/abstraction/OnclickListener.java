package Day10.abstraction;

public interface OnclickListener {
	public static final int FONT_SIZE = 12;
	String FONT_FAMILY = "Arial";
	
	public abstract void onClick();
	void onDoubleClick();

}
