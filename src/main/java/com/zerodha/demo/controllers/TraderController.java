package com.zerodha.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerodha.demo.entities.Admin;
import com.zerodha.demo.entities.Shares;
import com.zerodha.demo.entities.Trader;
import com.zerodha.demo.services.ShareServiceImpl;
import com.zerodha.demo.services.TraderServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class TraderController {
	
	
	@Autowired
	private TraderServiceImpl traderService;
	
	@Autowired
	private ShareServiceImpl shareService;
	
	@PostMapping("/login/{username}/{password}")
	public ResponseEntity<Trader> loginTrader(@PathVariable String username,@PathVariable String password)
	{
		return new ResponseEntity<Trader>(traderService.signIn(username, password),HttpStatus.OK);
    }
	
	@PutMapping("/buy/{traderId}")
	public ResponseEntity<Shares> buyShare(@PathVariable long traderId,@RequestBody Shares share)
	{
		return new ResponseEntity<Shares>(shareService.buyShares(traderId, share),HttpStatus.OK);
	}
	
	@PutMapping("/sell/{traderId}")
	public ResponseEntity<Shares> sellShares(@PathVariable long traderId,@RequestBody Shares share)
	{
		return new ResponseEntity<Shares>(shareService.sellShares(traderId ,share),HttpStatus.OK);
	}
	
	
}
