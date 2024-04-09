public class MazeBuilder {
      private Maze maze;

      public MazeBuilder() {
            this.maze = new Maze();
      }

      public MazeBuilder addRoom(Room room) {
            maze.addRoom(room);
            return this;
      }

      public MazeBuilder addDoorWall(Room r1, Room r2) {
            DoorWall d = new DoorWall(r1, r2);
            r1.setSide(Direction.NORTH, d);
            r2.setSide(Direction.SOUTH, d);
            return this;
      }

      public MazeBuilder addWall(Room room, Direction direction) {
            WallImpl wall = new WallImpl();
            room.setSide(direction, wall);
            return this;
      }

      public Maze build() {
            return maze;
      }
}
