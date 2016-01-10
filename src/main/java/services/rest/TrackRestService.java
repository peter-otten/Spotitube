package services.rest;

import com.google.inject.Inject;
import datasource.IPlaylistDao;
import datasource.ITrackDao;
import domain.Playlist;
import domain.Track;
import services.ITrackService;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/playlists")
@Singleton
public class TrackRestService implements ITrackService {
    ITrackDao trackDao;

    @Inject
    public void setService(ITrackDao trackDao)
    {
        this.trackDao = trackDao;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Track> getAllTracks(String zoekterm) {
        return trackDao.findByTitle(zoekterm);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Track> getAllTracksFromPlaylist(int playlistid) {
        return trackDao.findByPlaylist(playlistid);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void addToPlaylist(int playlistid, int trackid) {
        trackDao.addTrackToPlaylist(playlistid, trackid);
    }
}
