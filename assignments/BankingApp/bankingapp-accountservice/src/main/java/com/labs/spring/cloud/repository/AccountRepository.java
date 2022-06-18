package com.labs.spring.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labs.spring.cloud.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
