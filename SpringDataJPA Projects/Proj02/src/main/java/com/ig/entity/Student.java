package com.ig.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JPA_STUDENT")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Student
{
	// question-1)- referencedColumnName is the column name or property name
	// question-2)- can we take id property as studend_Id or xyz_id or it should match column name and property name where.
	// question-3)- if yes then getting error.... something like in getId() error................
	@SequenceGenerator(name = "emp_seq_gen",sequenceName = "emp_seq",initialValue = 101,allocationSize = 1)
	@GeneratedValue(generator = "emp_seq_gen",strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "student_id")
	private Integer studentId;
	
	@NonNull
	@Column(name = "NAME")
	private String name;
	
	@ElementCollection
	@CollectionTable(
			name = "JPA_STUDENT_FRIENDS",
			joinColumns = @JoinColumn
					(
							name="STUDENT_ID",
							referencedColumnName = "student_id"
					)
			)
	
	@NonNull
	@Column(name="FRIENDS")
	private List<String> friends;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "student",fetch = FetchType.EAGER)
	private List<PhoneNumber> phoneNumbers;

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", friends=" + friends + "]";
	}
	
}
