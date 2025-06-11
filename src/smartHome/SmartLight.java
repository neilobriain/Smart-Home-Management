/**
 * 
 */
package smartHome;

/**
 * Neil Ó Briain. This class creates a Smart Light device
 */
public class SmartLight extends SmartDevice {

	private static final int LOW_TEMPERATURE_LIMIT = 153;
	private static final int HIGH_TEMPERATURE_LIMIT = 500;
	private static final int STATUS_OFF_CODE = 0;
	private static final int STATUS_ON_CODE = 1;
	private static final int STATUS_STANDBY_CODE = 2;

	private int colourTemperature;

	/**
	 * Default constructor for the smart light
	 */
	public SmartLight() {

	}

	/**
	 * Constructor with arguments. Creates a smart light device according to the set
	 * rules
	 * 
	 * @param deviceName the device name
	 * @param location   the device location
	 * @param status     the status of the device
	 * @throws IllegalArgumentException if invalid settings are used
	 */
	public SmartLight(String deviceName, String location, Status status, int colourTemperature)
			throws IllegalArgumentException {
		super(deviceName, location, status);
		this.setColourTemperature(colourTemperature);
	}

	/**
	 * Gets the Colour Temperature
	 * 
	 * @return the colourTemperature
	 */
	public int getColourTemperature() {
		return colourTemperature;
	}

	/**
	 * Sets the colour temperature represented using the mired scale (micro
	 * reciprocal degrees) and set with the required colour temperature values range
	 * 
	 * @param colourTemperature the colour temperature setting
	 * @throws IllegalArgumentException if an invalid temperature has been entered
	 */
	public void setColourTemperature(int colourTemperature) throws IllegalArgumentException {
		if (colourTemperature >= LOW_TEMPERATURE_LIMIT && colourTemperature <= HIGH_TEMPERATURE_LIMIT) {
			this.colourTemperature = colourTemperature;
		} else {
			throw new IllegalArgumentException("Invalid temperature setting");
		}

	}

	/**
	 * This displays all available information about the smart light to screen
	 */
	@Override
	public void displayAll() {
		super.displayAll();
		System.out.println("COLOURTEMP : " + colourTemperature);
	}

	/**
	 * Returns a string in the format SL-LOCATION-STATUS-CT e.g. for a Smart Light
	 * located in the location Kitchen, Status ON and CT 153 would be SL-KIT-1-6535
	 */
	@Override
	public String performPing() {
		try {

			String locationCode = this.getLocation().substring(0, 3).toUpperCase();

			int statusCode = 0;

			if (this.getStatus() == Status.OFF) {
				statusCode = STATUS_OFF_CODE;
			} else if (this.getStatus() == Status.ON) {
				statusCode = STATUS_ON_CODE;
			} else if (this.getStatus() == Status.STANDBY) {
				statusCode = STATUS_STANDBY_CODE;
			}

			int colourTempKelvin = 1000000 / this.getColourTemperature();

			return "SL-" + locationCode + "-" + statusCode + "-" + colourTempKelvin;

		} catch (Exception e) {
			return "Error in performPing";
		}
	}

}
