package com.arturodev.JPAProject.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"addresses"})
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Address> addresses;

    public void addAddress(Address newAddress) {
        if (newAddress == null) return;
        if (addresses == null) addresses = new ArrayList<>();

        addresses.add(newAddress);
        newAddress.setCustomer(this);
    }
}