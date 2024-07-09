package com.lld.employeemangement.controllers;
import com.lld.employeemangement.Mapper.Employeemapeer;
import com.lld.employeemangement.dto.EmployeeResposeDto;
import com.lld.employeemangement.models.Employee;
import com.lld.employeemangement.services.EmployeeServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/Employees")
@CrossOrigin(origins = "http://localhost:3001")
public class EmployeeController {

    EmployeeServices employeeServices;
    Employeemapeer employeemapeer;


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResposeDto> getEmployeeById(@PathVariable("id") long id){
        return new ResponseEntity<>(employeemapeer.mappertoemployeeresponsedto (employeeServices.getEmployeeByid(id)), HttpStatus.OK);
    }
    @GetMapping("/2")
    public String test(){
        return "hello world";
    }
    @PostMapping("/")
    public ResponseEntity<EmployeeResposeDto> saveEmployee( @RequestBody Employee employee){
        return  new ResponseEntity<>(employeemapeer.mappertoemployeeresponsedto (employeeServices.saveEmployee(employee)), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<EmployeeResposeDto> updateEmployee( @RequestBody Employee employee){
        return  new ResponseEntity<>(employeemapeer.mappertoemployeeresponsedto (employeeServices.updateEmployee(employee)), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeResposeDto>> getAllemployee(){
        List<EmployeeResposeDto>employeeResposeDto= new ArrayList<>();
        List<Employee> employeeList = employeeServices.getEmployeeList();
        for (Employee employee: employeeList){
            employeeResposeDto.add(employeemapeer.mappertoemployeeresponsedto(employee));
        }
        return new ResponseEntity<>( employeeResposeDto, HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public  ResponseEntity deleteEmployee( @PathVariable long id ){
         employeeServices.removeEmployee(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }

}
