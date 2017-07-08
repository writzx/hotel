package gs_project.hotel.types;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

public class Stay implements Serializable {
    private static final long serialVersionUID = 4551019941238523542L;

    private int roomNo;
    private Map<LocalDate, LocalDate> durations;

    public Stay(int roomNo, Map<LocalDate, LocalDate> durations) {
        this.roomNo = roomNo;
        this.durations = durations;
    }

    ///region getter and setter
    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public Map<LocalDate, LocalDate> getDurations() {
        return durations;
    }

    public void setDurations(Map<LocalDate, LocalDate> durations) {
        this.durations = durations;
    }
    ///endregion
}
