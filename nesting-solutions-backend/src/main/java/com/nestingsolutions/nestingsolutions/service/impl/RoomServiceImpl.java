package com.nestingsolutions.nestingsolutions.service.impl;

import com.nestingsolutions.nestingsolutions.config.Mapper;
import com.nestingsolutions.nestingsolutions.dto.RoomDto;
import com.nestingsolutions.nestingsolutions.entities.Room;
import com.nestingsolutions.nestingsolutions.repository.RoomRepository;
import com.nestingsolutions.nestingsolutions.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final Mapper mapper;

    @Override
    public RoomDto findRoom(Long id) {
        Room room = null;
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent()){
            room = roomOptional.get();
        }
        return mapper.map(room, RoomDto.class);
    }

    @Override
    public List<RoomDto> allRooms() {
        List<RoomDto> roomDtoList = new ArrayList<>();

        for(Room roomInDb: roomRepository.findAll()){
            roomDtoList.add(mapper.map(roomInDb, RoomDto.class));
        }

        return roomDtoList;
    }
}
