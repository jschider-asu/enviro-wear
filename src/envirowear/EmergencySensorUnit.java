package envirowear;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The EmergencySensorUnit class monitors temperature to then send commands
 * 	to either use the heat or cooling classes and appropriate methods
 *  when conditions become unsafe or outside acceptable bounds.
 *
 */
public class EmergencySensorUnit extends Thread {
	
	private boolean emergencyoverride;
	private boolean e_heaterStatus;
	private boolean e_coolerStatus;
	private double bodyTemp;
	private boolean lowerBodyTemp;
	private boolean raiseBodyTemp;
	private int desiredTemperature;
	private String type = "";
	
	
	public EmergencySensorUnit(String clothing) {
		emergencyoverride = false;
		e_heaterStatus = false;
		e_coolerStatus = false;
		bodyTemp = 98.5;
		lowerBodyTemp = false;
		raiseBodyTemp = false;
		type = clothing;
		desiredTemperature = 0;
	}
	
	public void run() {
		SensorUnit su= new SensorUnit(type, desiredTemperature);
		su.start();
		while (currentThread().isAlive()) {
			bodyTemperatureSensor();
			userNotificationTemp();	
			if(getCurrentBodyTemperature() < 95.5) {
				if(getE_heaterStatus() != true) {
					setOverride(true);
					setE_heaterStatus(true);
					raiseBodyTemp();
					su.setEmergencyOverride(true);
					su.setEmergencyHeating(true);
					userNotification(true, "heating");
					
				}
			} else if (getCurrentBodyTemperature() > 102.5) {
				if(getE_coolerStatus() != true) {
					setOverride(true);
					setE_coolerStatus(true);
					lowerBodyTemp();
					lowerBodyTemp = true;
					su.setEmergencyOverride(true);
					su.setEmergencyCooling(true);
					userNotification(true, "cooling");
				}
			} else {
				if(getOverride() == true && bodyTemp > 99 || bodyTemp < 98) {
				} else {
					if(getE_heaterStatus() == true || getE_coolerStatus() == true) {
						setOverride(false);
						setE_heaterStatus(false);
						su.setEmergencyHeating(false);
						setE_coolerStatus(false);
						su.setEmergencyCooling(false);
						su.setEmergencyOverride(false);
						lowerBodyTemp = false;
						raiseBodyTemp = false;
						userNotification(false, "");
					}
				}
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
		}
	}
	
	//Getters
	public void setDesiredTemp(int temp) {
		desiredTemperature = temp;
	}
	
	public boolean getE_heaterStatus() {
		return e_heaterStatus;
	}
	
	public boolean getE_coolerStatus() {
		return e_coolerStatus;
	}
	
	//Setters
	public void setE_heaterStatus(boolean e_status) {
		e_heaterStatus = e_status;
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
	
	private void setOverride(boolean setting) {
		emergencyoverride = setting;
	}
	
	public boolean getOverride() {
		return emergencyoverride;
	}
	
	private double getCurrentBodyTemperature() {
		return bodyTemp;
	}
	
	//used in unit testing
	public boolean getLowerBodyTemp() {
		return lowerBodyTemp;
	}
	//used in unit testing
	public boolean getRaiseBodyTemp() {
		return raiseBodyTemp;
	}
	
	
	private void bodyTemperatureSensor() {
		if(lowerBodyTemp == true) {
			bodyTemp = bodyTemp - .5;
		} else if(raiseBodyTemp == true) {
			bodyTemp = bodyTemp + .5;
		}
	}
	
	public void lowerBodyTemp() {
		raiseBodyTemp = false;
		lowerBodyTemp = true;
	}
	
	public void raiseBodyTemp() {
		lowerBodyTemp = false;
		raiseBodyTemp = true;
	}
	
	private void userNotification(boolean override, String tempControl) {
		if(type.equals("shirt")) {
			main.setShirtEmergencyOverride(override, tempControl);
		} else {
			main.setPantsEmergencyOverride(override, tempControl);
		}
	}
	
	private void userNotificationTemp() {
		if(type.equals("shirt")) {
			main.setShirtBodyTemp(getCurrentBodyTemperature());
		} else {
			main.setPantsBodyTemp(getCurrentBodyTemperature());
		}
	}
	
}
