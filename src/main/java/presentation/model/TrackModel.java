package presentation.model;

import com.google.inject.Inject;
import domain.Track;
import services.ITrackService;

import java.util.List;

public class TrackModel implements ITrackModel {
    private ITrackService trackService;

    @Inject
    public void setPlaylistService(ITrackService trackService){
        this.trackService = trackService;
    }

    public List<Track> getAllTracks(String zoekterm)
    {
        return trackService.getAllTracks(zoekterm);
    }

    public List<Track> getAllTracksFromPlaylist(int playlistid)
    {
        return trackService.getAllTracksFromPlaylist(playlistid);
    }

    public void addToPlaylist(int trackid, int playlistid)
    {
        trackService.addToPlaylist(playlistid, trackid);
    }
}
