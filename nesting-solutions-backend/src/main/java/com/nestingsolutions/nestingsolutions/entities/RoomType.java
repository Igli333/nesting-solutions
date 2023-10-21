package com.nestingsolutions.nestingsolutions.entities;

import com.nestingsolutions.nestingsolutions.enums.RoomCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "room_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private RoomCategory category;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "roomType")
    private Set<Application> applications;

    @OneToMany(mappedBy = "roomType")
    private Set<Room> rooms;
}
