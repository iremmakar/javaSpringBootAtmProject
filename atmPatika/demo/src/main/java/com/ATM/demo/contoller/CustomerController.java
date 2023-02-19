package com.ATM.demo.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ATM.demo.business.service.CustomerService;
import com.ATM.demo.entities.CustomerEntity;
import com.ATM.demo.requests.CustomerMoney;
import com.ATM.demo.requests.TransferMoney;

@RestController
@RequestMapping("/hesap")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PutMapping("/paraEkle/{userId}")
	public Optional<CustomerEntity> addMoney(@PathVariable Long userId,@RequestBody CustomerMoney money) {		
		return customerService.addMoney(money.getMoney(), userId);	
	}
	
	@PutMapping("/paraCek/{userId}")
	public Optional<CustomerEntity> withdrawMoney(@PathVariable Long userId,@RequestBody CustomerMoney money) throws Exception {		
		return customerService.withdrawMoney(money.getMoney(), userId);	
	}
	
	
	@PutMapping("/paraHavale/{userId}")
	public Optional<CustomerEntity> transferMoney(@PathVariable Long userId,@RequestBody TransferMoney transfer) throws Exception {		
		return customerService.transfer(transfer.getMoney(),transfer.getTransferUserId(),userId);
	
	}
	
	
	
	

}
