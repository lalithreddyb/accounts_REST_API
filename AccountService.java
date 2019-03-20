package com.mtc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtc.app.entity.Account;
import com.mtc.app.repository.IAccountRepository;

@Service
public class AccountService {

	@Autowired
	private IAccountRepository accountRepository;
	
	
	public Account getAccountById(int id)
	{
		return accountRepository.findById(id).get();
	}
	
	
	public List<Account> accountsList()
	{
		return accountRepository.findAll();
	}
	
	
	public Account addAccount(Account account)
	{
		return accountRepository.save(account);
	}
	
	
	public void partialupdateAccount(Account updateInfo) 
	{
		
		accountRepository.save(updateInfo);
	}
	
	
	public void updateAccount(Account updateInfo) 
	{	
		accountRepository.save(updateInfo);
	}
	
	
	public void deleteAccount(int id)
	{
		accountRepository.deleteById(id);
	}
	
}
