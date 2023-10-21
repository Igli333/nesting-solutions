package com.nestingsolutions.nestingsolutions.repository;

import com.nestingsolutions.nestingsolutions.entities.Room;
import com.nestingsolutions.nestingsolutions.entities.RoomType;
import com.nestingsolutions.nestingsolutions.enums.Floor;
import com.nestingsolutions.nestingsolutions.enums.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findRoomsByStatus(RoomStatus status);
    List<Room> findRoomsByFloor(Floor floor);
    Room findByStatusAndRoomType(RoomStatus roomStatus, RoomType roomType);
}
