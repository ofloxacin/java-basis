package com.ofloxacin.maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author chens
 * @date 2019/8/18 18:03
 */
public class Maze {

    /**
     * 当前房间编号
     */
    private int rootNumber = 0;

    /**
     * 生成下一个房间编号
     */
    private int nextRoomNumber = 0;

    /**
     * 游戏中的房间
     */
    private List<Room> rooms = new ArrayList<>();

    private Map<Cor, Room> roomMap = new HashMap<>();

    /**
     * 添加房间
     */
    public void addRoom(Room room) {
        if (rooms.isEmpty()) {
            roomMap.put(new Cor(0, 0), room);
            this.rooms.add(room);
        } else {
            AbstractMapSide[] side = room.getSide();
            int i = 0;
            for (; i < side.length; i++) {
                if (side[i] instanceof Door) {
                    break;
                }
            }
            Door door = (Door) side[i];
            Optional<Room> first = rooms.stream().filter(r -> door.otherSideFrom(r) != null).findFirst();
            for (Map.Entry<Cor, Room> entry : roomMap.entrySet()) {
                Cor k = entry.getKey();
                Room v = entry.getValue();
                if (first.get().equals(v)) {
                    Cor nCor = new Cor(k.x, k.y);
                    switch (SideEnum.values()[i]) {
                        case EAST:
                            nCor.x--;
                            break;
                        case WEST:
                            nCor.x++;
                            break;
                        case SOUTH:
                            nCor.y--;
                            break;
                        case NORTH:
                            nCor.y++;
                            break;
                        default:
                            break;
                    }
                    roomMap.put(nCor, room);
                    this.rooms.add(room);
                    return;
                }
            }
        }
    }

    /**
     * 打印房间
     */
    public void printRoom() {
        int minX = 0;
        int minY = 0;
        int maxX = 0;
        int maxY = 0;
        for (Cor cor : roomMap.keySet()) {
            if (cor.x < minX) {
                minX = cor.x;
            }
            if (cor.x > maxX) {
                maxX = cor.x;
            }
            if (cor.y < minY) {
                minY = cor.y;
            }
            if (cor.y > maxY) {
                maxY = cor.y;
            }
        }

        for (int i = minY; i <= maxY; i++) {
            for (int k = 0; k < 5; k++) {
                for (int j = minX; j <= maxX; j++) {
                    Room room = roomMap.get(new Cor(j, i));
                    if (room == null) {
                        System.out.print("             ");
                    } else {
                        switch (k) {
                            case 0:
                                if (room.getSide()[SideEnum.NORTH.ordinal()] instanceof Door) {
                                    System.out.print("***** - *****");
                                } else {
                                    System.out.print("*************");
                                }
                                break;
                            case 1:
                                System.out.print(String.format("*% d         *", room.getRoomNumber()));
                                break;
                            case 2:
                                if (room.getSide()[SideEnum.WEST.ordinal()] instanceof Door &&
                                        room.getSide()[SideEnum.EAST.ordinal()] instanceof Door) {
                                    System.out.print("I           I");
                                } else if (room.getSide()[SideEnum.WEST.ordinal()] instanceof Door) {
                                    System.out.print("I           *");
                                } else if (room.getSide()[SideEnum.EAST.ordinal()] instanceof Door) {
                                    System.out.print("*           I");
                                } else {
                                    System.out.print("*           *");
                                }
                                break;
                            case 3:
                                System.out.print("*           *");
                                break;
                            case 4:
                                if (room.getSide()[SideEnum.SOUTH.ordinal()] instanceof Door) {
                                    System.out.print("***** - *****");
                                } else {
                                    System.out.print("*************");
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    /**
     * 获取下一个房间编号
     *
     * @return
     */
    public int nextRoomNumber() {
        return ++nextRoomNumber;
    }

    private class Cor {

        int x;

        int y;

        public Cor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Cor cor = (Cor) o;
            return x == cor.x &&
                    y == cor.y;
        }
    }
}