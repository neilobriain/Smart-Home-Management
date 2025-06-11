/**
 * 
 */
package smartHome;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Neil Ó Briain. Test class for the SmartLight class
 */
class SmartLightTest {

	SmartLight smartLight;
	String nameValid;
	String nameInvalid;
	String locationValid;
	String locationInvalid;
	int colourTemperatureValidLower;
	int colourTemperatureValidUpper;
	int colourTemperatureInvalidLower;
	int colourTemperatureInvalidUpper;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		smartLight = new SmartLight();
		nameValid = "12345";
		nameInvalid = "1234";
		locationValid = "LOCATION";
		locationInvalid = "";
		colourTemperatureValidLower = 153;
		colourTemperatureValidUpper = 500;
		colourTemperatureInvalidLower = 152;
		colourTemperatureInvalidUpper = 501;

	}

	/**
	 * Tests the getter and setter for status enum in the SmartLight class
	 */
	@Test
	void testSetGetStatusEnum() {
		smartLight.setStatus(Status.ON);
		assertEquals(Status.ON, smartLight.getStatus());
	}

	/**
	 * tests the default constructor
	 */
	@Test
	void testDefaultConstructor() {
		smartLight = new SmartLight();
		assertNotNull(smartLight);
	}

	/**
	 * tests the constructor with valid args
	 */
	@Test
	void testConstructorWithArgsValid() {
		smartLight = new SmartLight(nameValid, locationValid, Status.STANDBY, colourTemperatureValidLower);
		assertNotNull(smartLight);
		assertEquals(nameValid, smartLight.getDeviceName());
		assertEquals(locationValid, smartLight.getLocation());
		assertEquals(Status.STANDBY, smartLight.getStatus());
		assertEquals(colourTemperatureValidLower, smartLight.getColourTemperature());
	}

	/**
	 * Tests a valid perform ping method
	 */
	@Test
	void testPerformPingValid() {
		smartLight = new SmartLight("12345", "LOCATION", Status.ON, 300);
		int tempKelvin = 1000000 / 300;
		String expected = "SL-LOC-1-" + tempKelvin;
		assertEquals(expected, smartLight.performPing());

	}

	/**
	 * Tests the getter and setter for device name when valid
	 */
	@Test
	void testGetSetDeviceNameValid() {
		smartLight.setDeviceName(nameValid);
		assertEquals(nameValid, smartLight.getDeviceName());
	}

	/**
	 * Tests for the exception to an invalid name set
	 */
	@Test
	void testSetDeviceNameInvalid() {

		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			smartLight.setDeviceName(nameInvalid);
		});

		assertEquals("Invalid device name", illegalArgumentException.getMessage());
	}

	/**
	 * Tests for the exception to an invalid location set
	 */
	@Test
	void testSetLocationInvalid() {

		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			smartLight.setLocation(locationInvalid);
		});

		assertEquals("Location must be set", illegalArgumentException.getMessage());
	}

	/**
	 * Tests for the exception to an invalid colour temp lower set
	 */
	@Test
	void testSetColourTemperatureInvalidLower() {

		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			smartLight.setColourTemperature(colourTemperatureInvalidLower);
		});

		assertEquals("Invalid temperature setting", illegalArgumentException.getMessage());
	}

	/**
	 * Tests for the exception to an invalid colour temp higher set
	 */
	@Test
	void testSetColourTemperatureInvalidUpper() {

		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			smartLight.setColourTemperature(colourTemperatureInvalidUpper);
		});

		assertEquals("Invalid temperature setting", illegalArgumentException.getMessage());
	}

	/**
	 * Tests the getter and setter for location when valid
	 */
	@Test
	void testGetSetLocationValid() {
		smartLight.setLocation(locationValid);
		assertEquals(locationValid, smartLight.getLocation());
	}

	/**
	 * Tests the getter and setter for colour temperature when valid at lower
	 * boundary
	 */
	@Test
	void testGetSetColourTemperatureValidLower() {
		smartLight.setColourTemperature(colourTemperatureValidLower);
		assertEquals(colourTemperatureValidLower, smartLight.getColourTemperature());
	}

	/**
	 * Tests the getter and setter for colour temperature when valid at upper
	 * boundary
	 */
	@Test
	void testGetSetColourTemperatureValidUpper() {
		smartLight.setColourTemperature(colourTemperatureValidUpper);
		assertEquals(colourTemperatureValidUpper, smartLight.getColourTemperature());
	}

//	@Test
//	void testPerformPingInvalid() {
//		smartLight = new SmartLight();
//		Exception exception = assertThrows(Exception.class, ()->{
//			smartLight.performPing();
//		});
//		assertEquals("Error in performPing", exception.getMessage());
//		
//	}

}
