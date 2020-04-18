package envirowear;

import java.util.Set;

/**
 * The SensorUnit class monitors temperature to then send commands
 * 	to either use the heat or cooling classes and appropriate methods. 
 *
 */
public class SensorUnit extends Thread {
	
	private int desiredTemp;
	private boolean heaterStatus;
	private boolean coolerStatus;
	private boolean e_override;
	private String type;
	private int front_temp;
	private int back_temp;
	private boolean front_cool;
	private boolean back_cool;
	private boolean e_heating;
	private boolean e_cooling;
	
	//Constructor
	public SensorUnit(String clothing, int desiredTemperature) {
		desiredTemp = desiredTemperature;
		setHeaterStatus(false);
		setCoolerStatus(false);
		setEmergencyOverride(false);
		type = clothing;
		front_temp = 75;
		back_temp = 75;
		front_cool = false;
		back_cool = false;
		e_heating = false;
		e_cooling = false;
	}
	
	public void run() {
		HeatingUnit hu_front = new HeatingUnit(type, "front");
		hu_front.start();
		HeatingUnit hu_back = new HeatingUnit(type, "back");
		hu_back.start();
		CoolingUnit cu_front = new CoolingUnit(type, "front");
		cu_front.start();
		CoolingUnit cu_back = new CoolingUnit(type, "back");
		cu_back.start();
		
		
		
		while(currentThread().isAlive()) {
			userNotification();
			
			if(getEmergencyOverride() == true) {
				if(e_heating == true) {
					hu_front.startHeating();
					hu_back.startHeating();
					cu_front.stopCooling();
					cu_back.stopCooling();
					front_cool = false;
					back_cool = false;
				} else if (e_cooling == true) {
					cu_front.startCooling();
					cu_back.startCooling();
					hu_front.stopHeating();
					hu_back.stopHeating();
					front_cool = true;
					back_cool = true;
				} else {
					System.out.println("An error has been detected in the emergency override system");
				}
				
			} else {
			
				if(getCurrentFrontTemperature() > getDesiredTemp()) {
					cu_front.startCooling();
					hu_front.stopHeating();
					front_cool = true;
				} else if (getCurrentFrontTemperature() < getDesiredTemp()) {
					cu_front.stopCooling();
					hu_front.startHeating();
					front_cool = false;
				} else {
					cu_front.stopCooling();
					hu_front.stopHeating();
				}
				
				if(getCurrentBackTemperature() > getDesiredTemp()) {
					cu_back.startCooling();
					hu_back.stopHeating();
					back_cool = true;
				} else if (getCurrentBackTemperature() < getDesiredTemp()) {
					cu_back.stopCooling();
					hu_back.startHeating();
					back_cool = false;
				} else {
					cu_back.stopCooling();
					hu_back.stopHeating();
				}
			}
			
			frontTemperatureSensor();
			backTemperatureSensor();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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

	public boolean getEmergencyOverride() {
		return e_override;
	}

	//Setters
	public void setDesiredTemp(int tempVal) {
		desiredTemp = tempVal;
	}	

	public void setCoolerStatus(boolean status) {
		coolerStatus = status;
	}

	public void setHeaterStatus(boolean status) {
		heaterStatus = status;
	}
	
	//Methods
	public void setEmergencyOverride(boolean setting) {
		e_override = setting;
	}
	
	public void setEmergencyHeating(boolean setting) {
		e_heating = setting;
	}
	
	public void setEmergencyCooling(boolean setting) {
		e_cooling = setting;
	}
	
	
	private int getCurrentFrontTemperature() {
		return front_temp;
	}
	
	private int getCurrentBackTemperature() {
		return back_temp;
	}
	
	private void frontTemperatureSensor() {
		if(front_cool == true) {
			front_temp = front_temp - 1;
		} else {
			front_temp = front_temp + 1;
		}
	}
	
	private void backTemperatureSensor() {
		if(back_cool == true) {
			back_temp = back_temp - 1;
		} else {
			back_temp = back_temp + 1;
		}
	}
	
	private void userNotification() {
		if(type.equals("shirt")) {
			main.setCurrentShirtFrontTemp(front_temp);
			main.setCurrentShirtBackTemp(back_temp);
		} else {
			main.setCurrentPantsFrontTemp(front_temp);
			main.setCurrentPantsBackTemp(back_temp);
		}
	}
	

}
