package com.haui.project.service;

import com.haui.project.entity.Room;
import org.springframework.stereotype.Service;

import java.util.List;

//import com.haui.project.repository.RoomRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RoomService {
//    @Autowired
//    private RoomRepository roomRepository;
//}
@Service
public interface RoomService {
    public List<Room> getListRoom();
    public Room getRoomById(Long id);
    public List<Room> searchRoom(String keyword);
    public Room createRoom(Room newRoom);
    public boolean deleteRoom(Long id);
    public Room updateRoom(Long id, Room upRoom);

}