package com.arturodev.JPAProject.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Addres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String address;

    public Long getId() {return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Addres{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
