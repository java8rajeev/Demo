package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="emp_tab")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id_col")
	private Integer empId;
	
	@Column(name="emp_name_col")
	@NotBlank(message="Employee name can not be Empty")
	@Size(min=3,max=9,message="Name must be between 3-9 character only")
	@Pattern(regexp = "[A-Za-z]{3,9}" ,message="Only AtoZ and atoz is allowed")
	private String empName;
	
	@Column(name="emp_gen_col")
	@NotBlank(message="Employee Gender can not be Empty")
	private String empGen;
	
	@Column(name="emp_domain_col")
	@NotBlank(message="Employee Domain must be selected")
	private String empDomain;
	
	@Column(name="emp_addr_col")
	@Pattern(regexp="[A-Za-z0-9\\.\\-\\?]{10,250}",message="invalid address details")
	private String empAddr;

}
