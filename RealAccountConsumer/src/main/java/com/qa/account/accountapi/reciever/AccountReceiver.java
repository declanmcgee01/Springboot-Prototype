package com.qa.account.accountapi.reciever;

import com.qa.account.accountapi.persistence.domain.SentAccount;
import com.qa.account.accountapi.persistence.repository.MongoAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AccountReceiver {


    @Autowired
    private MongoAccountRepo repo;

    @JmsListener(destination = "AccountQueue", containerFactory = "myFactory")
    public void receiveMessage(SentAccount sentAccount) {
        repo.save(sentAccount);
    }
}
