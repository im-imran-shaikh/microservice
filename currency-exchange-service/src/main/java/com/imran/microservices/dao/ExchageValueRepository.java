package com.imran.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imran.microservices.dto.ExchangeValue;

@Repository
public interface ExchageValueRepository extends JpaRepository<ExchangeValue, Integer>
{
	ExchangeValue findByFromAndTo(String from, String to);
}
