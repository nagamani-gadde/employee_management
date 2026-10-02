package com.nit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name="employee_data")
@AllArgsConstructor
public class Employee{
	
	
        @Id
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_seq_gen"
        )
        @SequenceGenerator(
            name = "employee_seq_gen",
            sequenceName = "EMPLOYEE_SEQ",
            allocationSize = 1
        )
	    private Long id;
	    private String name;
	    private String email;
	    private String department;
	    private double salary;
	    
	    public Employee() {
	    }

    
	
}
