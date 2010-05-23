
public class Turnstile {
	
	//States 
	public static final int LOCKED=0;
	public static final int UNLOCKED=1;
	
	//Events
	public static final int COIN =0;
	public static final int PASS =1;
	
	int state = LOCKED;
	
	private TurnstileController turnstileController;
	
	public Turnstile(TurnstileController turnstileController){
		this.turnstileController = turnstileController;
	}
	
	public void event(int event) {
		switch(state) {
		case LOCKED:
			switch(event) {
			case COIN:
				state = UNLOCKED;
			    turnstileController.unlock();
			    break;
			case PASS:
				turnstileController.alarm();
				break;
			}
			break;
		case UNLOCKED:
			switch(event) {
			case COIN:
			    turnstileController.thankyou();
			    break;
			case PASS:
				state = LOCKED;
				turnstileController.lock();
				break;
			}
			break;			
		}
	}

}