package com.zerodha.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerodha.demo.entities.Admin;
import com.zerodha.demo.entities.Trader;
import com.zerodha.demo.repositories.IAdminRepository;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	private IAdminRepository iAdminRepository;
	
	@Autowired
	private IShareService iShareService;

	@Override
	public Admin getAdminByEmailId(String emailId) {
		if (emailId != null) {
			return this.iAdminRepository.findByEmailId(emailId);
		} else 
		{
			return null;
		}
	}

	@Override
	public Admin getAdminById(Long id) {
		if (id != null) {
			return this.iAdminRepository.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public Admin updateAdmin(Admin admin,Long id) {
		Admin adminDb = iAdminRepository.findById(id).get();
		if (adminDb != null) {
			adminDb.setEmailId(admin.getEmailId());
			return this.iAdminRepository.save(adminDb);
		} else {
			return null;
		}
	}

	@Override
	public Admin signIn(String email, String password) {
		Admin admin = iAdminRepository.findByEmailId(email);
		if (admin != null) {
			return admin;
		} else
		{
			return null;
		}
	}

	@Override
	public Admin signOut() {
		
		return null;
	}
	
	
	

}
