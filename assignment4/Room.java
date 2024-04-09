import java.util.HashMap;
import java.util.Map;

public class Room {
      private Map<Direction, Wall> sides = new HashMap<>();
      private int roomNo;

      public Room(int roomNo) {
            this.roomNo = roomNo;
      }

      public Wall getSide(Direction direction) {
            return sides.get(direction);
      }

      public void setSide(Direction direction, Wall wall) {
            sides.put(direction, wall);
      }

      public void enter() {
            System.out.println("You have entered room " + roomNo);
      }

      public int getRoomNo() {
            return roomNo;
      }
}
