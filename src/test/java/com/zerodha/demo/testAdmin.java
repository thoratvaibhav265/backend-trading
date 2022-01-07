package com.zerodha.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zerodha.demo.entities.Admin;
import com.zerodha.demo.entities.Trader;
import com.zerodha.demo.repositories.IAdminRepository;
import com.zerodha.demo.repositories.ITradersRepository;
import com.zerodha.demo.services.AdminServiceImpl;
import com.zerodha.demo.services.TraderServiceImpl;


@SpringBootTest
class testAdmin {

	@Mock
	private IAdminRepository iadminrepository;

	@InjectMocks
	@Autowired
	private AdminServiceImpl iadminservice;

	@BeforeEach
	void setUp() throws Exception
	{
		MockitoAnnotations.openMocks(this);
	}	
	@Test
    public  void testadminByEmailId()
    {
		Admin admin=new Admin("admin@gmail.com","vaibhav","vaibhav","thorat");
		Mockito.when(iadminrepository.findByEmailId(admin.getEmailId())).thenReturn(admin);
		assertEquals(admin,iadminservice.getAdminByEmailId(admin.getEmailId()) );
		
		
		
		
    }
}   