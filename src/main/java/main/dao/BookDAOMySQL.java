package main.dao;

import main.dto.Author;
import main.dto.Book;
import main.dto.Location;
import main.util.DBConnectorMySQL;
import main.util.IDBConnectorMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOMySQL implements IBookDAO {

    private IDBConnectorMySQL connector;

    /**
     * Default constructor.
     */
    public BookDAOMySQL() {
        connector = new DBConnectorMySQL();
    }

    /**
     * Constructor with dependency injection.
     *
     * @param connector IDBConnectorMySQL The connector to the MYSQL database.
     */
    public BookDAOMySQL(IDBConnectorMySQL connector) {
        this.connector = connector;
    }

    /**
     * Returns a List of books from the MYSQL database which have the location of a latitude and longitude mentioned.
     *
     * @param latitude String the latitude of the location.
     * @param longitude String the longitude of the location.
     * @return List of books The list of books where the location is mentioned.
     */
    @Override
    public List<Book> getBooksFromLatLong(String latitude, String longitude) {
        return null;
    }

    /**
     * Returns a List of books from the MYSQL database which is written by the author.
     *
     * @param name String The name of the author who has written the books.
     * @return List of books which are written by the author.
     */
    @Override
    public List<Book> getBooksAndCitiesFromAuthor(String name) {
        return null;
    }

    /**
     * Returns a List of books from the MYSQL database where the cities mentioned in a Book is mentioned.
     *
     * @param book Book The book where locations are searched.
     * @return List of books with locations.
     */
    @Override
    public List<Location> getCitiesFromBook(String title) {
        List<Location> locations = new ArrayList<>();
        String queryString = "SELECT * FROM location l JOIN book_location bl ON l.l_id = bl.l_id JOIN book b ON bl.b_id = b.b_id WHERE b.title = ?";

        try {
            Connection con = connector.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(queryString);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.getFetchSize() == 0) {
                return null;
            }

            while (resultSet.next()) {
                Location location = new Location(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                        );
                locations.add(location);
            }

        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
        return locations;
    }

    /**
     * Returns a List of books from the MYSQL database which has a location mentioned somewhere in the book.
     *
     * @param location Location The location that is mentioned in the books.
     * @return List of books The books where the location is mentioned.
     */
    @Override
    public List<Book> getAuthorsAndBooksFromCity(Location location) {
        return null;
    }
}
