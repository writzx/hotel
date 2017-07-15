package gs_project.hotel.types;

import java.io.Serializable;
import java.util.ArrayList;

public class Visitor implements Serializable {
    private static final long serialVersionUID = 167471118291580830L;

    private String cardId;
    private String name;
    private String emailId;
    private String contactNo;
    private String address;
    private String document;
    private ArrayList<Booking> bookings;

    public Visitor(String cardId, String name, String emailId, String contactNo, String address, String document, ArrayList<Booking> bookings) {
        this.cardId = cardId;
        this.name = name;
        this.emailId = emailId;
        this.contactNo = contactNo;
        this.address = address;
        this.document = document;
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

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
    ///endregion

    public Object[] toObjects() {
        return new Object[] {cardId, name, emailId, contactNo, address, document};
    }

    public static Object[] getColumns() {
        return new Object[] { "CARD ID", "NAME", "EMAIL", "CONTACT NO.", "ADDRESS", "VERIFY DOC" };
    }

    public static Object[][] toObjectsArray(java.util.List<Visitor> visitors) {
        Object[][] objects = new Object[visitors.size()][];
        int i = 0;
        for (Visitor s:visitors) {
            objects[i++] = s.toObjects();
        }
        return objects;
    }
}
