package org.jsp.workbootapp.controller;

import java.util.List;
import org.jsp.workbootapp.dto.Employee;
import org.jsp.workbootapp.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000")
@RestController
public class WorkController {

    @Autowired
    private EmpRepository repository;

    @PostMapping("/emp")
    public Employee saveWork(@RequestBody Employee e) {
        return repository.save(e);
    }

    @GetMapping("/emp1")
    public List<Employee> getAllWorks() {
        return repository.findAll();
    }

    @PutMapping("/emp/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with id " + id));
        employee.setName(updatedEmployee.getName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        return repository.save(employee);
    }
    
    @DeleteMapping("/emp/{id}")
    public void deleteEmployee(@PathVariable int id) {
        repository.deleteById(id);
    }
}
