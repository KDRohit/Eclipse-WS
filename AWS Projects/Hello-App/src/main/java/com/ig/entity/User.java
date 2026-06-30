package com.ig.entity;
import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@Where(clause = "enable = true")
public class User
{
	@Id
	@SequenceGenerator
	(
			name = "USER_ID_SEQ_GEN", 
			initialValue = 1, 
			allocationSize = 1,
			sequenceName = "USER_ID_SEQ_GEN"
	)
	@GeneratedValue(generator = "USER_ID_SEQ_GEN")
	public Integer  id;
	
	@Column( name = "username")
	public String name;
	
	@Column( name = "password")
	public String password;
	
	@Column( name = "enable")
	public Boolean status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "authority_id")
	public Authority authority;
}
