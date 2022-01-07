package com.zerodha.demo.repositories;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zerodha.demo.entities.Shares;
import com.zerodha.demo.entities.User;

@Repository
public interface ISharesRepository extends JpaRepository<Shares,Long>{

	@Query(value="select s.sharename from Shares s where s.sharename=?1")
	public Shares findByShareName(String sharename);

}
