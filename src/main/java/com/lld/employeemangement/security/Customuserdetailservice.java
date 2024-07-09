package com.lld.employeemangement.security;

import com.lld.employeemangement.models.Employee;
import com.lld.employeemangement.repos.EmployeeRepositery;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class Customuserdetailservice  implements UserDetailsService {


    EmployeeRepositery employeeRepositery;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Employee> employee = employeeRepositery.findByName(username);
        if (employee.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        Employee emp = employee.get();
        return User.builder()
                .username(emp.getName())
                .password(emp.getPassword()) // Use encoded password from the database
                .roles("USER") // Assuming a default role, adjust as necessary
                .build();
    }
}
