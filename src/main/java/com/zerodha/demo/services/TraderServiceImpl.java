package com.zerodha.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerodha.demo.entities.Shares;
import com.zerodha.demo.entities.Trader;
import com.zerodha.demo.repositories.ISharesRepository;
import com.zerodha.demo.repositories.ITradersRepository;
@Service
public class TraderServiceImpl implements ITradersService {

	@Autowired
	private ITradersRepository iTradersRepository;

	@Override
	public Trader addTrader(Trader trader) {
		if (trader != null) {
			return this.iTradersRepository.save(trader);
		} else {
			return null;
		}
	}

	@Override
	public Trader updateTrader(Trader trader, long traderId) {
		Trader traderDb = iTradersRepository.findById(traderId).get();
		if (traderDb != null) {
			traderDb.setPhoneNumber(trader.getPhoneNumber());
			traderDb.setEmailId(trader.getEmailId());
			return this.iTradersRepository.save(traderDb);
		} else {
			return null;
		}
	}

	@Override
	public String deleteTrader(long traderId) {
		Trader traderDb = iTradersRepository.findById(traderId).get();
		if (traderDb != null) {
			this.iTradersRepository.deleteById(traderDb.getTraderId());
			return "Trader Deleted";
		} else {
			return "Trader cannot be deleted";
		}
	}

	@Override
	public Trader getTraderById(long traderId) {
		if (traderId != 0) {
			return this.iTradersRepository.findById(traderId).get();
		} else {
			return null;
		}
	}

	@Override
	public List<Trader> getAllTraders() {
		List<Trader> tradersList = iTradersRepository.findAll();
		if (!tradersList.isEmpty()) {
			return tradersList;
		} else {
			return null;
		}
	}

	@Override
	public Trader signIn(String email, String password) {
		Trader trader = iTradersRepository.findByEmailId(email);
		if (trader != null) {
			return trader;
		} else
		{
			return null;
		}

	}

	@Override
	public Trader signOut(Trader trader) {
		
		return null;
	}

}
