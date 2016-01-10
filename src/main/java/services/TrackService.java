package services;

import com.google.inject.Inject;
import datasource.ITrackDao;
import domain.Track;

import java.util.List;

public class TrackService implements ITrackService {

    ITrackDao trackDao;

    @Inject
    public void setTrackDao(ITrackDao trackDao)
    {
        this.trackDao = trackDao;
    }

    @Override
    public List<Track> getAllTracks(String zoekterm) {
        return trackDao.findByTitle(zoekterm);
    }

    @Override
    public List<Track> getAllTracksFromPlaylist(int playlistid) {
        return trackDao.findByPlaylist(playlistid);
    }

    @Override
    public void addToPlaylist(int playlistid, int trackid) {
        trackDao.addTrackToPlaylist(playlistid, trackid);
    }

}
