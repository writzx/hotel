package gs_project.hotel.types;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuPackage implements Serializable {
    private static final long serialVersionUID = -7047712949636437217L;

    private String type;
    private ArrayList<Dish> starters;
    private ArrayList<Dish> maincourse;
    private ArrayList<Dish> desserts;

    public MenuPackage(String type, ArrayList<Dish> starters, ArrayList<Dish> maincourse, ArrayList<Dish> desserts) {
        this.type = type;
        this.starters = starters;
        this.maincourse = maincourse;
        this.desserts = desserts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Dish> getStarters() {
        return starters;
    }

    public void setStarters(ArrayList<Dish> starters) {
        this.starters = starters;
    }

    public ArrayList<Dish> getMaincourse() {
        return maincourse;
    }

    public void setMaincourse(ArrayList<Dish> maincourse) {
        this.maincourse = maincourse;
    }

    public ArrayList<Dish> getDesserts() {
        return desserts;
    }

    public void setDesserts(ArrayList<Dish> desserts) {
        this.desserts = desserts;
    }
}
