package com.zerodha.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zerodha.demo.entities.Trader;

@Repository
public interface ITradersRepository extends JpaRepository<Trader,Long> 
{
	@Query("select t from Trader t where t.emailId=?1")
	public Trader findByEmailId(String email);
	

}
