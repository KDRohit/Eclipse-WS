package com.ig.entity;
import java.io.Serializable;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Movie")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class EntityMovie implements Serializable
{
	@Id
	@SequenceGenerator(initialValue = 1,allocationSize = 1,name = "movie_id_seq_gen")
	@GeneratedValue(generator = "movie_id_seq_gen",strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Nonnull
	@Column(name = "Name")
	private String name;
	
	@Nonnull
	@Column(name = "Actor")
	private String actor;
	
	@Nonnull
	@Column(name = "Actress")
	private String actress;
}
