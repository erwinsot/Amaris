package amaris.example.test.controllers;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import amaris.example.test.models.EmployeeModel;
import amaris.example.test.services.EmployeeBusinessService;



@RestController
@RequestMapping("/")
public class EmployeeController {

    

    @Autowired
    private EmployeeBusinessService employeeBusinessService;   
   

 @GetMapping("/data")
    public ModelAndView sendData(@RequestParam(name = "id", required = false) String param, Model model) throws JsonMappingException, JsonProcessingException {

        ModelAndView modelAndView = new ModelAndView("prueba");

        try{
        if(param ==null){
           return modelAndView.addObject("sin dato", "sin dato");
        }
        else if (param =="") {
      
            ArrayList<EmployeeModel> employees = this.employeeBusinessService.getChangeEmployeeSAlary();
                modelAndView.addObject("dataList", employees); 
                
                return modelAndView;       
            
        } else {     
            
                EmployeeModel eModel=this.employeeBusinessService.getEmployeeWithSalary(param);            
              return modelAndView.addObject("data", eModel);      
         
        }
    }
    catch (HttpClientErrorException.TooManyRequests e) {
        // Manejar el error 429 aquí
        return modelAndView.addObject("error", "Too many requests have been exceeded. Please wait for a moment before sending the request again.");
         

    }
        
    }

  
   
    
}
