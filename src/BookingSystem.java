import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingSystem {
    private static BookingSystem instance;

    private Map<String, Theater> theaters = new HashMap<>();
    private Map<String, Movie> movies = new HashMap<>();
    private Map<String, Show> shows = new HashMap<>();

    private BookingSystem() {}

    public static BookingSystem getInstance() {
        if (instance == null) {
            instance = new BookingSystem();
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        movies.put(movie.getId(), movie);
    }

    public void addTheater(Theater theater) {
        theaters.put(theater.getId(), theater);
    }

    public void addShow(Show show) {
        show.getMovie().addShows(show);
        show.getTheater().addShow(show);
        shows.put(show.getId(), show);
    }

    public Booking bookTicket(User user, String showId, List<Integer> seatNumbers) {
        Show show = shows.get(showId);
        if (show == null) return null;
        return show.bookSeats(user, seatNumbers);
    }

    public boolean cancelTicket(String showId, String bookingId) {
        Show show = shows.get(showId);
        if (show == null) return false;
        return show.cancelBooking(bookingId);
    }

    public List<Show> getAvailableShows(String movieId) {
        return shows.values().stream().filter(s -> s.getMovie().getId().equals(movieId)).collect(Collectors.toList());
    }
}
