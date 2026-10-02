package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Employee;
import com.nit.repository.EmployeeRepository;

@Service
public class EmployeeService {
   
	@Autowired
	EmployeeRepository empRepo;
	
    public Employee saveEmployee(Employee employee) {
        return empRepo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return empRepo.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Employee not found"));
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = getEmployeeById(id);

        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setDepartment(employee.getDepartment());
        existing.setSalary(employee.getSalary());

        return empRepo.save(existing);
    }

    public void deleteEmployee(Long id) {
    	empRepo.delete(getEmployeeById(id));
    }
}
