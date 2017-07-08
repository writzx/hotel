package gs_project.hotel.types;

import java.io.Serializable;
import java.util.List;

public class Room implements Serializable {
    private static final long serialVersionUID = -5406400830796622677L;

    private String id;
    private String type;
    private int count;
    private int price; // per day
    private int adults;
    private int children;
    private List<Stay> stays;

    public Room(String id, String type, int count, int price, List<Stay> stays, int adults, int children) {
        this.id = id;
        this.type = type;
        this.count = count;
        this.price = price;
        this.stays = stays;
        this.adults = adults;
        this.children = children;
    }

    ///region getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Stay> getStays() {
        return stays;
    }

    public void setStays(List<Stay> stays) {
        this.stays = stays;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public Stay getStay(int roomNo) {
        for (Stay s: stays) {
            if (roomNo == s.getRoomNo()) return s;
        }
        return null;
    }
    ///endregion
}
