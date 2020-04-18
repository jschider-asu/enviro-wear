package envirowear;


/**
 * The CoolingUnit class controls the operations needed to cool the
 * 	portion of clothing it is functioning within.
 *
 */
public class CoolingUnit extends Thread {
	
	private boolean running;
	private String type;
	private String position;
	

	//Constructor
	public CoolingUnit(String clothing, String pos) {
		running = false;
		type = clothing;
		position = pos;
	}
	

	public void run() {
		
	}
	
	//Getters
	public boolean getRunningStatus() {
		return running;
	}
	//Used for unit testing.
	public String getType() {
		return type;
	}
	//Used for unit testing.
	public String getPosition() {
		return position;
	}
	
	//Setters
	private void setRunningStatus(boolean runVal) {
		running = runVal;
	}
	
	
	//Methods
	public boolean startCooling() {
		boolean statusChanged = false;
		
		if (!getRunningStatus()) {
			setRunningStatus(true);
			statusChanged = true;
		}
		
		if(statusChanged == true) {
			userNotification();
		}
		
		
		//return if the status changed.
		return statusChanged;
	}
	
	public boolean stopCooling() {
		boolean statusChanged = false;
		
		if (getRunningStatus()) {
			setRunningStatus(false);
			statusChanged = true;
		}
		
		if(statusChanged == true) {
			userNotification();
		}
		
		//return if the status changed.
		return statusChanged;
		
	}
	
	private void userNotification() {
		if(type.equals("shirt")) {
			if(position.equals("front")) {
				main.setShirtCoolerFront(getRunningStatus());
			} else {
				main.setShirtCoolerBack(getRunningStatus());
			}
		} else {
			if(position.equals("front")) {
				main.setPantsCoolerFront(getRunningStatus());
			} else {
				main.setPantsCoolerBack(getRunningStatus());
			}
		}
	}
}
