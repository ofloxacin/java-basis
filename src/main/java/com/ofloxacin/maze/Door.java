package com.ofloxacin.maze;

/**
 * @author chens
 * @date 2019/8/18 18:03
 */
public class Door extends AbstractMapSide {

    /**
     * 房间1
     */
    private final Room room1;

    /**
     * 房间2
     */
    private final Room room2;

    /**
     * 门是否已经开启
     */
    private boolean isOpen;

    /**
     * 构造函数
     *
     * @param room1 房间1
     * @param room2 房间2
     */
    public Door(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }

    /**
     * 门相邻的房间
     *
     * @param room 当前房间
     * @return
     */
    public Room otherSideFrom(Room room) {
        if (room1.equals(room)) {
            return room2;
        }
        if (room2.equals(room)) {
            return room1;
        }
        return null;
    }

    @Override
    public void enter() {

    }
}
