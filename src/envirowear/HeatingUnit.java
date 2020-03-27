package envirowear;


/**
 * The HeatingUnit class controls the operations needed to heat
 * the clothing portion where the SRC is running the code.
 * 
 */
public class HeatingUnit {
	
	private boolean running;
	private boolean fan;
	private int fanDelay;
	

	//Constructor
	public HeatingUnit() {
		running = false;
		fan = false;
		fanDelay = 10;
	}
	
	//Getters
	public boolean getRunningStatus() {
		return running;
	}
	
	public boolean getFanStatus() {
		return fan;
	}
	
	public int getFanDelay() {
		return fanDelay;
	}
	
	//Setters
	private void setRunningStatus(boolean runVal) {
		running = runVal;
	}
	
	private void setFanStatus(boolean fanVal) {
		fan = fanVal;
	}
	
	public void setFanDelay(int delayVal) {
		fanDelay = delayVal;
	}
	
	//Methods
	public boolean startHeating(int desiredTemp) {
		boolean statusChanged = false;
		
		if (!getRunningStatus()  && !getFanStatus()) {
			setRunningStatus(true);
			setFanStatus(true);
			statusChanged = true;
		}
		
		
		//return if the status changed.
		return statusChanged;
	}
	
	public boolean stopHeating() {
		boolean statusChanged = false;
		
		if (getRunningStatus() && getFanStatus()) {
			setRunningStatus(false);
			
			//need to add logic to use the fanDelay getter and delay calling setFanStatus.
			setFanStatus(false);
			statusChanged = true;
		}
		
		//return if the status changed.
		return statusChanged;
		
	}

}
