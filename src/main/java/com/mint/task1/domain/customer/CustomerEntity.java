package com.mint.task1.domain.customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(schema = "task1", name = "customer"
        )
public class CustomerEntity implements Serializable, Cloneable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(name ="name", nullable = false)
    private String name;

    @Column(name ="phone_no", nullable = false)
    private String phoneNo;



}
