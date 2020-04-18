package envirowear.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import envirowear.SensorUnit;

class SensorUnitTest {


	@Test
	void testSensorUnit() {
		SensorUnit su = new SensorUnit("pants",72);
		
		
		assertEquals(72,su.getDesiredTemp(),"Failed to initialize temp.");
		assertEquals(false,su.getHeaterStatus(), "Failed to initialize heater.");
		assertEquals(false,su.getCoolerStatus(), "Failed to initialize cooler.");
		assertEquals(false,su.getEmergencyOverride(),"Failed to initialize emergency override.");

	}

	@Test
	void testGetDesiredTemp() {
		SensorUnit su = new SensorUnit("pants",72);
		
		assertEquals(72,su.getDesiredTemp(),"Failed to get desired temperature.");
	}

	@Test
	void testGetHeaterStatus() {
		SensorUnit su = new SensorUnit("pants",72);
		
		assertEquals(false, su.getHeaterStatus(),"Failed to get heater status.");
	}

	@Test
	void testGetCoolerStatus() {
		SensorUnit su = new SensorUnit("pants",72);
		
		assertEquals(false, su.getCoolerStatus(),"Failed to get cooler status.");
	}

	@Test
	void testGetEmergencyOverride() {
		SensorUnit su = new SensorUnit("pants",72);
		
		assertEquals(false, su.getEmergencyOverride(),"Failed to get Emergency Override.");
	}

	@Test
	void testSetDesiredTemp() {
		SensorUnit su = new SensorUnit("pants",72);
		
		su.setDesiredTemp(70);
		
		assertEquals(70, su.getDesiredTemp(),"Failed to set desired temp.");
	}

	@Test
	void testSetCoolerStatus() {
		SensorUnit su = new SensorUnit("pants",72);
		
		su.setCoolerStatus(true);
		
		assertEquals(true, su.getCoolerStatus(),"Failed to set cooler status.");
	}

	@Test
	void testSetHeaterStatus() {
		SensorUnit su = new SensorUnit("pants",72);
		
		su.setHeaterStatus(true);
		
		assertEquals(true,su.getHeaterStatus(),"Failed to set heater status.");
	}

	@Test
	void testSetEmergencyOverride() {
		SensorUnit su = new SensorUnit("pants",72);
		
		su.setEmergencyOverride(true);
		
		assertEquals(true,su.getEmergencyOverride(),"Failed to set Emergency Override.");
	}

	@Test
	void testSetEmergencyHeating() {
		SensorUnit su = new SensorUnit("pants",72);
		
		try {
			su.setEmergencyHeating(true);
		} catch(Exception e) {
			fail("Failed to set Emergency Heating.");
		}

	}

	@Test
	void testSetEmergencyCooling() {
		SensorUnit su = new SensorUnit("pants",72);
		
		try {
			su.setEmergencyCooling(true);
		} catch(Exception e) {
			fail("Failed to set Emergency Cooling.");
		}
	}

}
