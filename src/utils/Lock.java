package utils;

import javafx.application.Platform;

public enum Lock {

	INSTANCE;

	private Object lockObject = new Object();
	private Runnable runnable = null;
	private boolean lock = false;

	private Lock() {

	}

	public void lock() {

		if (this.lock) {

			Logger.INSTANCE.logNewLine("already locked");
			return;

		}

		this.lock = true;
		Logger.INSTANCE.log("lock");
		CursorFX.INSTANCE.setWait();
		Platform.enterNestedEventLoop(this.lockObject);

	}

	public void unlock() {

		if (!this.lock) {

			Logger.INSTANCE.logNewLine("unlocked fail");
			return;

		}

		Logger.INSTANCE.logNewLine("unlock");

		this.lock = false;
		CursorFX.INSTANCE.setDefault();
		Platform.exitNestedEventLoop(this.lockObject, null);

		if (this.runnable == null)
			return;

		Logger.INSTANCE.logNewLine("executing runnable");

	}

}
