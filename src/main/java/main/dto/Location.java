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
     * Get the latitude of the location.
     *
     * @return Double The latitude of the location.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Set the latitude of the location.
     *
     * @param latitude Double The latitude of the location.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Get the longitude of the location.
     *
     * @return Double The longitude of the location.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Set the latitude of the location.
     *
     * @param longitude Double The longitude of the location.
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Get the name of the location.
     *
     * @return String the name of the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the location.
     *
     * @param name String the name of the location.
     */
    public void setName(String name) {
        this.name = name;
    }
}
