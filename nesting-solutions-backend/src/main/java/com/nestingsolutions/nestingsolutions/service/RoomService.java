package com.nestingsolutions.nestingsolutions.service;

import com.nestingsolutions.nestingsolutions.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto findRoom(Long id);

    List<RoomDto> allRooms();
}
