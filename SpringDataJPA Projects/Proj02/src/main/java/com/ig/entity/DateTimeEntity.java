package com.ig.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "JPA_DateTime")
@Data
@RequiredArgsConstructor
public class DateTimeEntity extends MetaDataEntity
{
	//------------------------DateTime Info------------------------------------
	@Column(name = "user_id")
	@Id
	@SequenceGenerator(name = "seq_gen",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "seq_gen")
	private Long id;
	
	@NonNull
	@Column(name = "date_time_of_birth")
	private LocalDateTime dtob;
	
	@NonNull
	@Column(name = "time_of_birth")
	private LocalTime tob;
	
	@NonNull
	@Column(name = "date_of_birth")
	private LocalDate dob;
}
