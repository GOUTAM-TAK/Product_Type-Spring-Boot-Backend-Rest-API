package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//ID (unique identifier for each product, auto generated by JPA, starts from 1)
//•	Name (should not be blank)
//•	Product Code (Unique string for each product, should not be blank)
//•	Date of manufacturing (should not be blank)
//•	Category (should be an Enum, example: Fashion, Electronics)
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String name;
	@NotBlank
	@Column(unique = true,nullable = false)
	private String productCode;
	
	@Past
	private LocalDate dom;
	@Enumerated(EnumType.STRING)
	@Column(name = "product_type")
	private Category type;
	
}
