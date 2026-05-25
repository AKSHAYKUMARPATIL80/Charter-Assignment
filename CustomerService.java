package com.charter.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charter.entity.Customer;
import com.charter.entity.Reward;
import com.charter.repository.CustomerRepository;

@Service
public class CustomerService implements CustomerServiceInterface {

	//CustomerService is service layer class its containing the business logic
	
	@Autowired
	public CustomerRepository custRepo;
	
	//getAllCustomer method is used for calculating the each customer rewards and get total month wise
	@Override
	public Map<Integer, List<Reward>> getAllCustomer() throws NullPointerException {
		
		List<Customer> custList = custRepo.findAll();
		
		Map<Integer, List<Customer>> monthWiseCustomerMap = new HashMap<Integer, List<Customer>>();
		
		// this for loop used for calculating the rewards and filtering customer data month wise
		for(Customer customer:custList) {
			
			if(customer.getName()==null || customer.getDate()==null) {
				continue;
			}
			if(customer.getTransaction()==null) {
				customer.setTransaction(0);
			}
			Integer transaction = customer.getTransaction();
			Integer rewards = 0;
			if(transaction>100) {
				rewards = ((transaction-100)*2)+(50*1);
			} else if(transaction>50 && transaction<=100) {
				rewards = (transaction-50)*1;
			}
			customer.setRewards(rewards);
			
			List<Customer> customerList = new ArrayList<Customer>();
			Integer month = customer.getDate().getMonth()+1;
			// storing customer data in monthWiseCustomerMap
			if(monthWiseCustomerMap.containsKey(month)) {
				customerList.addAll(monthWiseCustomerMap.get(month));
				customerList.add(customer);
				monthWiseCustomerMap.put(month, customerList);
			} else {
				customerList.add(customer);
				monthWiseCustomerMap.put(month, customerList);
			}
		}
		
		Map<Integer, List<Reward>> rewardList = new HashMap<Integer, List<Reward>>();
		// this for loop is used for get total rewards of each customer per month
		for(Integer month:monthWiseCustomerMap.keySet()) {
			
			Map<String,Integer> totalRewardMap = new HashMap<String,Integer>();
			for(Customer customerData:monthWiseCustomerMap.get(month)) {
				
				String name = customerData.getName();
				Integer rewards = customerData.getRewards();
				if(totalRewardMap.containsKey(name)) {
					totalRewardMap.put(name, totalRewardMap.get(name) + rewards);
				} else {
					totalRewardMap.put(name, rewards);
				}
			}
			
			List<Reward> rewardDataList = new ArrayList<Reward>();
			for(String customerName:totalRewardMap.keySet()) {
				
				Reward r = new Reward();
				r.setName(customerName);
				r.setRewards(totalRewardMap.get(customerName));
				
				rewardDataList.add(r);
			}
			rewardList.put(month, rewardDataList);
		}
		
		return rewardList;
	}

}