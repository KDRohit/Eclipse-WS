package com.ig.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.aot.generate.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
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
	@SequenceGenerator(name = "account_num_gen",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "account_num_gen",strategy = GenerationType.SEQUENCE)
	public long accountNumber;
	
	@NonNull
	@Column(name = "name",length = 50)
	public String accountHolderName;
	
	@NonNull
	@Column(name = "balance")
	public double balance;
	
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "last_updated_at")
	private LocalDateTime lastUpdatedAt;
	
	@Version
	@Column(name = "updated_count")
	private Long updateCount;
}
