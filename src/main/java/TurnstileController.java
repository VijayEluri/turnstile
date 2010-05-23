public interface TurnstileController {
 public void lock();
 public void unlock();
 public void thankyou();
 public void alarm();
 public boolean getAlarmStatus();
 public boolean getLockStatus();
 public boolean getUnLockStatus();
 public boolean getThankyouStatus();
}