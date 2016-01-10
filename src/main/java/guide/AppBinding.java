package guide;

import com.google.inject.servlet.ServletModule;
import datasource.util.DatabaseProperties;
import datasource.util.IDatabaseProperties;
import presentation.controller.*;
import presentation.model.*;
import services.*;
import datasource.*;

public class AppBinding extends ServletModule {
    @Override
    protected void configureServlets() {
        super.configureServlets();
        serve("/viewPlaylist").with(PlaylistViewPageController.class); // het ging hier fout vgm
        serve("/addTrack").with(AddTrackPageController.class);
        serve("/addPlaylist").with(AddPlaylistPageController.class);


        bind(IPlaylistService.class).to(PlaylistService.class);
        bind(ITrackService.class).to(TrackService.class);

        bind(IPlaylistModel.class).to(PlaylistModel.class);
        bind(ITrackModel.class).to(TrackModel.class);

        bind(IPlaylistDao.class).to(PlaylistDao.class);
        bind(ITrackDao.class).to(TrackDao.class);

        bind(IDatabaseProperties.class).to(DatabaseProperties.class);
    }
}
