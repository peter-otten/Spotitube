package services;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import datasource.ITrackDao;
import domain.Track;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import services.rest.TrackRestService;

import java.util.List;

public class TrackServiceTest extends TestCase {

    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(ITrackDao.class).to(MockTrackDoa.class);
            }
        });
    }

    @After
    public void tearDown() throws Exception {
        injector = null;
    }

    public void testGetAllTracks() throws Exception {
        String Zoekterm = "Trivium";
        TrackService trackService = injector.getInstance(TrackService.class);
        List<Track> tracks = trackService.getAllTracks(Zoekterm);

        Assert.assertEquals("Trivium", tracks.get(0).getPerformer());
        Assert.assertEquals("https://www.youtube.com/watch?v=PcIlZ3luYHc", tracks.get(0).getUrl());
        Assert.assertEquals("Silence In The Snow", tracks.get(0).getTitle());

        TrackRestService trackRestService = injector.getInstance(TrackRestService.class);
        List<Track> tracksRest = trackRestService.getAllTracks(Zoekterm);

        Assert.assertEquals("Trivium", tracksRest.get(0).getPerformer());
        Assert.assertEquals("https://www.youtube.com/watch?v=PcIlZ3luYHc", tracksRest.get(0).getUrl());
        Assert.assertEquals("Silence In The Snow", tracksRest.get(0).getTitle());
    }

    public void testGetAllTracksFromPlaylist() throws Exception {
        TrackService trackService = injector.getInstance(TrackService.class);
        List<Track> tracks = trackService.getAllTracksFromPlaylist(1);

        Assert.assertEquals("Trivium", tracks.get(0).getPerformer());
        Assert.assertEquals("https://www.youtube.com/watch?v=PcIlZ3luYHc", tracks.get(0).getUrl());
        Assert.assertEquals("Silence In The Snow", tracks.get(0).getTitle());

        TrackRestService trackRestService = injector.getInstance(TrackRestService.class);
        List<Track> tracksRest = trackRestService.getAllTracksFromPlaylist(1);

        Assert.assertEquals("Trivium", tracksRest.get(0).getPerformer());
        Assert.assertEquals("https://www.youtube.com/watch?v=PcIlZ3luYHc", tracksRest.get(0).getUrl());
        Assert.assertEquals("Silence In The Snow", tracksRest.get(0).getTitle());
    }
}