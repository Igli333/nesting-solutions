package com.nestingsolutions.nestingsolutions.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private Character gender;

    @Column(name = "personalId")
    private String personalId;

    @Column(name = "dateofbirth")
    private Date dateOfBirth;

    @Column(name = "paid_this_month")
    private Boolean paidThisMonth;

    @ManyToOne()
    @JoinColumn(name = "contract", referencedColumnName = "id")
    private Contract contract;

    @OneToMany(mappedBy = "student")
    private Set<Application> applications;
}
