package com.nestingsolutions.nestingsolutions.entities;

import com.nestingsolutions.nestingsolutions.enums.Floor;
import com.nestingsolutions.nestingsolutions.enums.RoomStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Long id;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "status")
    private RoomStatus status;

    @ManyToOne
    @JoinColumn(name = "roomType", nullable = false)
    private RoomType roomType;

    @Column(name = "floor")
    private Floor floor;

    @OneToOne(mappedBy = "room")
    private Contract contracts;

}
