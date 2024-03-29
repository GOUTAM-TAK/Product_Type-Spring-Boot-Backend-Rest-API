package com.app.dto;

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

import com.app.pojos.Category;

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

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProductRespDto {
	
	
	private Integer id;
	@NotBlank
	private String name;
	@NotBlank
	
	private String productCode;
	@NotBlank
	@Past
	private LocalDate dom;
	

	private Category type;
	
}
