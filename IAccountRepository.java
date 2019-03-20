package com.mtc.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mtc.app.entity.Account;

public interface IAccountRepository extends MongoRepository<Account, Integer>{

}
