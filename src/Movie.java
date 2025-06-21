import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String id;
    private String title;
    private List<Show> shows = new ArrayList<>();

    public Movie(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public void addShows(Show show) {
        shows.add(show);
    }

    public boolean isShowAvailable() {
        return !shows.isEmpty();
    }
}
