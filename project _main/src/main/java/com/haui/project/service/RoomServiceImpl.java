package com.haui.project.service;

import com.haui.project.entity.Room;
import com.haui.project.exeption.NotFoundException;
import com.haui.project.model.mapper.RoomMapper;
import com.haui.project.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class RoomServiceImpl implements RoomService{
    private static ArrayList<Room> rooms = new ArrayList<>();
    @Autowired
    private RoomRepository roomRepository;

//    static{
//        rooms.add(new Room(1,"P101","Cao cấp, giường đôi",900000,"Sẵn sàng"));
//        rooms.add(new Room(2,"P102","Cao cấp, giường đơn",500000,"Sẵn sàng"));
//        rooms.add(new Room(3, "P103","Thường, giường đôi",450000,"Chưa sẵn sàng"));
//        rooms.add(new Room(4, "P104","Thường, giường đơn",250000,"Đã thuê"));
//    }

    @Override
    public List<Room> getListRoom() {
        List<Room> result = new ArrayList<>();
        for(Room room:roomRepository.findAll()){
            result.add(RoomMapper.toRoom(room));
        }
        return result;
    }

    @Override
    public Room getRoomById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new NotFoundException("Room không tồn tại trong hệ thống"));
        return RoomMapper.toRoom(room);
    }

    public String unAccent(String s){
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCOMBINING_DIACRITICAL_MARKS}");
        return pattern.matcher(temp).replaceAll("");
    }
    @Override
    public List<Room> searchRoom(String keyword) {
        List<Room> result = new ArrayList<>();
        for(Room room:rooms){
            if(room.getRoomName().toLowerCase().contains(keyword.toLowerCase())
                    || unAccent(room.getRoomName()).toLowerCase().contains(unAccent(keyword.toLowerCase()))){
                result.add(RoomMapper.toRoom(room));
            }else {
                throw new NotFoundException("Không có room cần tìm kiếm!");
            }
        }
        return result;
    }

    @Override
    public Room createRoom(Room newRoom){
        return roomRepository.save(newRoom);
    }

    @Override
    public boolean deleteRoom(Long id) {
        if(!roomRepository.existsById(id)){
            throw new NotFoundException("Room không tồn tại trong hệ thống");
        }
        roomRepository.deleteById(id);
        return true;
    }

    @Override
    public Room updateRoom(Long id, Room upRoom) {
        return roomRepository.findById(id).map(room -> {
            room.setRoomName(upRoom.getRoomName());
            room.setRoomCategory(upRoom.getRoomCategory());
            room.setRoomPrice(upRoom.getRoomPrice());
            room.setRoomStatus(upRoom.getRoomStatus());
            return roomRepository.save(room);
        }).orElseThrow(() -> new NotFoundException("Room không tồn tại trong hệ thống"));
    }

}

