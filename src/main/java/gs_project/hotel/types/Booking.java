package gs_project.hotel.types;

import java.io.Serializable;
import java.util.ArrayList;

public class Booking implements Serializable {
    private static final long serialVersionUID = -4719594577259543042L;

    private String id;
    private String bookingdate;
    private String checkindate;
    private String checkoutdate;
    private String bookingstate;
    private ArrayList<Transaction> transactions;

    public Booking(String id, String bookingdate, String checkindate, String checkoutdate, String bookingstate, ArrayList<Transaction> transactions) {
        this.id = id;
        this.bookingdate = bookingdate;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.bookingstate = bookingstate;
        this.transactions = transactions;
    }

    public Booking(String id, String bookingdate, String checkindate, String checkoutdate, String bookingstate) {
        this(id, bookingdate, checkindate, checkoutdate, bookingstate, new ArrayList<>());
    }

    public static Object[] getColumns() {
        return new Object[]{"BOOKING ID", "DATE", "CHECK IN", "CHECK OUT", "STATUS"};
    }

    public static Object[][] toObjectsArray(java.util.List<Booking> bookings) {
        Object[][] objects = new Object[bookings.size()][];
        int i = 0;
        for (Booking s : bookings) {
            objects[i++] = s.toObjects();
        }
        return objects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }

    public String getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(String checkindate) {
        this.checkindate = checkindate;
    }

    public String getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(String checkoutdate) {
        this.checkoutdate = checkoutdate;
    }

    public String getBookingstate() {
        return bookingstate;
    }

    public void setBookingstate(String bookingstate) {
        this.bookingstate = bookingstate;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Object[] toObjects() {
        return new Object[]{id, bookingdate, checkindate, checkoutdate, bookingstate};
    }
}
