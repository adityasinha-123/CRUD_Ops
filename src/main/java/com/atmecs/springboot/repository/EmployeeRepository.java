package com.atmecs.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atmecs.springboot.model.Employee;

/**
 * 
 * Repository interface is created because we want crud operations to perform our new JPA entity
 * extends JpaRepository which contains @Repository and @Transactional internally
 *
 */

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
