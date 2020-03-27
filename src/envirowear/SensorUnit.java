package envirowear;

/**
 * The SensorUnit class monitors temperature to then send commands
 * 	to either use the heat or cooling classes and appropriate methods. 
 *
 */
public class SensorUnit {
	
	private int desiredTemp = 0;
	private boolean heaterStatus;
	private boolean coolerStatus;
	private boolean e_override;
	
	//Constructor
	public SensorUnit() {
		desiredTemp = 0;
		setHeaterStatus(false);
		setCoolerStatus(false);
		setE_override(false);
	}
	
	//Getters
	public int getDesiredTemp() {
		return desiredTemp;
	}

	public boolean getHeaterStatus() {
		return heaterStatus;
	}

	public boolean getCoolerStatus() {
		return coolerStatus;
	}

	public boolean getE_override() {
		return e_override;
	}

	//Setters
	public void setDesiredTemp(int tempVal) {
		desiredTemp = tempVal;
	}
	
	public void setE_override(boolean override) {
		e_override = override;
	}

	public void setCoolerStatus(boolean status) {
		coolerStatus = status;
	}

	public void setHeaterStatus(boolean status) {
		heaterStatus = status;
	}
	
	//Methods
	public boolean initializeOverride() {
		//this needs logic
		return false;
	}
	
	private boolean initializeHeating() {
		//this needs logic
		return false;
	}
	
	private boolean initializeCooling() {
		//this needs logic
		return false;
	}
	
	private int getCurrentTemperature() {
		
		return 98;
	}
}
