package presentation.model;

import domain.Playlist;

import java.util.List;

/**
 * Created by MOBO on 10-1-2016.
 */
public interface IPlaylistModel {
    List<Playlist> getAllPlaylists(String owner);

    void addPlaylist(String name);
}
