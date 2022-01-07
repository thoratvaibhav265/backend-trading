package com.zerodha.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

import com.zerodha.demo.entities.Admin;
import com.zerodha.demo.entities.Shares;
import com.zerodha.demo.services.AdminServiceImpl;
import com.zerodha.demo.services.ShareServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class AdminController {

	@Autowired
	private ShareServiceImpl shareService;
	
	@Autowired
	private AdminServiceImpl adminService;

	@PostMapping("admin/{adminId}/share")
	public ResponseEntity<Shares> addShares(@PathVariable long adminId,@RequestBody Shares share) 
	{ if(adminId!=0 && share!=null)
	{
		return new ResponseEntity<Shares>(shareService.addShare(adminId,share), HttpStatus.CREATED);
	}
	else
	{
		return null;
	}
	}
	
	@GetMapping("admin/shares")
	public ResponseEntity<List<Shares>> getAllShares()
	{
		List<Shares> shareList=shareService.getAllShares();
		if(!shareList.isEmpty())
		{			
		return new ResponseEntity<List<Shares>>(shareList,HttpStatus.OK);
		}
		else
		{
			return null;
		}
		  		
	}

	@PatchMapping("admin/updateShare/{shareId}")
	public ResponseEntity<Shares> updateShare(@PathVariable long shareId, @RequestBody Shares share) 
	{
		if(shareId!=0)
		{
		   return new ResponseEntity<Shares>(shareService.updateShare(shareId, share), HttpStatus.OK);
		}
		else
		{ 
			return null;
		}
	}

	@DeleteMapping("admin/delete/{shareId}")
	public ResponseEntity<String> deleteShares(@PathVariable long shareId) 
	{
		if(shareId!=0)
		{ 
			return new ResponseEntity<String>(shareService.deleteShare(shareId), HttpStatus.OK);
		} 
		else
		{
			return null;
		}
	}

	@PostMapping("admin/login/{username}/{password}")
	public ResponseEntity<Admin> loginAdmin(@PathVariable String username,@PathVariable String password)
	{
	   	if(username!=null && password!=null)
	   	{
	   		return new ResponseEntity<Admin>(adminService.signIn(username, password),HttpStatus.OK);
	   	}
	   	else
	   	{ 
	   		return null;}
	   	}
		
    }
	
	

