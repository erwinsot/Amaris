package amaris.example.test.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import amaris.example.test.models.EmployeeModel;
import amaris.example.test.repositorie.RestClientRepositorie;


@Service
public class EmployeeService {


    @Autowired
    private RestClientRepositorie repositorie;

    public EmployeeModel getEmployee(String id) throws JsonMappingException, JsonProcessingException{
        return repositorie.getEmployeeApi(id);  

    }
    
    public ArrayList<EmployeeModel> getEmployees() throws JsonMappingException, JsonProcessingException{
        return repositorie.getAllEmployeeApi();
    }
    
}
