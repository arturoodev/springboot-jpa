package com.arturodev.JPAProject;

import com.arturodev.JPAProject.persistence.entity.Address;
import com.arturodev.JPAProject.persistence.entity.Customer;
import com.arturodev.JPAProject.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
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
            Address addressArturo = new Address();
            addressArturo.setCountry("Peru");
            addressArturo.setAddress("Barranca - Lima");
            arturo.setAddress(addressArturo);

            Customer jose = new Customer();
            jose.setName("Jose");
            jose.setPassword("jose123");
            Address addressJose = new Address();
            addressJose.setCountry("Peru");
            addressJose.setAddress("Huacho - Lima");
            jose.setAddress(addressJose);

            Customer pedro = new Customer();
            pedro.setName("Pedro");
            pedro.setPassword("pedro123");
            Address addressPedro = new Address();
            addressPedro.setCountry("Peru");
            addressPedro.setAddress("Huarua - Lima");
            pedro.setAddress(addressPedro);

            List<Customer> customers = List.of(arturo, jose, pedro);

            customerRepository.saveAll(customers);

        };
    }

}
