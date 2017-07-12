package gs_project.hotel.types;

import java.io.Serializable;

public class Dish implements Serializable {
    private static final long serialVersionUID = 4118733230684610511L;

    private int price;
    private String name;
    private int minQuantity;
    private int maxQuantity;
}
