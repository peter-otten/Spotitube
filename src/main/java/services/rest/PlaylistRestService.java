package services.rest;

import com.google.inject.Inject;
import datasource.IPlaylistDao;
import datasource.ITrackDao;
import domain.Playlist;
import domain.Track;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/playlists")
@Singleton
public class PlaylistRestService {
    private List<Playlist> playlists;
    private List<Track> tracks;
    IPlaylistDao playlistDao;
    ITrackDao trackDao;

    public PlaylistRestService()
    {
    }

    @Inject
    public void setService(ITrackDao trackDao)
    {
        this.trackDao = trackDao;
    }
    @Inject
    public void setService(IPlaylistDao playlistDao)
    {
        this.playlistDao = playlistDao;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlist> getJsonItems()  {
        return null;
    }
    }
