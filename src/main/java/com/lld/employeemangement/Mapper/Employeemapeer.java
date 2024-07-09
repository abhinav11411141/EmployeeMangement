package com.lld.employeemangement.Mapper;

import com.lld.employeemangement.dto.EmployeeResposeDto;
import com.lld.employeemangement.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class Employeemapeer {
    public  EmployeeResposeDto mappertoemployeeresponsedto(Employee employee) {
        EmployeeResposeDto employeeResposeDto = new EmployeeResposeDto();
        employeeResposeDto.setId(employee.getId());
        employeeResposeDto.setName(employee.getName());
        employeeResposeDto.setEmail(employee.getEmail());
        employeeResposeDto.setPhone(employee.getPhone());
        return employeeResposeDto;

    }
    public  EmployeeResposeDto mappertoemployeerequestdto(Employee employee) {
        EmployeeResposeDto employeeResposeDto = new EmployeeResposeDto();
        employeeResposeDto.setId(employee.getId());
        employeeResposeDto.setName(employee.getName());
        employeeResposeDto.setEmail(employee.getEmail());
        employeeResposeDto.setPhone(employee.getPhone());
        return employeeResposeDto;

    }
}
