package com.nestingsolutions.nestingsolutions.controller;

import com.nestingsolutions.nestingsolutions.dto.RoomDto;
import com.nestingsolutions.nestingsolutions.service.RoomService;
import lombok.RequiredArgsConstructor;
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
    public List<RoomDto> getAllRooms(){
        return roomService.allRooms();
    }
    @GetMapping("/{roomId}")
    public RoomDto getRoom(@PathVariable Long roomId){
        return roomService.findRoom(roomId);
    }
}
