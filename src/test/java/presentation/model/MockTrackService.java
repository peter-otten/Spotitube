package presentation.model;

import domain.Track;
import services.ITrackService;

import java.util.ArrayList;
import java.util.List;

public class MockTrackService implements ITrackService {
    private List<Track> tracks;

    @Override
    public List<Track> getAllTracks(String zoekterm) {
        return makeTracks();
    }

    @Override
    public List<Track> getAllTracksFromPlaylist(int playlistid) {
        return makeTracks();
    }

    @Override
    public void addToPlaylist(int playlistid, int trackid) {

    }

    private List<Track> makeTracks()
    {
        tracks = new ArrayList<>();
        Track track = new Track(1, "Trivium", "Silence In The Snow", "https://www.youtube.com/watch?v=PcIlZ3luYHc");
        tracks.add(track);
        return tracks;
    }
}
