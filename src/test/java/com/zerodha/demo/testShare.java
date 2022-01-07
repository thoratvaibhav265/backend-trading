package com.zerodha.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zerodha.demo.entities.Admin;
import com.zerodha.demo.entities.Shares;
import com.zerodha.demo.entities.Trader;
import com.zerodha.demo.repositories.ISharesRepository;
import com.zerodha.demo.services.IShareService;
import com.zerodha.demo.services.ShareServiceImpl;

@SpringBootTest
class testShare {

	@Mock
	private ISharesRepository isharerepository;
	
	@InjectMocks
	@Autowired
	private ShareServiceImpl ishareService;
	
	
	@BeforeEach
	void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
	}
	
		@Test
	    public void testaddShare() {
			
			Trader trader=new Trader("admin@gmail.com","vaibhav","vaibhav","thorat");
			Admin admin=new Admin("admin@gmail.com","vaibhav","vaibhav","thorat");
			
	        Shares share  = new Shares(1,"ITC", 200, 20, "purchased",trader,admin);
	        
	        Mockito.when(isharerepository.save(share)).thenReturn(share);
	        assertEquals(share, ishareService.addShare(1, share));
	    }
		
	}
	
	


