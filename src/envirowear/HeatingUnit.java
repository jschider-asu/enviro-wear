package envirowear;


/**
 * The HeatingUnit class controls the operations needed to heat
 * the clothing portion where the SRC is running the code.
 * 
 */
public class HeatingUnit extends Thread {
	
	private boolean running;
	private String type;
	private String position;
	
	//Constructor
	public HeatingUnit(String clothing, String pos) {
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
	public boolean startHeating() {
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
	
	public boolean stopHeating() {
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
				main.setShirtHeaterFront(getRunningStatus());
			} else {
				main.setShirtHeaterBack(getRunningStatus());
			}
		} else {
			if(position.equals("front")) {
				main.setPantsHeaterFront(getRunningStatus());
			} else {
				main.setPantsHeaterBack(getRunningStatus());
			}
		}
	}

}
