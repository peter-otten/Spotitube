package services;

import domain.Playlist;
import domain.Track;

import java.util.List;

/**
 * Created by MOBO on 10-1-2016.
 */
public interface IPlaylistService {
    List<Playlist> findAll(String owner);

    void addPlaylist(String name);
}
