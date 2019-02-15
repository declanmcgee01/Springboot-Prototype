package com.qa.account.accountapi.persistence.repository;

import com.qa.account.accountapi.persistence.domain.SentAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoAccountRepo extends MongoRepository<SentAccount, Long>{
}
