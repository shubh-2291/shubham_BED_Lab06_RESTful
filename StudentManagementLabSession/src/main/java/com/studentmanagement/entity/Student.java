package com.studentmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String firstName;
	private String lastName;
	private String course;
	private String country;
	private String gender;
}
