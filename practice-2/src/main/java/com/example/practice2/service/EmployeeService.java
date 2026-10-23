package com.example.practice2.service;

import com.example.practice2.model.Employee;
import com.example.practice2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> search(String name, Boolean active) {
        boolean hasName = name != null && !name.isBlank();
        if (hasName && active != null) {
            return employeeRepository.findByFullNameContainingIgnoreCaseAndActive(name.trim(), active);
        }
        if (hasName) {
            return employeeRepository.findByFullNameContainingIgnoreCase(name.trim());
        }
        if (active != null) {
            return employeeRepository.findByActive(active);
        }
        return employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Сотрудник с id " + id + " не найден"));
    }

    public boolean emailExists(String email) {
        return employeeRepository.existsByEmail(email);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
