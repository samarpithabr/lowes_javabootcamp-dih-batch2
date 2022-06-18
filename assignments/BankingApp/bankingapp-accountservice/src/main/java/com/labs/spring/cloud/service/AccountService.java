package com.labs.spring.cloud.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.spring.cloud.model.Account;
import com.labs.spring.cloud.repository.AccountRepository;


@Service
public class AccountService {

//    private static Map<String, Account> AccountRepo = new HashMap<>();

    @Autowired
    AccountRepository AccountRepo;

    public Collection<Account> getAccounts() {
//        return AccountRepo.values();
        return AccountRepo.findAll();
    }

    public String createAccount(Account account) {
    
//     if(account.getId() == null || account.getId().isEmpty()) {
//          throw new RuntimeException("Account Id mandatory");
//       }
//        AccountRepo.put(Account.getId(), Account);
    	account.setType(" Account Pending");
        AccountRepo.save(account);
        
        return "Account created";
    }

    public void updateAccount(Integer id, Account account) {
//        AccountRepo.remove(id);
//        Account.setId(id);
//        AccountRepo.put(id, Account);
        account.setId(id);
   
        AccountRepo.save(account);
        
    }

    public void deleteAccount(Integer id) {
//        AccountRepo.remove(id);
    	System.out.println("Account: " + AccountRepo.findById(id).get().getId());
        AccountRepo.delete(AccountRepo.findById(id).get());
    }

    public Account getAccount(Integer id) {
//        return AccountRepo.get(id);
    	Optional<Account> Account = AccountRepo.findById(id);
        return Account.isPresent() ? Account.get() : null;
    }

    public void clear() {
//        AccountRepo.clear();
    	AccountRepo.deleteAll();    	
    }

	

}