package com.lld.employeemangement.services;

import com.lld.employeemangement.models.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeServices {
     void removeEmployee(long id );
     Employee updateEmployee(Employee employee);
     List<Employee> getEmployeeList();
      Employee getEmployeeByid(long id);

      Employee saveEmployee(Employee employee);

}
