import java.util.HashMap;
import java.util.Map;

public class MazeGame {
      public static void main(String[] argv) {
            createMaze();
      }

      private static void createMaze() {
            MazeBuilder builder = new MazeBuilder();
            Room r1 = new Room(1);
            Room r2 = new Room(2);

            builder.addRoom(r1)
                    .addRoom(r2)
                    .addDoorWall(r1, r2)
                    .addWall(r1, Direction.EAST)
                    .addWall(r1, Direction.SOUTH)
                    .addWall(r1, Direction.WEST)
                    .addWall(r2, Direction.NORTH)
                    .addWall(r2, Direction.EAST)
                    .addWall(r2, Direction.WEST);

            Maze maze = builder.build();
      }
}
