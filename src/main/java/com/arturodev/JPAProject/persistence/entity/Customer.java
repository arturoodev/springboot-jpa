package com.arturodev.JPAProject.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;

    @OneToOne(targetEntity = Address.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;
}