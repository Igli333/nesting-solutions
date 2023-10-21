package com.nestingsolutions.nestingsolutions.entities;

import com.nestingsolutions.nestingsolutions.enums.Floor;
import com.nestingsolutions.nestingsolutions.enums.RoomStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "status")
    private RoomStatus status;

    @Column(name = "floor")
    private Floor floor;

    @OneToMany(mappedBy = "room")
    private Set<Contract> contracts;

}
