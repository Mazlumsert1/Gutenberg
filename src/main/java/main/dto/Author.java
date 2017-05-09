package main.dto;

public class Author {

    private long UID;
    private String name;

    /**
     * Default constructor.
     */
    public Author() {
    }

    /**
     * Constructor that instantiates the Author with a name.
     *
     * @param name String The name of the Author.
     */
    public Author(String name) {
        this.name = name;
    }

    /**
     * Constructor that instantiates the Author with an UID and a name.
     *
     * @param UID Long The UID of the Author.
     * @param name String The name of the Author.
     */
    public Author(long UID, String name) {
        this.UID = UID;
        this.name = name;
    }

    /**
     * Get the UID of the Author.
     *
     * @return Long The UID of the Author.
     */
    public long getUID() {
        return UID;
    }

    /**
     * Gets the name of the Author.
     *
     * @return String The name of the Author.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Author.
     *
     * @param name String The name of the Author.
     */
    public void setName(String name) {
        this.name = name;
    }
}
