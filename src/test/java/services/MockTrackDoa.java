package services;

import datasource.ITrackDao;
import domain.Track;

import java.util.ArrayList;
import java.util.List;

public class MockTrackDoa implements ITrackDao {
    private List<Track> tracks;

    @Override
    public List<Track> findAll() {
        return makeTracks();
    }

    @Override
    public List<Track> findByTitle(String zoekterm) {

        return makeTracks();
    }

    @Override
    public List<Track> findByPlaylist(int playlistid) {
        return makeTracks();
    }

    @Override
    public void addTrackToPlaylist(int playlistid, int trackid) {
    }

    private List<Track> makeTracks()
    {
        tracks = new ArrayList<>();
        Track track = new Track(1, "Trivium", "Silence In The Snow", "https://www.youtube.com/watch?v=PcIlZ3luYHc");
        tracks.add(track);
        return tracks;
    }
}
