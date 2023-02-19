package com.ATM.demo.business.dto;

import com.ATM.demo.entities.BankEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class CustomerDto {
	
	
	Long id;		
	String userName;
	String password;
	Double money;
	BankEntity bank;
	

}
