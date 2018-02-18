package scripts.keyLogger;

public class KeyStorage {
	
	private int keyCode;
	private boolean pressed;
	private long timePressedMillis;
	
	public KeyStorage(int keyCode, boolean pressed, long timePressedMillis) {
		this.keyCode = keyCode;
		this.pressed = pressed;
		this.timePressedMillis = timePressedMillis;
	}

	public int getKeyCode() {
		return keyCode;
	}

	public boolean isPressed() {
		return pressed;
	}

	public long getTimePressedMillis() {
		return timePressedMillis;
	}

	@Override
	public String toString() {
		return "KeyStorage [keyCode=" + keyCode + ", pressed=" + pressed + ", timePressedMillis=" + timePressedMillis
				+ "]";
	}
	
	
	
}
