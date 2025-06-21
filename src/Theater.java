import java.util.List;

public class Theater {
    private String id;
    private String name;
    private String location;

    private List<Show> shows;

    public Theater(String name, String location, String id) {
        this.name = name;
        this.location = location;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void addShow(Show show) {
        shows.add(show);
    }
}
