package com.qa.account.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qa.account.persistence.domain.RoomNum;
import com.qa.account.persistence.repository.AccountRepository;
import com.qa.account.util.generators.CreateAccount;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repo;

	@Autowired
	private CreateAccount accountCreator;

	public String createRoomNumber() {
		List<String> allRoomNumbers = getAccountNumArray();
		accountCreator.getGenerator().setAccountNumList(allRoomNumbers);
		
		String generatedNum = accountCreator.createRoomNumber();
		repo.save(new RoomNum(generatedNum, "False"));
		
		return generatedNum;
	}
	private List<String> getAccountNumArray() {
		List<RoomNum> objectList = repo.findAll();
		return objectList.stream().map(RoomNum::getRoomNum).collect(Collectors.toList());
	}

}
