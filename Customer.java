package com.charter.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	//Customer class used to store entity in database and after fetching the records from database stored in this class

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	public String name;
	
	public Integer transaction;
	
	public Date date;
	
	public Integer rewards;
	
	public Customer() {
		
	}
	
	public Customer(Long id, String name, Integer transaction, Date date, Integer rewards) {
		super();
		this.id = id;
		this.name = name;
		this.transaction = transaction;
		this.date = date;
		this.rewards = rewards;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTransaction() {
		return transaction;
	}

	public void setTransaction(Integer transaction) {
		this.transaction = transaction;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getRewards() {
		return rewards;
	}

	public void setRewards(Integer rewards) {
		this.rewards = rewards;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", transaction=" + transaction + ", date=" + date
				+ ", rewards=" + rewards + "]";
	}
}
