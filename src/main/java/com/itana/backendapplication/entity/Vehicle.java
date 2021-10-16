package com.itana.backendapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Data;

/**
* Vehicle
*/
@Entity
@Table(name = "vehicles")
@Data
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 70)
	private String year;

	@Column(length = 70)
	private String category;

	@Column(length = 70)
	private String type;

	@Column
	private Long number;
}
