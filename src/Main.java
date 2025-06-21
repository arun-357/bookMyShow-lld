import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BookingSystem system = BookingSystem.getInstance();

        Movie movie = new Movie("M1", "Inception");
        Theater theater = new Theater("T1", "Cinepolis", "Mumbai");

        system.addMovie(movie);
        system.addTheater(theater);

        Show show = new Show("S1", movie, theater, LocalDateTime.now().plusHours(1), 10);
        system.addShow(show);

        User user = new User("U1", "Alice", "12345678");

        Booking booking = system.bookTicket(user, "S1", Arrays.asList(1, 2, 3));
        if (booking != null) {
            System.out.println("Booking successful. ID: " + booking.getId());
        } else {
            System.out.println("Booking failed.");
        }

        boolean cancelled = system.cancelTicket(show.getId(), booking.getId());
        System.out.println(cancelled ? "Booking cancelled." : "Cancel failed.");
    }
}
