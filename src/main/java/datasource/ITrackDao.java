package datasource;

import domain.Track;

import java.util.List;

/**
 * Created by MOBO on 10-1-2016.
 */
public interface ITrackDao {
    List<Track> findAll();

    List<Track> findByTitle(String zoekterm);

    List<Track> findByPlaylist(int playlistid);

    void addTrackToPlaylist(int playlistid, int trackid);
}
