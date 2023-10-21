package com.nestingsolutions.nestingsolutions.entities;

import com.nestingsolutions.nestingsolutions.enums.ContractType;
import com.nestingsolutions.nestingsolutions.enums.PaymentType;
import com.nestingsolutions.nestingsolutions.enums.RoomStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
    private Integer id;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "room", nullable = false)
    private RoomStatus room;
}
