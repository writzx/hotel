package gs_project.hotel.types;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {
    private static final long serialVersionUID = 4551019941238523542L;

    private int roomNo;
    private ArrayList<Booking> bookings;

    public Room(int roomNo) {
        this.roomNo = roomNo;
        bookings = new ArrayList<>();
    }

    public Room(int roomNo, ArrayList<Booking> bookings) {
        this.roomNo = roomNo;
        this.bookings = bookings;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
}
