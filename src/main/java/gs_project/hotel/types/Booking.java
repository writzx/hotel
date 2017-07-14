package gs_project.hotel.types;

import java.io.Serializable;

public class Booking implements Serializable {
    private static final long serialVersionUID = -4719594577259543042L;

    private String id;
    private String bookingdate;
    private String checkindate;
    private String checkoutdate;

    public Booking(String id, String bookingdate, String checkindate, String checkoutdate) {
        this.id = id;
        this.bookingdate = bookingdate;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
    }

    ///region getter and setter
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
    ///endregion
}
