package com.docker.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docker.entity.mysql.Address;
import com.docker.entity.postgres.Account;
import com.docker.repository.mysql.MysqlCustomerRepository;
import com.docker.repository.postgres.PostgresCustomerRepository;
import com.docker.service.RetrieveData;

@RestController
@RequestMapping("/api")
public class AppController {
	
	@Autowired
    private RetrieveData retrieveData;
	
	@Autowired
	MysqlCustomerRepository customerRepository;
	
	@Autowired
	PostgresCustomerRepository postgresCustomerRepository;

    @PostConstruct
    public void createMysqlCustomer() {

    	customerRepository.saveAll(Stream.of(new   Address(1 ," Siva Street ", "india"),
    										new Address(2,"Sri Street","USA"))
    				.collect(Collectors.toList()));
    }
    
    
    @GetMapping("/mysql")
    public List<Address> getAllMysqlCustomers() {

        return retrieveData.findAllMysqlCustomers();
    }

    @PostConstruct
    public void createPostgresCustomer() {

    	postgresCustomerRepository.saveAll(Stream.of(
    			new Account(100,2000.21 , "Raja","16/2/2222"),
    			new Account(101, 1000.10, "Vel","13/4/2123"),
    			new Account(102, 34330.10, "kavi","23/4/2323"))
    			.collect(Collectors.toList()));
    }
    
    @GetMapping("/postgres")
    public List<Account> getAllPostgresCustomers() {

        return retrieveData.findAllPostgresCustomers();
    }

   
}

