package com.ofloxacin.maze;

/**
 * @author chens
 * @date 2019/8/18 18:23
 */
public class MazeGame {

    public static void main(String[] args) {
        MazeGame mazeGame = new MazeGame();
        Maze maze = mazeGame.createMaze();
        maze.printRoom();
    }

    /**
     * 创建迷宫
     *
     * @return
     */
    public Maze createMaze() {
        Maze maze = new Maze();
        Room room1 = new Room(maze.nextRoomNumber());
        Room room2 = new Room(maze.nextRoomNumber());
        Room room3 = new Room(maze.nextRoomNumber());
        Room room4 = new Room(maze.nextRoomNumber());
        Room room5 = new Room(maze.nextRoomNumber());

        Door door12 = new Door(room1, room2);
        Door door13 = new Door(room1, room3);
        Door door14 = new Door(room1, room4);
        Door door15 = new Door(room1, room5);

        room1.setSide(SideEnum.EAST, door14);
        room1.setSide(SideEnum.WEST, door12);
        room1.setSide(SideEnum.SOUTH, door15);
        room1.setSide(SideEnum.NORTH, door13);

        room2.setSide(SideEnum.EAST, door12);
        room2.setSide(SideEnum.WEST, new Wall());
        room2.setSide(SideEnum.SOUTH, new Wall());
        room2.setSide(SideEnum.NORTH, new Wall());

        room3.setSide(SideEnum.EAST, new Wall());
        room3.setSide(SideEnum.WEST, new Wall());
        room3.setSide(SideEnum.SOUTH, door13);
        room3.setSide(SideEnum.NORTH, new Wall());

        room4.setSide(SideEnum.EAST, new Wall());
        room4.setSide(SideEnum.WEST, door14);
        room4.setSide(SideEnum.SOUTH, new Wall());
        room4.setSide(SideEnum.NORTH, new Wall());

        room5.setSide(SideEnum.EAST, new Wall());
        room5.setSide(SideEnum.WEST, new Wall());
        room5.setSide(SideEnum.SOUTH, new Wall());
        room5.setSide(SideEnum.NORTH, door15);

        maze.addRoom(room1);
        maze.addRoom(room2);
        maze.addRoom(room3);
        maze.addRoom(room4);
        maze.addRoom(room5);
        return maze;
    }
}
