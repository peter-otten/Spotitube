package domain;

public class Track {

    private int trackId;
    private String performer, title, url;

    public Track(int trackId, String performer, String title, String url) {
        this.trackId = trackId;
        this.performer = performer;
        this.title = title;
        this.url = url;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
