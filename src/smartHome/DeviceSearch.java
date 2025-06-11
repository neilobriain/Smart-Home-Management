/**
 * 
 */
package smartHome;

import java.util.ArrayList;

/**
 * Neil Ó Briain. This class creates the device search utilities
 */
public class DeviceSearch {

	/**
	 * Start point for the main
	 */
	public static void main(String[] args) {
		try {

			// this code included to demonstrate that the displayAll method is working
			SmartLight s = new SmartLight("12341234123", "1231231231", Status.ON, 300);
			s.displayAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Searches for each smart light device that matches a specified location and
	 * returns the results in an arraylist
	 * 
	 * @param smartLights
	 * @param searchLocation
	 * @return
	 */
	public static ArrayList<SmartLight> searchByLocation(ArrayList<SmartLight> smartLights, String searchLocation) {
		ArrayList<SmartLight> matches = new ArrayList<SmartLight>();

		for (SmartLight smartLight : smartLights) {
			if (smartLight.getLocation().equalsIgnoreCase(searchLocation)) {
				matches.add(smartLight);
			}
		}

		return matches;
	}

	/**
	 * Searches for each smart light device whose colour temperature is within the
	 * specified range and whose status matches the specified search status. Returns
	 * the results in an arraylist
	 * 
	 * @param smartLights
	 * @param lowerSearchTemp
	 * @param higherSearchTemp
	 * @param searchStatus
	 * @return
	 */
	public static ArrayList<SmartLight> searchByColourTemp(ArrayList<SmartLight> smartLights, int lowerSearchTemp,
			int higherSearchTemp, Status searchStatus) {
		ArrayList<SmartLight> matches = new ArrayList<SmartLight>();

		for (SmartLight smartLight : smartLights) {
			int currentTemp = smartLight.getColourTemperature();
			if (currentTemp >= lowerSearchTemp && currentTemp <= higherSearchTemp
					&& smartLight.getStatus() == searchStatus) {
				matches.add(smartLight);
			}

		}

		return matches;
	}

}
