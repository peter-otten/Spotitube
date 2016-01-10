package datasource;

import domain.Playlist;

import java.util.List;

/**
 * Created by MOBO on 10-1-2016.
 */
public interface IPlaylistDao {
    List<Playlist> findAll(String owner);

    void addPlaylist(String name);
}
