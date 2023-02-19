package com.ATM.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ATM.demo.entities.CustomerEntity;
import com.ATM.demo.repository.CustomerRepository;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testAddMoney() {
		double money =50;
		CustomerEntity customer = customerRepository.findById(2L).get();
		double total=customer.getMoney()+money;
		customer.setMoney(total);
		customerRepository.save(customer);
		assertEquals(total, customer.getMoney());	
	}
	
	@Test
	public void testWithdrawMoney() {
		double money =50;
		CustomerEntity customer = customerRepository.findById(2L).get();
		double total=customer.getMoney()-money;
		customer.setMoney(total);
		customerRepository.save(customer);
		assertEquals(total, customer.getMoney());
		
	}
	
	@Test 
	public void testTransferMoney() {
		
		double transferMoney=100;
		CustomerEntity customer1 = customerRepository.findById(2L).get();
		CustomerEntity customer2 = customerRepository.findById(3L).get();
		
		double customer1Money= customer1.getMoney()-transferMoney;
		double customer2Money =  customer2.getMoney()+transferMoney;
		customer1.setMoney(customer1Money);
		customer2.setMoney(customer2Money);
		
		customerRepository.save(customer1);
		customerRepository.save(customer2);
		
		assertEquals(customer1Money, customer1.getMoney());
		assertEquals(customer2Money,customer2.getMoney());
		
		
		
		
		
	}
	
	
	

}
