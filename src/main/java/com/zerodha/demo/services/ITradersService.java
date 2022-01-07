package com.zerodha.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zerodha.demo.entities.Shares;
import com.zerodha.demo.entities.Trader;

@Service
public interface ITradersService
{

	public Trader addTrader(Trader trader);
	public Trader updateTrader(Trader trader,long traderId);
	public String deleteTrader(long traderId);
	public Trader getTraderById(long traderId);
	public List<Trader> getAllTraders();
	public Trader signIn(String email, String password);
	public Trader signOut(Trader trader);
	
}
