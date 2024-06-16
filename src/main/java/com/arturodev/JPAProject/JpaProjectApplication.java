package com.arturodev.JPAProject;

import com.arturodev.JPAProject.persistence.entity.Customer;
import com.arturodev.JPAProject.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

            Customer customer1 = new Customer();
            customer1.setName("Arturo");
            customer1.setPassword("arturo123");

            customerRepository.save(customer1);

            customerRepository.findAll()
                    .forEach(System.out::println);

        };
    }

}
