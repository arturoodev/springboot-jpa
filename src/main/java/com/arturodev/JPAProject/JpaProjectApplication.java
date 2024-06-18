package com.arturodev.JPAProject;

import com.arturodev.JPAProject.persistence.entity.Address;
import com.arturodev.JPAProject.persistence.entity.Customer;
import com.arturodev.JPAProject.persistence.repository.AddressRepository;
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

//            Customer arturo = new Customer();
//            arturo.setName("Arturo");
//            arturo.setPassword("arturo123");
//            arturo.setUsername("arturoP");
//
//            Address addressArturoOne = new Address();
//            addressArturoOne.setCountry("Peru");
//            addressArturoOne.setAddress("Huacho - Lima");
//
//
//            Address addressArturoTwo = new Address();
//            addressArturoTwo.setCountry("Peru");
//            addressArturoTwo.setAddress("Barranca - Lima");
//
//            arturo.addAddress(addressArturoOne);
//            arturo.addAddress(addressArturoTwo);
//
//            Customer luis = new Customer();
//            luis.setName("Luis");
//            luis.setPassword("luis123");
//            luis.setUsername("LuisC");
//
//            Address luisAddress = new Address();
//            luisAddress.setCountry("Peru");
//            luisAddress.setAddress("Lima - Lima");
//
//            luis.addAddress(luisAddress);

            //customerRepository.saveAll(List.of(arturo, luis));

        };
    }

    @Bean
    public CommandLineRunner testQuery(AddressRepository addressRepository, CustomerRepository customerRepository) {
        return args -> {
            System.out.println("\n Probando relaciones bidireccionales entre address y customer\n");
            addressRepository.findAll()
                    .forEach(address -> {
                        String message = "Direccion " + address.getId() + ": " + address.getAddress()
                                + " -> Cliente: " + address.getCustomer().getName();
                        System.out.println(message);
                    });

            System.out.println("\n Probando relaciones bidireccionales entre customer y address\n");
            customerRepository.findAll()
                    .forEach(customer -> {
                        String messageC = "Cliente " + customer.getName() + ": " + customer.getAddresses().size() + " direcciones";
                        System.out.println(messageC);
                    });

            customerRepository.findCustomersFrom("Peru")
                    .forEach(System.out::println);
            customerRepository.findByAddressesCountry("Peru")
                    .forEach(System.out::println);
        };
    }

}
