package presentation.model;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import domain.Track;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import services.ITrackService;

import java.util.List;

/**
 * Created by MOBO on 10-1-2016.
 */
public class TrackModelTest extends TestCase {
    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(ITrackService.class).to(MockTrackService.class);
            }
        });
    }

    @After
    public void tearDown() throws Exception {
        injector = null;
    }

    public void testGetAllTracks() throws Exception {
        String Zoekterm = "Trivium";
        TrackModel trackModel = injector.getInstance(TrackModel.class);
        List<Track> tracks = trackModel.getAllTracks(Zoekterm);

        Assert.assertEquals("Trivium", tracks.get(0).getPerformer());
        Assert.assertEquals("https://www.youtube.com/watch?v=PcIlZ3luYHc", tracks.get(0).getUrl());
        Assert.assertEquals("Silence In The Snow", tracks.get(0).getTitle());

    }

    public void testGetAllTracksFromPlaylist() throws Exception {
        TrackModel trackModel = injector.getInstance(TrackModel.class);
        List<Track> tracks = trackModel.getAllTracksFromPlaylist(1);

        Assert.assertEquals("Trivium", tracks.get(0).getPerformer());
        Assert.assertEquals("https://www.youtube.com/watch?v=PcIlZ3luYHc", tracks.get(0).getUrl());
        Assert.assertEquals("Silence In The Snow", tracks.get(0).getTitle());
    }
}