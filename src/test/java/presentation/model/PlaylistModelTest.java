package presentation.model;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import datasource.IPlaylistDao;
import domain.Playlist;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import services.IPlaylistService;
import services.MockPlaylistDoa;
import services.PlaylistService;
import services.rest.PlaylistRestService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MOBO on 10-1-2016.
 */
public class PlaylistModelTest extends TestCase {
    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(IPlaylistService.class).to(MockPlaylistService.class);
            }
        });
    }

    @After
    public void tearDown() throws Exception {
        injector = null;
    }

    public void testGetAllPlaylists() throws Exception {
        PlaylistModel playlistModel = injector.getInstance(PlaylistModel.class);
        List<Playlist> playlists = new ArrayList<Playlist>();
        playlists = playlistModel.getAllPlaylists("peter");

        Assert.assertEquals(1, playlists.size());
        Assert.assertEquals("peter", playlists.get(0).getOwner());
        Assert.assertEquals("testPlaylist", playlists.get(0).getName());
    }
}