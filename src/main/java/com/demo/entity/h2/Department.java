package com.demo.entity.h2;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long departmentId;
	    private String departmentName;
	    private String departmentAddress;
	    private String departmentCode;
	    
}
