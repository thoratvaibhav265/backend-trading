package com.zerodha.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zerodha.demo.entities.Trader;
import com.zerodha.demo.repositories.ITradersRepository;
import com.zerodha.demo.services.IShareService;
import com.zerodha.demo.services.TraderServiceImpl;

@SpringBootTest
class testTrader {

	@Mock
	private ITradersRepository itraderrepository;

	@InjectMocks
	@Autowired
	private TraderServiceImpl itraderservice;

	@BeforeEach
	void setUp() throws Exception
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
    public  void testaddTrader()
    {
		Trader trader=new Trader("admin@gmail.com","vaibhav","vaibhav","thorat");
		
		Mockito.when(itraderrepository.save(trader)).thenReturn(trader);
	    assertEquals(trader, itraderservice.addTrader(trader));	
    }
    
	
	
	
	
	
	

}