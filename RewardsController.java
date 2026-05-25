package com.charter.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charter.service.CustomerServiceInterface;
import com.charter.entity.Customer;
import com.charter.entity.Reward;

@RestController
@RequestMapping("/rewards")
public class RewardsController {
	//RewardsController class used for writing the rewards related rest api's

	@Autowired
	public CustomerServiceInterface customerServiceInterface;
	
	@GetMapping("/calculatepoints")
	public ResponseEntity<Map<Integer, List<Reward>>> getCalculatePoints() {
		// getCalculatePoints method is rest api getmapping method used for returning the reward points
		
		Map<Integer, List<Reward>> rewards = customerServiceInterface.getAllCustomer();
		return new ResponseEntity<Map<Integer, List<Reward>>>(rewards,HttpStatus.OK);
	}
}