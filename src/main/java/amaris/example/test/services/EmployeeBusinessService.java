package amaris.example.test.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import amaris.example.test.models.EmployeeModel;



@Service
public class EmployeeBusinessService {


    @Autowired
    private EmployeeService employeeService;

     public ArrayList<EmployeeModel> getChangeEmployeeSAlary() throws JsonMappingException, JsonProcessingException{
        ArrayList <EmployeeModel> employees=employeeService.getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            double monthlySalary=employees.get(i).getEmployee_salary();
            double annualSalary = monthlySalary * 12;
            employees.get(i).setEmployee_anual_salary(annualSalary);
            
        }
        return employees;


    }

    public EmployeeModel getEmployeeWithSalary(String id) throws JsonMappingException, JsonProcessingException {
        EmployeeModel employee= employeeService.getEmployee(id);
        double monthlySalary = employee.getEmployee_salary();
        double annualSalary = monthlySalary * 12;
        employee.setEmployee_anual_salary(annualSalary);        
        return employee;
    }

    public List<EmployeeModel> getAllEmployees() {
        return null;
    }
    
}
