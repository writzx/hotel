package gs_project.hotel.types;

import java.io.Serializable;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 9071496018558466912L;

    private String id;
    private String bookingid;
    private int value;
    private String date;
    private String details;

    public Transaction(String id, String bookingid, int value, String date, String details) {
        this.id = id;
        this.bookingid = bookingid;
        this.value = value;
        this.date = date;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public Object[] toObjects() {
        return new Object[] {id, bookingid, value, date, details};
    }

    public static Object[] getColumns() {
        return new Object[] { "TRANSACTION ID", "BOOKING ID", "AMOUNT", "DATE", "DETAILS" };
    }

    public static Object[][] toObjectsArray(java.util.List<Transaction> transactions) {
        Object[][] objects = new Object[transactions.size()][];
        int i = 0;
        for (Transaction s:transactions) {
            objects[i++] = s.toObjects();
        }
        return objects;
    }

    public static Object[] getBillingColumns() { return new Object[] {"SL. NO.", "DETAILS", "AMOUNT"}; }

    public Object[] toBillingObjects(int index) { return new Object[] { (index + 1), details.replace("[PAID]", "").replace("[PENDING]", ""), value}; }

    public static Object[][] toBillingObjectsArray(java.util.List<Transaction> transactions) {
        Object[][] objects = new Object[transactions.size()][];
        int i = 0;
        for (Transaction s:transactions) {
            objects[i] = s.toBillingObjects(i++);
        }
        return objects;
    }
}
