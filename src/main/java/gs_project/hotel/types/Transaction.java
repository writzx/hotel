package gs_project.hotel.types;

import java.io.Serializable;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 9071496018558466912L;

    private String id;
    private int value;
    private String date;
    private String details;
}
