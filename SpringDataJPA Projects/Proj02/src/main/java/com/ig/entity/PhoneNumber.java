package com.ig.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JPA_PHONE_NUMBER")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class PhoneNumber 
{
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "phone_seq",initialValue = 901,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Column(name = "phone_id")
	private Integer phoneId;
	
	@NonNull
	@Column(length = 13)
	private String phoneNo;
	
	@NonNull
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "STUDENT_ID",referencedColumnName = "student_id")
	private Student student;

	@Override
	public String toString() {
		return "PhoneNumber [phoneId=" + phoneId + ", phoneNo=" + phoneNo + "]";
	}
}
