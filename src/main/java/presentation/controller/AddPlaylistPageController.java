package presentation.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import presentation.model.IPlaylistModel;
import presentation.model.PlaylistModel;
import presentation.model.TrackModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
public class AddPlaylistPageController extends HttpServlet {

    private IPlaylistModel playlistModel;

    @Inject
    public void setPlaylistModel(IPlaylistModel playlistModel){
        this.playlistModel = playlistModel;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("name") != null) {
            playlistModel.addPlaylist(request.getParameter("name"));
            response.sendRedirect("http://localhost:8080/");
        }
        else {
            request.getRequestDispatcher("addPlaylistView.jsp").forward(request, response);
        }
    }
}


