package com.docker.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docker.entity.mysql.Address;


@Repository
public interface MysqlCustomerRepository extends JpaRepository<Address, Integer> {
	
}
