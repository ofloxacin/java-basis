package com.ofloxacin.maze;

/**
 * @author chens
 * @date 2019/8/18 18:03
 */
public class Room extends AbstractMapSide {

    /**
     * 房间编号
     */
    private int roomNumber;

    /**
     * 四个方向
     */
    private AbstractMapSide[] sides = new AbstractMapSide[4];

    /**
     * 初始化房间
     *
     * @param roomNumber 房间编号
     */
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public AbstractMapSide[] getSide() {
        return sides;
    }

    public void setSide(SideEnum sideEnum, AbstractMapSide side) {
        sides[sideEnum.ordinal()] = side;
    }

    @Override
    public void enter() {
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}