package com.ig.entity;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table(name = "Movie")
@Entity
@Data
@RequiredArgsConstructor
public class Movie 
{
	// data properties
	
	@Id
	@SequenceGenerator(name = "id_seq",sequenceName = "SEQ_MOV",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "id_seq",strategy = GenerationType.SEQUENCE)
	public Integer id;
	
	@Column(length = 20)@NonNull
	public String name;
	
	@Column(length = 20)@NonNull
	public String actor;
	
	@Column(length = 20)@NonNull
	public String actress;
	
	// meta data properties.
	@Version
	public Integer updatedCount;
	@CreationTimestamp
	public LocalDateTime created_At;
	@UpdateTimestamp
	public LocalDateTime updated_At;
}
