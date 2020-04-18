package envirowear.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import envirowear.HeatingUnit;

class HeatingUnitTest {

	//method from class inheritance.
//	@Test
//	void testRun() {
//		fail("Not yet implemented");
//	}

	@Test
	void testHeatingUnit() {
		//Need to test that the three member vars where created.
		HeatingUnit hu = new HeatingUnit("shirt","front");
		
		assertEquals("shirt",hu.getType(),"Constructor failed to initialize correctly.");
		assertEquals("front",hu.getPosition(),"Constructor failed to initialize correctly.");
		assertEquals(false,hu.getRunningStatus(),"Constructor failed to initialize correctly.");
	}

	@Test
	void testGetRunningStatus() {
		//Running[Status] defaults to false;
		HeatingUnit hu = new HeatingUnit("shirt","front");
		
		assertEquals(false, hu.getRunningStatus(), "The status did not return correctly.");
	}

	@Test
	void testStartHeating() {
		HeatingUnit hu = new HeatingUnit("shirt","front");
		
		assertEquals(true, hu.startHeating(),"Failed to start cooling properly.");
		
		assertEquals(false, hu.startHeating(),"Failed to keep running while already running.");
	}

	@Test
	void testStopHeating() {
		HeatingUnit hu = new HeatingUnit("shirt","front");
		
		hu.startHeating();
		
		assertEquals(true, hu.stopHeating(),"Failed to stop cooling properly.");
		
		assertEquals(false, hu.stopHeating(),"Failed to keep stopped while already stopped.");
	}

}
