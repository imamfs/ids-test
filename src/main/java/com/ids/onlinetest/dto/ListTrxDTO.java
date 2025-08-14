package com.ids.onlinetest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListTrxDTO {

	private Long id;
	
	private String productID;
	
	private String productName;
	
	private String amount;
	
	private String customerName;
	
	private int status;
	
	private String transactionDate;
	
	private String createdBy;
	
	private String createdOn;
	
}
