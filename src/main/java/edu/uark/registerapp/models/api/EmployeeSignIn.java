package edu.uark.registerapp.models.api;

public class EmployeeSignIn extends ApiResponse{
    private String employeeId;
    private String password;
    public String getEmployeeId(){
        return this.employeeId;
    }
    public String password(){
        return this.password;
    }
    
}