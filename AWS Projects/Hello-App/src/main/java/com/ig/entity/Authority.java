package com.ig.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority 
{
	@Id
	@SequenceGenerator
	(
			name = "AUTH_ID_SEQ_GEN", 
			initialValue = 1, 
			allocationSize = 1,
			sequenceName = "AUTH_ID_SEQ_GEN"
	)
	@GeneratedValue(generator = "AUTH_ID_SEQ_GEN")
	public Integer id;
	
	@Column( name = "authority")
	public String role;
}
