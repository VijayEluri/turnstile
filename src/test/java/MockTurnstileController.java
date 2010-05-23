
public class MockTurnstileController implements TurnstileController {

	private boolean lockCalled = false;
	private boolean unlockCalled = false;
	private boolean thankyouCalled = false;
	private boolean alarmCalled = false;
	
	public void alarm() {
		alarmCalled = true;

	}

	public void lock() {
		lockCalled = true;

	}

	public void thankyou() {
		thankyouCalled = true;

	}

	public void unlock() {
		unlockCalled = true;

	}
	
	public boolean getAlarmStatus() {
		return alarmCalled;
	}

	public boolean getLockStatus() {
		return lockCalled;
	}

	public boolean getUnLockStatus() {
		return unlockCalled;
	}

	public boolean getThankyouStatus() {
		return thankyouCalled;
	}
	
}
