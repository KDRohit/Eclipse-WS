package com.ig.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="JPA_POLITICIAN")
@Data
public class Politician 
{
	// ID ENTITY IS MANDATORY.
	
	@Id
	@Column(name="PID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	
	@Column(name="PNAME",length = 30)
	private String name;
	
	@Column(name="PAREA",length = 30)
	private String area;
	
	@Column(name="PINCOME")
	private Double income;
	
	@Column(name="PARTY")
	private String party;
}
