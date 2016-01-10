package presentation.model;


import com.google.inject.Inject;
import domain.Playlist;
import services.IPlaylistService;

import java.util.List;

public class PlaylistModel implements IPlaylistModel {

    private IPlaylistService playlistService;

    @Inject
    public void setPlaylistService(IPlaylistService playlistService)
    {
        this.playlistService = playlistService;
    }

    public List<Playlist> getAllPlaylists(String owner)
    {
        return playlistService.findAll(owner);
    }

    public void addPlaylist(String name)
    {
        playlistService.addPlaylist(name);
    }
}
