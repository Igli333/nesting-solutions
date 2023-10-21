package com.nestingsolutions.nestingsolutions.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Administrator {
    @Column(name = "password")
    private String password;
    @Getter
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

}
