import java.util.ArrayList;
import java.util.List;

public class User {
    private final String id;
    private String name;
    private String phoneNumber;
    private List<Booking> bookings = new ArrayList<>();

    public User(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBookings(Booking booking) {
        bookings.add(booking);
    }

    public void updateProfile(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
