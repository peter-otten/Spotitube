package presentation.model;

import domain.Playlist;
import services.IPlaylistService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MOBO on 10-1-2016.
 */
public class MockPlaylistService implements IPlaylistService {
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
