package com.nestingsolutions.nestingsolutions.controller;

import com.nestingsolutions.nestingsolutions.dto.RoomDto;
import com.nestingsolutions.nestingsolutions.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomDto>> getAllRooms(){
        return ResponseEntity.ok(roomService.allRooms());
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomDto> getRoom(@PathVariable Long roomId){
        return ResponseEntity.ok(roomService.findRoom(roomId));
    }
    @GetMapping("/{roomStatus}")
    public ResponseEntity<List<RoomDto>> getAllRoomsByStatus(@PathVariable String roomStatus){
        return ResponseEntity.ok(roomService.roomsByStatus(roomStatus));
    }
    @GetMapping("/{floorNumber}")
    public ResponseEntity<List<RoomDto>> getRoomsOfFloor(@PathVariable Integer floorNumber){
        return ResponseEntity.ok(roomService.roomsByFloor(floorNumber));
    }
}
