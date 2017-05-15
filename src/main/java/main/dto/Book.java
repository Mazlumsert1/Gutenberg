package main.dto;

import java.util.List;

public class Book {
    private long UID;
    private String title;
    private List<Author> authors;
    private List<Location> locations;
    private String text;

    /**
     * Default constructor.
     */
    public Book() {
    }

    /**
     * Constructor that initiates the Book with a title, a list of Authors, a list of Locations and text.
     *
     * @param title String The title of the Book.
     * @param authors List of Authors The Authors of the Book.
     * @param locations List of Locations The Locations of the Book.
     * @param text String The text of the Book.
     */
    public Book(String title, List<Author> authors, List<Location> locations, String text) {
        this.title = title;
        this.authors = authors;
        this.locations = locations;
        this.text = text;
    }

    /**
     * Constructor that initates the Book with an UID, a title, a list of Authors, a list of Locations and text.
     *
     * @param UID Long The UID of the Book.
     * @param title String The title of the Book.
     * @param authors List of Authors The Authors of the Book.
     * @param locations List of Locations The Locations of the Book.
     * @param text String The text of the Book.
     */
    public Book(long UID, String title, List<Author> authors, List<Location> locations, String text) {
        this.UID = UID;
        this.title = title;
        this.authors = authors;
        this.locations = locations;
        this.text = text;
    }

    /**
     * Gets the UID of the Book.
     *
     * @return Long The UID of the Book.
     */
    public long getUID() {
        return UID;
    }

    /**
     * Sets the UID of the Book.
     *
     * @param UID Long The UID of the Book.
     */
    public void setUID(long UID) {
        this.UID = UID;
    }

    /**
     * Gets the Title of the Book.
     *
     * @return String The title of the Book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the Title of the Book.
     *
     * @param title String The title of the Book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets a List of Authors associated with the Book.
     *
     * @return List of Authors The Authors associated with the Book.
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * Sets a List of Authors associated with the Book.
     *
     * @param authors List of Authors The Authors associated with the Book.
     */
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    /**
     * Gets a List of Locations mentioned in the Book.
     *
     * @return List of Locations The Locations mentioned in the Book.
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * Sets a List of Locations mentioned in the Book.
     *
     * @param locations List of Locations The Loactions mentioned in the Book.
     */
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    /**
     * Gets the Url for the text of the Book.
     *
     * @return String The Url for the text of the Book.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the Urls for the text of the Book.
     *
     * @param text String the Url for the text of the Book.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Adds a location to the locations list.
     *
     * @param location The location to add
     */
    public void addLocation(Location location) {
        this.locations.add(location);
    }

    /**
     * Adds a location to the locations list.
     * @param author The author to add
     */
	public void addAuthor(Author author) {
        this.authors.add(author);
	}
}
