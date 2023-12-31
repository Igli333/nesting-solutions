package com.nestingsolutions.nestingsolutions.entities;

import com.nestingsolutions.nestingsolutions.enums.ContractType;
import com.nestingsolutions.nestingsolutions.enums.PaymentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "contract")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Column(name = "date_of_start")
    private Date dateOfStart;

    @Column(name = "date_of_finish")
    private Date dateOfFinish;

    @Column(name = "type")
    private ContractType type;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "contract")
    private Set<Student> students;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room", referencedColumnName = "id")
    private Room room;
}
