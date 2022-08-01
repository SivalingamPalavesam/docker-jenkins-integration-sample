package com.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docker.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

}
