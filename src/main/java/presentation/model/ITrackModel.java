package presentation.model;

import domain.Track;

import java.util.List;

/**
 * Created by MOBO on 10-1-2016.
 */
public interface ITrackModel {
    List<Track> getTracks(String zoekterm);

    List<Track> getTracksFromPlaylist(int playlistid);

    void addToPlaylist(int trackid, int playlistid);
}
