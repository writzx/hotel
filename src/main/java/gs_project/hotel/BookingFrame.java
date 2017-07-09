package gs_project.hotel;

import gs_project.hotel.types.Room;
import gs_project.hotel.types.RoomClass;

import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

public class BookingFrame extends MainFrame {
    public String username;
    public String usertype; // ADMIN or OPERATOR

    List<RoomClass> rooms = new ArrayList<>(); // read first

    public BookingFrame(String username, String usertype) {
        super("Booking Frame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.username = username;
        this.usertype = usertype;

        // STATUS BAR
        // LEFT PART OF STATUS BAR
        statusPanel.add(Box.createHorizontalStrut(4));
        statusPanel.add(new JLabel("Logged in as: " + username + " [" + usertype + "]"));

        statusPanel.add(Box.createHorizontalGlue());

        //RIGHT PART OF STATUS BAR
        statusPanel.add(dateStatus);
        statusPanel.add(Box.createHorizontalStrut(4));
        statusPanel.add(timeStatus);
        statusPanel.add(Box.createHorizontalStrut(4));
    }

//    int searchRoom(String type, LocalDate checkin, LocalDate checkout, int excludeRoom) {
//        int result = -1;
//        for (RoomClass room : rooms) {
//            if (room.getType().equals(type)) {
//                for (Room s : room.getRooms()) {
//                    List<LocalDate> startdates = new ArrayList<>();
//                    startdates.addAll(s.getDurations().keySet());
//                    List<LocalDate> enddates = new ArrayList<>();
//                    enddates.addAll(s.getDurations().values());
//                    for (int i = 0; i < s.getDurations().size() ; i++) {
//                        if (checkin.isAfter(enddates.get(i))) {
//                            if (startdates.get(i + 1).isBefore(checkout)) {
//                                result = searchRoom(type, startdates.get(i + 1), enddates.get(i + 1), s.getRoomNo());
//                                if (result != -1) {
//                                    // remove and add the room here
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                    if (result != -1) {
//                        break;
//                    }
//                }
//                // room.getStay(result).getDurations().put(checkin, checkout); // add booking here; *maybe*
//            }
//        }
//        return result;
//    }
}
