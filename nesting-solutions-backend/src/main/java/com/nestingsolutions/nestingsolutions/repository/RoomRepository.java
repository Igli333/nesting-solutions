package com.nestingsolutions.nestingsolutions.repository;

import com.nestingsolutions.nestingsolutions.entities.Room;
import com.nestingsolutions.nestingsolutions.entities.RoomType;
import com.nestingsolutions.nestingsolutions.enums.RoomStatus;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer> {
    Room findFirstByStatusAnd(RoomStatus status);

    Room findFirstByStatusAndAndRoomType(RoomStatus roomStatus, RoomType roomType);
}
