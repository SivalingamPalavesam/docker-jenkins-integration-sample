package com.docker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docker.entity.mysql.Address;
import com.docker.entity.postgres.Account;
import com.docker.repository.mysql.MysqlCustomerRepository;
import com.docker.repository.postgres.PostgresCustomerRepository;

@Service
public class RetrieveData  {
	
	@Autowired
    private MysqlCustomerRepository mysqlCustomerRepository;
	
	@Autowired
    private PostgresCustomerRepository postgresCustomerRepository;

    public List<Address> findAllMysqlCustomers() {

        return mysqlCustomerRepository.findAll();
    }

    public List<Account> findAllPostgresCustomers() {

        return postgresCustomerRepository.findAll();
    }

    
    
    
    
    
//    @Transactional("transactionManager")
//    public void saveMysqlCustomer(Address customer) {
//
//        mysqlCustomerRepository.save(customer);
//    }
//
//    @Transactional("postgresTransactionManager")
//    public void savePostgresCustomer(Account customer) {
//
//        postgresCustomerRepository.save(customer);
//    }

}
