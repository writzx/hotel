package gs_project.hotel.types;

import java.io.Serializable;
import java.util.List;

public class Visitor implements Serializable {
    private static final long serialVersionUID = 167471118291580830L;

    private String cardId;
    private String name;
    private String emailId;
    private String contactNo;
    private String address;
    private List<Booking> bookings;

    public Visitor(String cardId, String name, String emailId, String contactNo, String address, List<Booking> bookings) {
        this.cardId = cardId;
        this.name = name;
        this.emailId = emailId;
        this.contactNo = contactNo;
        this.address = address;
        this.bookings = bookings;
    }

    ///region getter and setter
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
    ///endregion
}
