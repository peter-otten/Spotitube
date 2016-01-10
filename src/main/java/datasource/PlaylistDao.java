package datasource;

import datasource.util.DatabaseProperties;
import domain.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlaylistDao implements IPlaylistDao {
    private Logger logger = Logger.getLogger(getClass().getName());

    private DatabaseProperties databaseProperties;

    public PlaylistDao()
    {
        this.databaseProperties = new DatabaseProperties();
        this.tryLoadJdbcDriver(databaseProperties);
    }

    public List<Playlist> findAll(String owner) {
        List<Playlist> playlists = new ArrayList<Playlist>();
        this.tryFindAll(playlists, owner);
        return playlists;
    }

    private void tryLoadJdbcDriver(DatabaseProperties databaseProperties) {
        try {
            Class.forName(databaseProperties.driver());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Can't load JDBC Driver " + databaseProperties.driver(), e);
        }
    }

    private void tryFindAll(List<Playlist> playlists, String owner) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from playlist where owner = '"+owner+"'");
            addNewItemsFromDatabase(playlists, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void addNewItemsFromDatabase(List<Playlist> playlists, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next())
        {
            addNewItemFromResultSet(playlists, resultSet);
        }
    }

    private void addNewItemFromResultSet(List<Playlist> playlists, ResultSet resultSet) throws SQLException {
        Playlist playlist = new Playlist(
                resultSet.getInt("playlistId"), resultSet.getString("owner"), resultSet.getString("name")
        );
        playlists.add(playlist);
    }

    public void addPlaylist(String name) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("INSERT INTO playlist (name, owner) VALUES ('"+name+"', 'Peter')");
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }
}

