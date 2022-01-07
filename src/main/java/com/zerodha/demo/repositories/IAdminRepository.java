package com.zerodha.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zerodha.demo.entities.Admin;
import com.zerodha.demo.entities.Trader;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long>
{
	@Query("select a from Admin a where a.emailId=?1")
	public Admin findByEmailId(String email);
}
