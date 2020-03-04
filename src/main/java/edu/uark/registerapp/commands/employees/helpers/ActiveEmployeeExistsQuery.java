package edu.uark.registerapp.commands.employees.helpers;

import org.springframework.beans.factory.annotation.Autowired;

import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.repositories.EmployeeRepository;

public class ActiveEmployeeExistsQuery {
    public boolean exists(){
        if(employeeRepository.existsByIsActive(true)){
            return true;
        }
        else{
            throw new NotFoundException("ActiveEmployee");
        }
    }
    @Autowired
    EmployeeRepository employeeRepository;
}
