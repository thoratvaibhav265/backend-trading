package com.zerodha.demo.services;


import org.springframework.stereotype.Service;

import com.zerodha.demo.entities.Admin;

@Service
public interface IAdminService {
	
	
	public Admin getAdminByEmailId(String emailId);
    public Admin getAdminById(Long id);
    public Admin updateAdmin(Admin admin,Long id);
    public Admin signIn(String email, String password );
    public Admin signOut();
    
}
