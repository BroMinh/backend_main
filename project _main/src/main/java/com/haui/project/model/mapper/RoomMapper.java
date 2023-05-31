package com.haui.project.model.mapper;

import com.haui.project.entity.Room;

public class RoomMapper {
    public static Room toRoom(Room room){
        Room tmp = new Room();
        tmp.setRoomId(room.getRoomId());
        tmp.setRoomName(room.getRoomName());
        tmp.setRoomCategory(room.getRoomCategory());
        tmp.setRoomPrice(room.getRoomPrice());
        tmp.setRoomStatus(room.getRoomStatus());

        return tmp;
    }
}
