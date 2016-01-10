package services;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import datasource.IPlaylistDao;
import domain.Playlist;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import services.rest.PlaylistRestService;

import java.util.ArrayList;
import java.util.List;

public class PlaylistServiceTest extends TestCase {

    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(IPlaylistDao.class).to(MockPlaylistDoa.class);
            }
        });
    }

    @After
    public void tearDown() throws Exception {
        injector = null;
    }

    public void testFindAll() throws Exception {
        PlaylistService playlistService = injector.getInstance(PlaylistService.class);
        List<Playlist> playlists = new ArrayList<Playlist>();
        playlists = playlistService.findAll("peter");

        Assert.assertEquals(1, playlists.size());
        Assert.assertEquals("peter", playlists.get(0).getOwner());
        Assert.assertEquals("testPlaylist", playlists.get(0).getName());

        PlaylistRestService playlistRestService = injector.getInstance(PlaylistRestService.class);
        List<Playlist> playlistsRest = new ArrayList<Playlist>();
        playlistsRest = playlistRestService.findAll("peter");

        Assert.assertEquals(1, playlistsRest.size());
        Assert.assertEquals("peter", playlistsRest.get(0).getOwner());
        Assert.assertEquals("testPlaylist", playlistsRest.get(0).getName());
    }
}