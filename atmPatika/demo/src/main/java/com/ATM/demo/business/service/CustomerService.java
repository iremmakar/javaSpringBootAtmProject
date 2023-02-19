package com.ATM.demo.business.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ATM.demo.entities.CustomerEntity;
import com.ATM.demo.repository.CustomerRepository;
import com.ATM.demo.requests.CustomerMoney;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	private ModelMapper modelMapper;
	
	
	
	public Optional<CustomerEntity> addMoney(Double money,Long id) {
		
		Optional<CustomerEntity> customer = customerRepository.findById(id);
		Double total = customer.get().getMoney()+money;
		CustomerEntity customer2 = customer.get();
		customer2.setMoney(total);	
		customerRepository.save(customer2);
		log.info("Customer added money");
		
		return customer;		
	}
	
	
	public Optional<CustomerEntity> withdrawMoney(Double money,Long id) throws Exception {
		Optional<CustomerEntity> customer = customerRepository.findById(id);
		if(money>customer.get().getMoney()) {
			log.error("You don't have enough money");
			throw new Exception("You don't have enough money");
		}else {
			Double total = customer.get().getMoney()-money;
			CustomerEntity customer2 = customer.get();
			customer2.setMoney(total);	
			customerRepository.save(customer2);
			log.info("Customer withdraws money");
			return customer;
		}
		
	}
	
	public Optional<CustomerEntity> transfer(Double money,Long transferUserId,Long userId) throws Exception {
		
		Optional<CustomerEntity> customer1= customerRepository.findById(userId);
		Optional<CustomerEntity> customer2=customerRepository.findById(transferUserId);
		
		if(money<=customer1.get().getMoney()) {
			Double total1 = (customer1.get().getMoney()-money);
			System.out.println(total1);
			Double total2= (customer2.get().getMoney()+money);
			CustomerEntity customerNew1 = customer1.get();
			CustomerEntity customerNew2 = customer2.get();
			customerNew1.setMoney(total1);
			customerNew2.setMoney(total2);
			customerRepository.save(customerNew1);
			customerRepository.save(customerNew2);
			
			
			log.info("Customer transferred money");
		}else {
			log.error("You don't have enough money");
			throw new Exception("You don't have enough money");
		}
		return customer1;
	}
	
	
	
	
	
	
	
	
	

}