package com.nestingsolutions.nestingsolutions.service.impl;

import com.nestingsolutions.nestingsolutions.config.Mapper;
import com.nestingsolutions.nestingsolutions.dto.RoomDto;
import com.nestingsolutions.nestingsolutions.entities.Room;
import com.nestingsolutions.nestingsolutions.enums.Floor;
import com.nestingsolutions.nestingsolutions.enums.RoomStatus;
import com.nestingsolutions.nestingsolutions.repository.RoomRepository;
import com.nestingsolutions.nestingsolutions.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    @Override
    public List<RoomDto> roomsByFloor(Integer floorNumber) {
        List<RoomDto> roomDtoList = new ArrayList<>();
        Floor floorN = null;
        for (Floor floor : Floor.values()) {
            if (Objects.equals(floor.number, floorNumber)) {
                floorN = floor;
            }
        }

        for(Room roomInDb: roomRepository.findRoomsByFloor(floorN)){
            roomDtoList.add(mapper.map(roomInDb, RoomDto.class));
        }
        return roomDtoList;
    }

    @Override
    public List<RoomDto> roomsByStatus(String status) {
        List<RoomDto> roomDtoList = new ArrayList<>();
        for(Room roomInDb: roomRepository.findRoomsByStatus(RoomStatus.valueOf(status.toUpperCase()))){
            roomDtoList.add(mapper.map(roomInDb, RoomDto.class));
        }
        return roomDtoList;
    }

}
