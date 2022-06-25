package com.labs.spring.cloud.fundservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labs.spring.cloud.fundservice.model.FundTransfer;

@Repository
public interface fundRepository extends JpaRepository<FundTransfer, Integer> {


}
