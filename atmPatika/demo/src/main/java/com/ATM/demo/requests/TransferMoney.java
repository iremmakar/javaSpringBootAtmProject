package com.ATM.demo.requests;

import lombok.Data;

@Data
public class TransferMoney {
	
	Long transferUserId;
	Double money;

}
