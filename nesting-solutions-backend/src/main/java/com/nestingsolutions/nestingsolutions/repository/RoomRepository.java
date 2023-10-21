package com.nestingsolutions.nestingsolutions.repository;

import com.nestingsolutions.nestingsolutions.entities.Room;
import com.nestingsolutions.nestingsolutions.entities.RoomType;
import com.nestingsolutions.nestingsolutions.enums.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByStatus(RoomStatus status);

    Room findByStatusAndRoomType(RoomStatus roomStatus, RoomType roomType);
}
