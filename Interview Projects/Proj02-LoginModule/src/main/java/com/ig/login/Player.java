package com.ig.login;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Player")
public class Player 
{
	@Id
	@SequenceGenerator(name = "id_gen",sequenceName = "ID_GENERATOR",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "id_gen",strategy = GenerationType.SEQUENCE )
	public Integer id;
	public String name;
	public String password;
}
