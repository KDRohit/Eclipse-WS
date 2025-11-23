package com.ig.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nonnull;
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
@Table(name = "Employee")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class EmpEntity 
{
	@Id
	@SequenceGenerator(name = "id_seq",sequenceName = "SEQ_EMP_ID	",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "id_seq",strategy = GenerationType.SEQUENCE)
	public Integer id;
	
	@NonNull
	@Column(length = 30)
	public String name;
	
	@Nonnull
	@Column(length = 50)
	public String company;
	
	@Nonnull
	public Double salary;
	
	@Version
	public Long updated_count;
	
	@CreationTimestamp
	public LocalDateTime created_at;
	
	@UpdateTimestamp
	public LocalDateTime updated_at;
}
