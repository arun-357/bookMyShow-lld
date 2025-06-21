import java.util.List;

public class Booking {
    private String id;
    private Show show;
    private List<Seat> seats;
    private User user;
    private boolean isCancelled;

    public Booking(String id, List<Seat> seats, Show show, User user) {
        this.id = id;
        this.seats = seats;
        this.show = show;
        this.user = user;
        this.isCancelled = false;
    }

    public String getId() {
        return id;
    }

    public void cancel() {
        for (Seat seat: seats) {
            seat.setAvailable(true);
        }
        isCancelled = true;
    }
}
