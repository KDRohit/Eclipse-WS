package com.ig.entity;

import org.springframework.aot.generate.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_Account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class BankAccount 
{
	@Id
	@Column(name = "account_number")
	@SequenceGenerator(name = "account_num_gen",initialValue = 1001,allocationSize = 100000000)
	@GeneratedValue(generator = "account_num_gen",strategy = GenerationType.SEQUENCE)
	public long accountNumber;
	
	@NonNull
	@Column(name = "name",length = 50)
	public String accountHolderName;
	
	@Column(name = "balance")
	public double balance;
	
}
