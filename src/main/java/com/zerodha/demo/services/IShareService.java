package com.zerodha.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zerodha.demo.entities.Shares;
import com.zerodha.demo.entities.Trader;

@Service
@Transactional
public interface IShareService {

	
	
	public Shares addShare(long adminId,Shares share);
	public Shares updateShare(long shareId,Shares share);
	public String deleteShare(long shareId);
	public List<Shares> getAllShares();
	public Shares getShareByName(String sharename);
	public Shares getShareById(long id);
	public Shares buyShares(long shareId,Shares share);
	public Shares sellShares(long shareId,Shares share);
	
	
}
