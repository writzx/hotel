package gs_project.hotel.types;

import java.io.Serializable;

public class Operator implements Serializable {
    private static final long serialVersionUID = -1797206988567139009L;

    private String uid;
    private String password;
    private String name;
    private String email;

    public Operator(String uid, String password, String name, String email) {
        this.uid = uid;
        this.password = password;
        this.name = name;
        this.email = email;
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
}
