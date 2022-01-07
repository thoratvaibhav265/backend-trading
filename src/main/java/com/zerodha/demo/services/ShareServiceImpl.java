package com.zerodha.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerodha.demo.entities.Admin;
import com.zerodha.demo.entities.Shares;
import com.zerodha.demo.entities.Trader;
import com.zerodha.demo.repositories.IAdminRepository;
import com.zerodha.demo.repositories.ISharesRepository;
import com.zerodha.demo.repositories.ITradersRepository;

@Service
public class ShareServiceImpl implements IShareService {

	@Autowired
	private ISharesRepository iShareRepository;

	@Autowired
	private IAdminRepository iAdminRepository;
	
	@Autowired
	private ITradersRepository iTraderRepository;
	

	@Override
	public Shares addShare(long adminId, Shares share) {
		Admin admin = iAdminRepository.findById(adminId).get();
		if (share != null) {
			share.setAdmin(admin);
			return this.iShareRepository.save(share);
		} else {
			return null;
		}
	}

	@Override
	public Shares updateShare(long shareId, Shares share) {
		Shares shareDb = iShareRepository.findById(shareId).get();
		if (shareDb != null) {
			shareDb.setPrice(share.getPrice());
			shareDb.setQuantity(share.getQuantity());
			return this.iShareRepository.save(shareDb);
		} else {
			return null;
		}

	}

	@Override
	public String deleteShare(long shareId) {
		Shares shareDb = iShareRepository.findById(shareId).get();
		if (shareDb != null) {

			this.iShareRepository.deleteById(shareDb.getId());
			return "Share Deleted";
		} else {
			return "Share cannot be deleted";
		}

	}

	@Override
	public List<Shares> getAllShares() {
		List<Shares> sharesList = this.iShareRepository.findAll();
		if (!sharesList.isEmpty()) {
			return sharesList;
		} else {
			return null;
		}
	}

	@Override
	public Shares getShareByName(String sharename) {
		if (sharename != null) {
			return this.iShareRepository.findByShareName(sharename);
		} else {
			return null;
		}

	}

	@Override
	public Shares getShareById(long id) {
		if (id != 0) {
			return this.iShareRepository.findById(id).get();
		} else {
			return null;
		}

	}

	@Override
	public Shares buyShares(long traderId, Shares share) 
	{
		Trader trader=iTraderRepository.findById(traderId).get();
		
		share.setTrader(trader);
		share.setStatus("Purchased");
		return this.iShareRepository.save(share);

	}

	@Override
	public Shares sellShares(long traderId, Shares share) {
		Trader trader=iTraderRepository.findById(traderId).get();
		share.setTrader(trader);
		share.setStatus("Sold");
		return this.iShareRepository.save(share);
	}

}
