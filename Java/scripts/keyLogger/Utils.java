package scripts.keyLogger;

import java.awt.event.KeyEvent;
import java.util.List;

public final class Utils {

	public Utils() {
	}

	public static String rawPrint(List<KeyStorage> storage) {
		if (storage.isEmpty()) {
			return "Nothing has been pressed";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<br/> Raw Stroke Data: <br/>");
		for (KeyStorage ks : storage) {
			sb.append(ks.toString() + "\n");
		}
		return sb.toString();
	}

	public static String prettyPrint(List<KeyStorage> storage) {
		if (storage.isEmpty()) {
			return "Nothing has been pressed";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<br/> Pretty Stroke Data: <br/>");
		boolean[] caps = new boolean[256];
		for (KeyStorage ks : storage) {
			caps[ks.getKeyCode()] = ks.isPressed();
			String key = processKey(ks.getKeyCode(), caps[KeyEvent.VK_SHIFT]);
			if (ks.isPressed()) {
				if (caps[KeyEvent.VK_SHIFT]) {
					sb.append(key.toUpperCase());
				} else {
					sb.append(key.toLowerCase());
				}
			}
		}
		return sb.toString();

	}
	
	private static String processKey(int keyCode, boolean shifted) {
	      String key = KeyEvent.getKeyText(keyCode);
		  if (key.length() != 1) {
		   key = "{" + KeyEvent.getKeyText(keyCode) + "}";
		  }

		  if (keyCode == KeyEvent.VK_SHIFT) {
		   key = "";
		  }

		  if (keyCode == KeyEvent.VK_SPACE) {
		   key = " ";
		  }

		  if (keyCode == KeyEvent.VK_1 && shifted) {
		   key = "!";
		  }

		  if (keyCode == KeyEvent.VK_2 && shifted) {
		   key = "@";
		  }

		  if (keyCode == KeyEvent.VK_3 && shifted) {
		   key = "#";
		  }

		  if (keyCode == KeyEvent.VK_4 && shifted) {
		   key = "$";
		  }

		  if (keyCode == KeyEvent.VK_5 && shifted) {
		   key = "%";
		  }

		  if (keyCode == KeyEvent.VK_6 && shifted) {
		   key = "^";
		  }

		  if (keyCode == KeyEvent.VK_8 && shifted) {
		   key = "*";
		  }

		  if (keyCode == KeyEvent.VK_9 && shifted) {
		   key = "(";
		  }

		  if (keyCode == KeyEvent.VK_0 && shifted) {
		   key = ")";
		  }

		  if (keyCode == KeyEvent.VK_DEAD_ACUTE && shifted) {
		   key = "?";
		  }

		  if (keyCode == KeyEvent.VK_DEAD_ACUTE && !shifted) {
		   key = "/";
		  }

		  if (keyCode == KeyEvent.VK_PERIOD && shifted) {
		   key = "<";
		  }

		  if (keyCode == KeyEvent.VK_PERIOD && !shifted) {
		   key = ".";
		  }

		  if (keyCode == KeyEvent.VK_COMMA && shifted) {
		   key = ">";
		  }

		  if (keyCode == KeyEvent.VK_COMMA && !shifted) {
		   key = ",";
		  }

		  if (keyCode == KeyEvent.VK_QUOTE && !shifted) {
		   key = "'";
		  }

		  if (keyCode == KeyEvent.VK_QUOTE && shifted) {
		   key = "\"";
		  }

		  if (keyCode == KeyEvent.VK_SEMICOLON && shifted) {
		   key = ":";
		  }
		  return key;
	}
	
}
