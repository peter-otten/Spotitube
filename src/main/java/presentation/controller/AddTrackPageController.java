package presentation.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import domain.Track;
import presentation.model.ITrackModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Singleton
public class AddTrackPageController extends HttpServlet {

    private ITrackModel trackModel;

    @Inject
    public void setTrackModel(ITrackModel trackModel){
        this.trackModel = trackModel;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("playlistid") != null) {
            if (request.getParameter("zoekterm") != null) {
                List<Track> tracks = trackModel.getAllTracks(request.getParameter("zoekterm"));
                request.setAttribute("all", tracks);
                request.getRequestDispatcher("searchresults.jsp").forward(request, response);
            } else  if(request.getParameter("trackid") != null) {
                int trackid = Integer.parseInt(request.getParameter("trackid"));
                int playlistid = Integer.parseInt(request.getParameter("playlistid"));
                System.out.println(playlistid);
                trackModel.addToPlaylist(trackid, playlistid);
                response.sendRedirect("http://localhost:8080/viewPlaylist?playlistid=" + playlistid);
            }
            else
                {
                    request.getRequestDispatcher("addTrackView.jsp").forward(request, response);
                }
            }
        }
    }

