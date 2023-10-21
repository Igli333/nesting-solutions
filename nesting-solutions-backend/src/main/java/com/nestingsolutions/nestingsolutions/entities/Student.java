package com.nestingsolutions.nestingsolutions.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Individual {

    @ManyToOne()
    @JoinColumn(name = "contract", referencedColumnName = "id")
    private Contract contract;

    @OneToMany(mappedBy = "student")
    private Set<Application> applications;
}
