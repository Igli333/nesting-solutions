package com.nestingsolutions.nestingsolutions.entities;

import com.nestingsolutions.nestingsolutions.enums.ApplicationStatus;
import com.nestingsolutions.nestingsolutions.enums.RoomStatus;

import javax.persistence.*;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status")
    private ApplicationStatus status;

    @Column(name = "code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "student", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "room_type", nullable = false)
    private RoomType roomType;

}
