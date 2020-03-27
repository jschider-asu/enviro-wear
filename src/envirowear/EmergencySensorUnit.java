package envirowear;

/**
 * The EmergencySensorUnit class monitors temperature to then send commands
 * 	to either use the heat or cooling classes and appropriate methods
 *  when conditions become unsafe or outside acceptable bounds.
 *
 */
public class EmergencySensorUnit {
	
	private boolean e_heaterSatus;
	private boolean e_coolerStatus;
	
	//Getters
	public boolean getE_heaterSatus() {
		return e_heaterSatus;
	}
	
	public boolean getE_coolerStatus() {
		return e_coolerStatus;
	}
	
	//Setters
	public void setE_heaterSatus(boolean e_status) {
		e_heaterSatus = e_status;
	}

	public void setE_coolerStatus(boolean e_status) {
		e_coolerStatus = e_status;
	}
	
	//Methods
	public boolean getHeaterOverrideStatus() {
		//needs to return the sensor unit statuses?
		return false;
	}
	
	public boolean getCoolerOverrideStatus() {
		//needs to return the sensor unit statuses?
		return false;
	}
	
	private void overrideHeating() {
		
	}
	
	private void overrideCooling() {
		
	}
	
	private void cancelOverride() {
		
	}
	
	private int getCurrentBodyTemperature() {
		
		return 98;
	}
	
	
}
