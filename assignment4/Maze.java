import java.util.HashMap;
import java.util.Map;

public class Maze {
      private Map<Integer, Room> rooms = new HashMap<>();

      public void addRoom(Room r) {
            rooms.put(r.getRoomNo(), r);
      }

      public Room roomNumber(int r) {
            return rooms.get(r);
      }
}
