package gs_project.hotel.types;

import java.io.Serializable;

public class Operator implements Serializable {
    private static final long serialVersionUID = -1797206988567139009L;

    private String uid;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Operator(String uid, String password, String name, String email, String phoneNumber, String address) {
        this.uid = uid;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Object[] toObjects() {
        return new Object[] { uid, name, email, password, phoneNumber, address };
    }

    public static Object[] getColumns() {
        return new Object[] { "USER ID", "NAME","EMAIL","PASSWORD","CONTACT NO.","ADDRESS" };
    }

    public static Object[][] toObjectsArray(java.util.List<Operator> operators) {
        Object[][] objects = new Object[operators.size()][];
        int i = 0;
        for (Operator s:operators) {
            objects[i++] = s.toObjects();
        }
        return objects;
    }
}
