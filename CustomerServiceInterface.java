package com.charter.service;

import java.util.List;
import java.util.Map;

import com.charter.entity.Reward;

public interface CustomerServiceInterface {
	//CustomerServiceInterface used for mentioning the methods we needed
	
	public Map<Integer, List<Reward>> getAllCustomer();

}