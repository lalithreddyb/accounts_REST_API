package com.mtc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mtc.app.entity.Account;
import com.mtc.app.service.AccountService;


//@RequestMapping(value="/Acounts")
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	
	@GetMapping(value="/Accounts/{Accid}", produces="application/json")
	public ResponseEntity<Account> getAccountById(@PathVariable("Accid") int id)
	{
	
		try {
		Account retrievedAccount = accountService.getAccountById(id);
		if(retrievedAccount.getFirst_name() != null)
		{
			return new ResponseEntity<Account>(retrievedAccount, HttpStatus.OK);
		}
			}catch (Exception e) {
				
			}
		return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);				
	}
	
	
	@GetMapping(value="/Accounts", produces="application/json")
	public List<Account> accountsList()
	{
		return accountService.accountsList();
	}
	
	
	@PostMapping(value="/Accounts", consumes="application/json")
	public ResponseEntity<String> addAccount(@RequestBody Account account)
	{
		Account accountCreated = accountService.addAccount(account);
		System.out.println("Resource was created successfully");
		HttpHeaders header = new HttpHeaders();
		 if (accountCreated != null)
		 {
			 header.add("Location", ServletUriComponentsBuilder.fromCurrentRequest()
					 .path("/{account_id}")
					 .buildAndExpand(accountCreated.getAccount_id())
					 .toUri().toString());			
		 }

		 
		 return new ResponseEntity<String>(header,HttpStatus.CREATED); 
	}
	
	
	@PatchMapping(value="/Accounts/{accId}", consumes="application/json")
	public void partialUpdateAccount(@RequestBody Account updateInfo,@PathVariable("accId") int id) 
	{
		Account account = accountService.getAccountById(id);
		
		if(updateInfo.getFirst_name() != null)
			{
				account.setFirst_name(updateInfo.getFirst_name());
			}
		else if (updateInfo.getLast_name() != null)
			{
				account.setLast_name(updateInfo.getLast_name());
			}
		else if(updateInfo.getEmail() != null)
			{
				account.setEmail(updateInfo.getEmail());
			}
		else  if(updateInfo.getUser_name()!= null)
			{
				account.setUser_name(updateInfo.getUser_name());
			}
		else  if(updateInfo.getPasswrd()!= null)
			{
				account.setPasswrd(updateInfo.getPasswrd());
			}
		
		accountService.partialupdateAccount(account);
	}

	
	@PutMapping(value="/Accounts/{accId}", consumes="application/json")
	public void updateAccount(@RequestBody Account updateInfo, @PathVariable("accId") int id ) 
	{	
		Account account = accountService.getAccountById(id);
		
		account.setAccount_id(account.getAccount_id());
		account.setFirst_name(updateInfo.getFirst_name());
		account.setLast_name(updateInfo.getLast_name());
		account.setEmail(updateInfo.getEmail());
		account.setUser_name(updateInfo.getUser_name());
		account.setPasswrd(updateInfo.getPasswrd());
		account.setRole(updateInfo.getRole());
		
		accountService.updateAccount(updateInfo);;
	}
	
	
	@DeleteMapping(value="/Accounts/{accId}")
	public ResponseEntity<Void> deleteAccount(@PathVariable("accId") int id)
	{
		try {
		accountService.deleteAccount(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}catch (Exception e) {
		// TODO: handle exception
	}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}