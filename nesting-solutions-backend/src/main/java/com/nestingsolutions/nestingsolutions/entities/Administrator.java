package com.nestingsolutions.nestingsolutions.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Administrator extends Individual {
    @Column(name = "password")
    private String password;
}
