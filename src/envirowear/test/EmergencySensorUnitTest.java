package envirowear.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import envirowear.EmergencySensorUnit;

class EmergencySensorUnitTest {
	

	@Test
	void testEmergencySensorUnit() {
		
		EmergencySensorUnit esu = new EmergencySensorUnit("shirt");
		
		assertEquals(false,esu.getOverride(),"Failed to initialize emergencyoverride.");
		assertEquals(false,esu.getE_coolerStatus(),"Failed to initialize e_coolerStatus.");
		assertEquals(false,esu.getE_heaterStatus(),"Failed to initialize e_heaterStatus.");
		
	}

	@Test
	void testSetDesiredTemp() {
		EmergencySensorUnit esu = new EmergencySensorUnit("shirt");
		
		try {
			esu.setDesiredTemp(70);
		} catch(Exception e) {
			fail("Failed to set desired temp.");
		}
	}

	@Test
	void testGetE_heaterStatus() {
		EmergencySensorUnit esu = new EmergencySensorUnit("shirt");
		
		assertEquals(false,esu.getE_heaterStatus(),"Failed to get e_heater status.");
	}

	@Test
	void testGetE_coolerStatus() {
		EmergencySensorUnit esu = new EmergencySensorUnit("shirt");
		
		assertEquals(false,esu.getE_coolerStatus(),"Failed to get e_cooler status.");
	}

	@Test
	void testSetE_heaterStatus() {
		EmergencySensorUnit esu = new EmergencySensorUnit("shirt");
		
		esu.setE_heaterStatus(true);
		
		assertTrue(esu.getE_heaterStatus(),"Failed to set the e_heater status.");
	}

	@Test
	void testSetE_coolerStatus() {
		EmergencySensorUnit esu = new EmergencySensorUnit("shirt");
		
		esu.setE_coolerStatus(true);
		
		assertTrue(esu.getE_coolerStatus(),"Failed to set the e_cooler status.");
	}

	@Test
	void testGetHeaterOverrideStatus() {
		EmergencySensorUnit esu = new EmergencySensorUnit("shirt");
		
		assertFalse(esu.getHeaterOverrideStatus(),"Failed to get the heater override status");
	}

	@Test
	void testGetCoolerOverrideStatus() {
		EmergencySensorUnit esu = new EmergencySensorUnit("shirt");
		
		assertFalse(esu.getCoolerOverrideStatus(),"Failed to get the cooler override status");
	}

	@Test
	void testGetOverride() {
		EmergencySensorUnit esu = new EmergencySensorUnit("shirt");
		
		assertFalse(esu.getOverride(),"Failed to get emergencyoverride.");
	}

	@Test
	void testLowerBodyTemp() {
		EmergencySensorUnit esu = new EmergencySensorUnit("shirt");
		
		assertFalse(esu.getLowerBodyTemp(),"Failed to get lower body temp status.");
	}

	@Test
	void testRaiseBodyTemp() {
		EmergencySensorUnit esu = new EmergencySensorUnit("shirt");
		
		assertFalse(esu.getRaiseBodyTemp(),"Failed to get raise body temp status.");
	}

}
