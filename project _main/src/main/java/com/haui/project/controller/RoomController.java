package com.haui.project.controller;

import com.haui.project.entity.Room;
import com.haui.project.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@CrossOrigin
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping("/search")
    public ResponseEntity<?> searchRoom(@RequestParam(name = "keyword", required = false, defaultValue = "") String name){
        List<Room> rooms = roomService.searchRoom(name);
        return ResponseEntity.ok(rooms);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getListRoom(){
        List<Room> rooms = roomService.getListRoom();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable Long id){
        Room result = roomService.getRoomById(id);
        return ResponseEntity.ok(result);
    }
    @PostMapping(path = "/add",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createRoom(@RequestBody Room newRoom){
        Room room = roomService.createRoom(newRoom);
        return ResponseEntity.ok(room);
    }

    @PutMapping(path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> updateRoom(@PathVariable Long id,@RequestBody Room upRoom){
        Room room = roomService.updateRoom(id, upRoom);
        return ResponseEntity.ok(room);
    }

    @DeleteMapping(path="/delete/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteRoom(@PathVariable Long id){
        boolean room = roomService.deleteRoom(id);
        return ResponseEntity.ok(room);
    }
}
