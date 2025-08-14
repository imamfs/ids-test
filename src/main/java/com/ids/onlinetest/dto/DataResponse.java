package com.ids.onlinetest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builderpublic class DataResponse {

	private List<ListTrxDTO> data;
	private List<Status> status;
	
}
