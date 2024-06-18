package com.arturodev.JPAProject.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String address;

    @Setter
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
}
