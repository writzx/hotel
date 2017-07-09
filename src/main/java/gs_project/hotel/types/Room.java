package gs_project.hotel.types;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Room implements Serializable {
    private static final long serialVersionUID = 4551019941238523542L;

    private int roomNo;
    private ArrayList<Booking> bookings;

    public Room(int roomNo) {
        this.roomNo = roomNo;
    }

    ///region getter and setter
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
    ///endregion
}
