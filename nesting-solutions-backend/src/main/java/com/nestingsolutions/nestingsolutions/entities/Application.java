package com.nestingsolutions.nestingsolutions.entities;

import com.nestingsolutions.nestingsolutions.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "application")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private ApplicationStatus status;

    @Column(name = "code")
    private String code;

    @Column(name = "date_of_submission")
    private Date dateOfSubmission;

    @ManyToOne
    @JoinColumn(name = "student", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "roomType", nullable = false)
    private RoomType roomType;

}
