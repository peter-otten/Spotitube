package datasource;

import datasource.util.DatabaseProperties;
import domain.Track;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrackDao implements ITrackDao {
    private Logger logger = Logger.getLogger(getClass().getName());

    private DatabaseProperties databaseProperties;

    public TrackDao()
    {
        this.databaseProperties = new DatabaseProperties();
        tryLoadJdbcDriver(databaseProperties);
    }

    public List<Track> findAll()
    {
        List<Track> tracks = new ArrayList<Track>();
        tryFindAll(tracks);
        return tracks;
    }

    public List<Track> findByTitle(String zoekterm)
    {
        List<Track> tracks = new ArrayList<Track>();
        tryFindByTitle(tracks, zoekterm);
        return tracks;
    }

    private void tryLoadJdbcDriver(DatabaseProperties databaseProperties)
    {
        try {
            Class.forName(databaseProperties.driver());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Can't load JDBC Driver " + databaseProperties.driver(), e);
        }
    }

    private void tryFindAll(List<Track> tracks)
    {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from track");
            addNewItemsFromDatabase(tracks, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void tryFindByTitle(List<Track> tracks, String zoekterm)
    {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from track WHERE title LIKE '%"+ zoekterm+"%'");
            addNewItemsFromDatabase(tracks, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void addNewItemsFromDatabase(List<Track> tracks, PreparedStatement statement) throws SQLException
    {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next())
        {
            addNewItemFromResultSet(tracks, resultSet);
        }
    }

    private void addNewItemFromResultSet(List<Track> items, ResultSet resultSet) throws SQLException
    {
        Track item = new Track(
                resultSet.getInt("trackId"), resultSet.getString("preformer"), resultSet.getString("title"), resultSet.getString("url")
        );
        items.add(item);
    }

    public List<Track> findByPlaylist(int playlistid) {
        List<Track> tracksForPlaylist = new ArrayList<Track>();
        tryFindByPlaylist(tracksForPlaylist, playlistid);
        return tracksForPlaylist;
    }

    private void tryFindByPlaylist(List<Track> tracksForPlaylist, int playlistid) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("select t.* from availability a INNER JOIN track t ON t.trackid = a.trackid WHERE playlistid = "+ playlistid);
            addNewItemsFromDatabase(tracksForPlaylist, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    public void addTrackToPlaylist(int playlistid, int trackid) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("INSERT INTO availability (trackid,playlistid,offlineAvailable) VALUES ("+trackid+","+playlistid+",0)");
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }
}
