package org.jsp.workbootapp.repository;

import org.jsp.workbootapp.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository  extends JpaRepository<Employee, Integer>{

}
