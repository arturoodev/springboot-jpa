package com.arturodev.JPAProject.persistence.repository;

import com.arturodev.JPAProject.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> searchByUsername(String username);

    //SELECT c.* FROM customers c WHERE c.name like %?%
    List<Customer> findByNameContaining(String name);

    List<Customer> findByNameContainingIgnoreCase(String name);

    //SELECT c.* FROM customers c WHERE c.name like ?%
    List<Customer> findByNameStartingWith(String name);

    //SELECT c.* FROM customers c WHERE c.name like %?
    List<Customer> findByNameEndingWith(String name);
}
