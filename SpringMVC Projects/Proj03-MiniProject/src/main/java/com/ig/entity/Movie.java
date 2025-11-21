package com.ig.entity;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.SQLSelect;
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
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table(name = "Movie")
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@SQLDelete(sql = "update Movie set active = 0 where id = ? and updated_count= ?")
@SQLRestriction("active<>0")
//@SQLSelect(sql = "select * from Movie where active = 1")
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
	
	public Boolean active=true;
	
	// meta data properties.
	@Version
	public Long updatedCount;
	@CreationTimestamp
	public LocalDateTime created_At;
	@UpdateTimestamp
	public LocalDateTime updated_At;
}
