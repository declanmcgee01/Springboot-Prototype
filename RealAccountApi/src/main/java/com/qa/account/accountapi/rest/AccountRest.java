package com.qa.account.accountapi.rest;

import com.qa.account.accountapi.persistence.domain.SentAccount;
import com.qa.account.accountapi.service.AccountService;

import com.qa.account.accountapi.persistence.domain.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class AccountRest {

    @Autowired
    private AccountService service;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    @Value("${url.generator}")
    private String generatorURL;
    
    @Value("${path.genAccountNum}")
    private String accountNumGeneratorPath;

    @GetMapping("${path.getAccounts}")
    public List<Account> getAccounts() {
        return service.getAccounts();
    }

    @GetMapping("${path.getAccountById}")
    public Account getAccount(@PathVariable Long id) {
        return service.getAccount(id);
    }

    @DeleteMapping("${path.deleteAccount}")
    public ResponseEntity<Object> deleteAccount(@PathVariable Long id) {
        return service.deleteAccount(id);
    }

    @PutMapping("${path.updateAccount}")
    public ResponseEntity<Object> updateAccount(@RequestBody Account account, @PathVariable Long id) {
        return service.updateAccount(account, id);
    }
    
    @PostMapping("${path.createAccount}")
    public Account createAccount(@RequestBody Account account) {
        account = setRoomNumber(account);
        account = setIsBooked(account);
        sendToQueue(account);
    	return service.addAccount(account);
    }

    private Account setRoomNumber(Account account){
        String generatedRoomNum = restTemplate.getForObject(generatorURL + accountNumGeneratorPath, String.class);

        account.setRoomNumber(generatedRoomNum);
        return account;
    }
    
    private Account setIsBooked(Account account) {
    	String isBooked = "False";
    	
    	account.setIsBooked(isBooked);
    	return account;
    }

    private void sendToQueue(Account account){
        SentAccount accountToStore =  new SentAccount(account);
        jmsTemplate.convertAndSend("AccountQueue", accountToStore);
    }

}
