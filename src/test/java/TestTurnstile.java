import junit.framework.TestCase;

public class TestTurnstile extends TestCase {
	
	public void testIntitialConditions() {
		TurnstileController mockTurnstileController = new MockTurnstileController();
		Turnstile turnstile = new Turnstile(mockTurnstileController);		
		assertEquals(Turnstile.LOCKED,turnstile.state);
	}
	
	public void testCoinInLockedState() {
		TurnstileController mockTurnstileController = new MockTurnstileController();
		Turnstile turnstile = new Turnstile(mockTurnstileController);
		turnstile.state = Turnstile.LOCKED;
		turnstile.event(Turnstile.COIN);
		assertEquals(Turnstile.UNLOCKED,turnstile.state);
		assert(mockTurnstileController.getUnLockStatus());
	}

	public void testCoinInUnLockedState() {
		TurnstileController mockTurnstileController = new MockTurnstileController();
		Turnstile turnstile = new Turnstile(mockTurnstileController);
		turnstile.state = Turnstile.UNLOCKED;
		turnstile.event(Turnstile.COIN);
		assertEquals(Turnstile.UNLOCKED,turnstile.state);
		assert(mockTurnstileController.getThankyouStatus());
	}

	public void testPassInUnLockedState() {
		TurnstileController mockTurnstileController = new MockTurnstileController();
		Turnstile turnstile = new Turnstile(mockTurnstileController);
		turnstile.state = Turnstile.UNLOCKED;
		turnstile.event(Turnstile.PASS);
		assertEquals(Turnstile.LOCKED,turnstile.state);
		assert(mockTurnstileController.getLockStatus());
	}
	
}
