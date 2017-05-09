package main.dto;

public class Location {

    private double latitude;
    private double longitude;
    private String name;

    /**
     * Default constructor.
     */
    public Location() {
    }

    /**
     * Constructor that instantiates a location with latitude, longitude and name.
     *
     * @param latitude Double The latitude of the Location.
     * @param longitude Double The longitude of the Location.
     * @param name String The name of the Location.
     */
    public Location(double latitude, double longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    /**
     * Get the latitude of the Location.
     *
     * @return Double The latitude of the Location.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Set the latitude of the Location.
     *
     * @param latitude Double The latitude of the Location.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Get the longitude of the Location.
     *
     * @return Double The longitude of the Location.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Set the latitude of the Location.
     *
     * @param longitude Double The longitude of the Location.
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Get the name of the Location.
     *
     * @return String the name of the Location.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the Location.
     *
     * @param name String the name of the Location.
     */
    public void setName(String name) {
        this.name = name;
    }
}
