package services;

import domain.Track;

import java.util.List;

/**
 * Created by MOBO on 10-1-2016.
 */
public interface ITrackService {
    List<Track> getAllTracks(String zoekterm);

    List<Track> getAllTracksFromPlaylist(int playlistid);

    void addToPlaylist(int playlistid, int trackid);
}
