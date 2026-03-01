package com.ig.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "quiz")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizEntity 
{
	@Id
	@SequenceGenerator(name = "id_gen",sequenceName = "QUIZ_ID_GEN",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "id_gen",strategy = GenerationType.SEQUENCE)
	Integer id;
	
	@NonNull
	@Column(name = "question")
	String que;
	
	@NonNull
	@Column(name = "option 1")
	String opt1;
	
	@NonNull
	@Column(name = "option 2")
	String opt2;
	
	@NonNull
	@Column(name = "option 3")
	String opt3;
	
	@NonNull
	@Column(name = "option 4")
	String opt4;
	
	@NonNull
	@Column(name = "answer")
	Integer ans;
}
