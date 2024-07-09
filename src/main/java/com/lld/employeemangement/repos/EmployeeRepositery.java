package com.lld.employeemangement.repos;

import com.lld.employeemangement.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepositery extends JpaRepository<Employee, Long>{


        Optional<Employee> findByName(String name);
}
