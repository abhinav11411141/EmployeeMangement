package com.lld.employeemangement.services;

import com.lld.employeemangement.models.Employee;
import com.lld.employeemangement.repos.EmployeeRepositery;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements  EmployeeServices {
    EmployeeRepositery employeeRepositery;
    PasswordEncoder becryptPasswordEncoder;


    @Override
    public void removeEmployee(long id) {
        employeeRepositery.deleteById(id);
    }

    @Override
    public Employee updateEmployee( Employee employee) {
         Employee employee1=employeeRepositery.getReferenceById(employee.getId());
            employee1.setName(employee.getName());
            employee1.setEmail(employee.getEmail());
            employee1.setPhone(employee.getPhone());

        return employeeRepositery.save(employee1);
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepositery.findAll();

    }

    @Override
    public Employee getEmployeeByid(long id) {
         return employeeRepositery.getReferenceById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
      employee.setPassword(becryptPasswordEncoder.encode(employee.getPassword()));

        return employeeRepositery.save(employee);
    }

}
