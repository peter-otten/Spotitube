package presentation.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import domain.Playlist;
import domain.Track;
import presentation.model.IPlaylistModel;
import presentation.model.ITrackModel;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Singleton
public class PlaylistViewPageController extends HttpServlet {
    private IPlaylistModel playlistModel;
    private ITrackModel trackModel;

    @Inject
    public void setPlaylistModel(IPlaylistModel playlistModel){
        this.playlistModel = playlistModel;
    }
    @Inject
    public void setTrackModel(ITrackModel trackModel){
        this.trackModel = trackModel;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("playlistid") != null) {
            List<Track> tracks = this.trackModel.getAllTracksFromPlaylist(Integer.parseInt(request.getParameter("playlistid")));
            request.setAttribute("all", tracks);
            request.getRequestDispatcher("playlistView.jsp").forward(request, response);
        }
        else {
            List<Playlist> playlist = this.playlistModel.getAllPlaylists("peter");
            request.setAttribute("all", playlist);
            request.getRequestDispatcher("viewPlaylists.jsp").forward(request, response);
        }
    }
}
