package services.rest;

import com.google.inject.Inject;
import datasource.IPlaylistDao;
import datasource.ITrackDao;
import domain.Playlist;
import domain.Track;
import services.IPlaylistService;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/playlists")
@Singleton
public class PlaylistRestService implements IPlaylistService{
    IPlaylistDao playlistDao;

    @Inject
    public void setService(IPlaylistDao playlistDao)
    {
        this.playlistDao = playlistDao;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlist> findAll(String owner) {
        return playlistDao.findAll(owner);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void addPlaylist(String name) {
        playlistDao.addPlaylist(name);
    }
}
