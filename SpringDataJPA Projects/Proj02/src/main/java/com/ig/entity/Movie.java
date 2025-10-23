package com.ig.entity;
import java.time.LocalDate;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "JPA_Movies")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Movie 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "name")
	@Nonnull
	private String movieName;
	
	@Column(name = "actor")
	@Nonnull
	private String movieActor;
	
	@Column(name = "actress")
	@Nonnull
	private String movieActress;
	
	@Column(name = "release-date")
	@Nonnull
	private LocalDate movieReleaseDate;
}
