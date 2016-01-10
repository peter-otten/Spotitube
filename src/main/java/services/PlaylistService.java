package services;

import com.google.inject.Inject;
import datasource.IPlaylistDao;
import domain.Playlist;

import java.util.List;

public class PlaylistService implements IPlaylistService {

    IPlaylistDao playlistDao;

    @Inject
    public void setTrackDao(IPlaylistDao playlistDao)
    {
        this.playlistDao = playlistDao;
    }

    @Override
    public List<Playlist> findAll(String owner) {
        return playlistDao.findAll(owner);
    }


    @Override
    public void addPlaylist(String name) {
        playlistDao.addPlaylist(name);
    }
}
