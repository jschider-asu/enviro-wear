package envirowear.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import envirowear.CoolingUnit;

class CoolingUnitTest {

	//Run is a method from Thread class extension.
//	@Test
//	void testRun() {
//		fail("No Code to test.");
//	}

	@Test
	void testCoolingUnit() {
		//Need to test that the three member vars where created.
		CoolingUnit cu = new CoolingUnit();
		
		
		
		assertEquals("",cu.getType(),"Constructor failed to initialize correctly.");
		assertEquals("",cu.getPosition(),"Constructor failed to initialize correctly.");
		assertEquals(false,cu.getRunningStatus(),"Constructor failed to initialize correctly.");
	}

	@Test
	void testGetRunningStatus() {
		//Running[Status] defaults to false;
		CoolingUnit cu = new CoolingUnit();
		
		assertEquals(false, cu.getRunningStatus(), "The status did not return correctly.");
	}

	@Test
	void testStartCooling() {
		CoolingUnit cu = new CoolingUnit();
		
		assertEquals(true, cu.startCooling(),"Failed to start cooling properly.");
		
		assertEquals(false, cu.startCooling(),"Failed to keep running while already running.");
	}

	@Test
	void testStopCooling() {
		CoolingUnit cu = new CoolingUnit();
		
		cu.startCooling();
		
		assertEquals(true, cu.stopCooling(),"Failed to stop cooling properly.");
		
		assertEquals(false, cu.stopCooling(),"Failed to keep stopped while already stopped.");
	}

}
