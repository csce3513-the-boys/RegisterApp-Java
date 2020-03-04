package edu.uark.registerapp.commands.employees;
import edu.uark.registerapp.models.entities.ActiveUserEntity;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.uark.registerapp.models.api.EmployeeSignIn;
@Service
public class EmployeeSignInCommand {
    private EmployeeSignIn employeeSignIn;
    private String sessionKey;
    final Optional<ActiveUserEntity> activeUserEntity = 
    public boolean validate(String id){
        if(!employeeSignIn.getEmployeeId().equals("")&&Integer.parseInt(employeeSignIn.getEmployeeId())>0){
            return true;
        }
        else{
            return false;
        }
    }
    
	

}