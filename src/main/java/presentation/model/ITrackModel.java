package presentation.model;

import domain.Track;

import java.util.List;

/**
 * Created by MOBO on 10-1-2016.
 */
public interface ITrackModel {
    List<Track> getAllTracks(String zoekterm);

    List<Track> getAllTracksFromPlaylist(int playlistid);

    void addToPlaylist(int trackid, int playlistid);
}
