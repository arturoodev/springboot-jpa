package com.arturodev.JPAProject.persistence.repository;

import com.arturodev.JPAProject.persistence.entity.Customer;
import lombok.Lombok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Optional<Customer> searchByUsername(String username);

    //SELECT c.* FROM customers c WHERE c.name like %?%
    List<Customer> findByNameContaining(String name);

    List<Customer> findByNameContainingIgnoreCase(String name);

    //SELECT c.* FROM customers c WHERE c.name like ?%
    List<Customer> findByNameStartingWith(String name);

    //SELECT c.* FROM customers c WHERE c.name like %?
    List<Customer> findByNameEndingWith(String name);

    //SELECT c.* FROM customers c WHERE c.name like %?1% and c.id >= ?2 order by id desc
    List<Customer> findByNameContainingAndIdGreaterThanEqualOrderByIdDesc(String name, Long id);


    @Query("select c from Customer c where c.name like %?1% and c.id >= ?2 order by c.id desc ")
    List<Customer> findAllByNameAndIdGreaterThan(String name, Long id);

    List<Customer> findByAddressesCountry(String country);

    @Query("select c from Customer c join fetch addresses addr where addr.country = ?1")
    List<Customer> findCustomersFrom(String country);

}
