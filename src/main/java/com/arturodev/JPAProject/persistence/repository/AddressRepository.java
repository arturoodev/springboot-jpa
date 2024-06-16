package com.arturodev.JPAProject.persistence.repository;


import com.arturodev.JPAProject.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
