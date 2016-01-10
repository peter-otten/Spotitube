package services;

import datasource.IPlaylistDao;
import domain.Playlist;

import java.util.ArrayList;
import java.util.List;


public class MockPlaylistDoa implements IPlaylistDao {
    @Override
    public List<Playlist> findAll(String owner) {
        List<Playlist> playlists = new ArrayList<Playlist>();
        playlists.add(new Playlist(1, "peter", "testPlaylist"));
        return playlists;
    }

    @Override
    public void addPlaylist(String name) {

    }
}
