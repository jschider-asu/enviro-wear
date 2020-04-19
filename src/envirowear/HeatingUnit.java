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
	public HeatingUnit() {
		running = false;
		type = "";
		position = "";
	}
	
	public void run() {

	}
		
	
	//Getters
	public boolean getRunningStatus() {
		return running;
	}
	
	//used for unit testing
	public String getType() {
		return type;
	}
	
	//used for unit testing
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
	
	public void setType(String clothing) {
		type = clothing;
	}
	
	public void setPos(String pos) {
		position = pos;
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
