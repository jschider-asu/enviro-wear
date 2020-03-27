package envirowear;


/**
 * The CoolingUnit class controls the operations needed to cool the
 * 	portion of clothing it is functioning within.
 *
 */
public class CoolingUnit {
	
	private boolean running;
	private boolean fan;
	

	//Constructor
	public CoolingUnit() {
		running = false;
		fan = false;
	}
	
	//Getters
	public boolean getRunningStatus() {
		return running;
	}
	
	public boolean getFanStatus() {
		return fan;
	}
	
	//Setters
	private void setRunningStatus(boolean runVal) {
		running = runVal;
	}
	
	private void setFanStatus(boolean fanVal) {
		fan = fanVal;
	}
	
	//Methods
	public boolean startCooling(int desiredTemp) {
		boolean statusChanged = false;
		
		if (!getRunningStatus()  && !getFanStatus()) {
			setRunningStatus(true);
			setFanStatus(true);
			statusChanged = true;
		}
		
		
		//return if the status changed.
		return statusChanged;
	}
	
	public boolean stopCooling() {
		boolean statusChanged = false;
		
		if (getRunningStatus() && getFanStatus()) {
			setRunningStatus(false);
			setFanStatus(false);
			statusChanged = true;
		}
		
		//return if the status changed.
		return statusChanged;
		
	}
}
