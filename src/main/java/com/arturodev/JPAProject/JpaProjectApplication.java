package com.arturodev.JPAProject;

import com.arturodev.JPAProject.persistence.entity.Address;
import com.arturodev.JPAProject.persistence.entity.Customer;
import com.arturodev.JPAProject.persistence.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaProjectApplication {

    public JpaProjectApplication(CustomerRepository customerRepository) {
    }

    public static void main(String[] args) {

        SpringApplication.run(JpaProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner testCustomerRepository(CustomerRepository customerRepository) {
        return args -> {

            Customer arturo = new Customer();
            arturo.setName("Arturo");
            arturo.setPassword("arturo123");
            arturo.setUsername("arturoP");

            Address addressArturoOne = new Address();
            addressArturoOne.setCountry("Peru");
            addressArturoOne.setAddress("Huacho - Lima");

            Address addressArturoTwo = new Address();
            addressArturoTwo.setCountry("Peru");
            addressArturoTwo.setAddress("Barranca - Lima");

            arturo.setAddresses(List.of(addressArturoOne, addressArturoTwo));
            System.out.println(arturo);
//            customerRepository.save(arturo);

        };
    }

}
