import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Show {
    private String id;
    private Movie movie;
    private Theater theater;
    private List<Seat> seats;
    private Map<String, Booking> bookings = new HashMap<>();
    private LocalDateTime showTime;

    public Show(Movie movie, String id, Theater theater, List<Seat> seats, LocalDateTime showTime, Integer capacity) {
        this.movie = movie;
        this.id = id;
        this.theater = theater;
        this.seats = new ArrayList<>();
        this.showTime = showTime;
        for (int i = 0; i < capacity; i++) {
            seats.add(new Seat(i+1, SeatType.ORDINARY));
        }
    }

    public String getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public List<Seat> getAvailableSeats() {
        return seats.stream().filter(Seat::isAvailable).collect(Collectors.toList());
    }

    public Booking bookSeats(User user, List<Integer> seatNumbers) {
        List<Seat> bookedSeat = new ArrayList<>();
        for (int sn: seatNumbers) {
            Seat seat = seats.get(sn);
            if (seat.isAvailable()) {
                bookedSeat.add(seat);
            }
            System.out.println("Un-available Seats, Please book available seats");
            return null;
        }

        Booking newBooking = new Booking(UUID.randomUUID().toString(), bookedSeat, this, user);
        bookings.put(newBooking.getId(), newBooking);
        user.addBookings(newBooking);
        return newBooking;
    }

    public boolean cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking == null) {
            System.out.println("No such Booking");
            return false;
        };
        booking.cancel();
        return true;
    }
}
