/**
 * 
 */
package smartHome;

/**
 * Neil Ó Briain. This class creates an abstract template for each
 * smart device to inherit from within the system
 */
public abstract class SmartDevice {

	private static final int MINIMUN_NAME_LENGTH = 5;

	// instance vars
	private String deviceName;
	private String location;
	private Status status;

	/**
	 * Default constructor for a smart device
	 */
	public SmartDevice() {

	}

	/**
	 * Constructor with arguments. Must follow business rules
	 * 
	 * @param deviceName The device name
	 * @param location   The device location
	 * @param status     The device status
	 * @throws IllegalArgumentException if business rules not followed
	 */
	public SmartDevice(String deviceName, String location, Status status) throws IllegalArgumentException {
		this.setDeviceName(deviceName);
		this.setLocation(location);
		this.status = status;
	}

	/**
	 * Gets the device name
	 * 
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * Sets the device name according to minimum name length rule
	 * 
	 * @param deviceName The device name
	 * @throws IllegalArgumentException if invalid name entered
	 */
	public void setDeviceName(String deviceName) throws IllegalArgumentException {
		if (deviceName.length() >= MINIMUN_NAME_LENGTH) {
			this.deviceName = deviceName;
		} else
			throw new IllegalArgumentException("Invalid device name");

	}

	/**
	 * Gets the device location
	 * 
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location of the smart device. A location must be specified.
	 * 
	 * @param location the device location
	 * @throws IllegalArgumentException if no location entered
	 */
	public void setLocation(String location) throws IllegalArgumentException {
		if (location != null && !location.equals("")) {
			this.location = location;
		} else {
			throw new IllegalArgumentException("Location must be set");
		}

	}

	/**
	 * Gets the device status
	 * 
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * This displays all available information about the device to screen
	 */
	public void displayAll() {

		System.out.println("NAME       : " + deviceName);
		System.out.println("LOCATION   : " + location);
		System.out.println("STATUS     : " + status);

	}

	/**
	 * Required method for each device within the system. Details returned will be
	 * different dependent on the type of device
	 * 
	 * @return String with device information
	 */
	public String performPing() {
		return "Cannot perform ping, check support documents";
	}

}
