package gs_project.hotel.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoomClass implements Serializable {
    private static final long serialVersionUID = -5406400830796622677L;

    private String type;
    private int price; // per day
    private int adults;
    private int children;
    private ArrayList<Room> rooms;

    public RoomClass(String type, int price, int adults, int children, List<Room> rooms) {
        this.type = type;
        this.price = price;
        this.adults = adults;
        this.children = children;
        this.rooms = new ArrayList<>();
        this.rooms.addAll(rooms);
    }

    ///region getter and setter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
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

    public Room getStay(int roomNo) {
        for (Room s: rooms) {
            if (roomNo == s.getRoomNo()) return s;
        }
        return null;
    }
    ///endregion
}
