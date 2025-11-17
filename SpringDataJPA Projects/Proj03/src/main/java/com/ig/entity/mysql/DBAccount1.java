package com.ig.entity.mysql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "MysqlAccount")
@Data
@RequiredArgsConstructor
public class DBAccount1
{
	@Id
	@SequenceGenerator(name = "seq_id",sequenceName = "Account_Id_Seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "seq_id",strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NonNull
	@Column(name = "Account_Holder_Name",length = 25)
	private String name;
	
	@NonNull
	@Column(name = "Balance")
	private Double balance;
	
}
