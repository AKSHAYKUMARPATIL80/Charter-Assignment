package com.charter.entity;

import java.sql.Date;

public class Reward {
	// this class is used to store customer name and total rewards.
	
	public String name;
	
	public Integer rewards;

	public Reward() {
		
	}
	
	public Reward(String name, Integer rewards) {
		super();
		this.name = name;
		this.rewards = rewards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRewards() {
		return rewards;
	}

	public void setRewards(Integer rewards) {
		this.rewards = rewards;
	}

	@Override
	public String toString() {
		return "Reward [name=" + name + ", rewards=" + rewards + "]";
	}
	
}