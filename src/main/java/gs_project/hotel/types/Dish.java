package gs_project.hotel.types;

import java.io.Serializable;

public class Dish implements Serializable {
    private static final long serialVersionUID = 4118733230684610511L;

    private String name;
    private int minQuantity;
    private int maxQuantity;
    private int price;

    public Dish(String name, int minQuantity, int maxQuantity, int price) {
        this.name = name;
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Object[] toObjects() {
        return new Object[] { name, minQuantity, maxQuantity, price};
    }

    public static Object[] getColumns() {
        return new Object[] { "NAME", "MIN. QUANTITY", "MAX. QUANTITY", "PRICE"};
    }

    public static Object[][] toObjectsArray(java.util.List<Dish> dishes) {
        Object[][] objects = new Object[dishes.size()][];
        int i = 0;
        for (Dish s:dishes) {
            objects[i++] = s.toObjects();
        }
        return objects;
    }
}
