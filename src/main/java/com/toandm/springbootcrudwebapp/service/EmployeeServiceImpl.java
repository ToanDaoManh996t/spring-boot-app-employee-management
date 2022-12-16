package com.toandm.springbootcrudwebapp.service;

import com.toandm.springbootcrudwebapp.model.Employee;
import com.toandm.springbootcrudwebapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {

        this.employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) { this.employeeRepository.save(employee); }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(("Employee with id " + id + " not found!"));
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }
}
