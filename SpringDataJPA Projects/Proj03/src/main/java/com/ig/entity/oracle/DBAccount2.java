package com.ig.entity.oracle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class DBAccount2
{
	@Id
	@SequenceGenerator(name = "seq_id",sequenceName = "Account_Id_Seq",initialValue = 2001,allocationSize = 1)
	private Integer id;
	
	@NonNull
	@Column(name = "Account_Holder_Name",length = 25)
	private String name;
	
	@NonNull
	@Column(name = "Balance")
	private Double balance;
	
}
