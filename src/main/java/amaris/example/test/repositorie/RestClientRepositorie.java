package amaris.example.test.repositorie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import amaris.example.test.models.EmployeeModel;

@Repository
public class RestClientRepositorie {

    @Autowired
    private RestTemplate restTemplate;


    public EmployeeModel getEmployeeApi(String id) throws JsonMappingException, JsonProcessingException{        
        String url = "https://dummy.restapiexample.com/api/v1/employee/"+ id;
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        // Obtener el JSON de la respuesta
        String json = response.getBody();

        // Convertir JSON a un mapa genérico
        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        Map<String, Object> responseMap = objectMapper.readValue(json, typeFactory.constructMapType(Map.class, String.class, Object.class));

        // Extraer el campo "data" como un mapa
        Map<String, Object> data = (Map<String, Object>) responseMap.get("data");

        // Crear un objeto EmployePrueba y asignar los valores del mapa
        EmployeeModel employePrueba = new EmployeeModel();
        employePrueba.setId(Long.valueOf(String.valueOf(data.get("id"))));
        employePrueba.setEmployee_name((String) data.get("employee_name"));
        employePrueba.setEmployee_salary(Double.valueOf(String.valueOf(data.get("employee_salary"))));
        employePrueba.setEmployee_age(Integer.valueOf(String.valueOf(data.get("employee_age"))));
        employePrueba.setProfile_image((String) data.get("profile_image"));
    

        return employePrueba;
    } 


    public ArrayList<EmployeeModel> getAllEmployeeApi() throws JsonMappingException, JsonProcessingException{

            String url = "https://dummy.restapiexample.com/api/v1/employees";
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

            // Obtener el JSON de la respuesta
            String json = response.getBody();

            // Convertir JSON a ArrayList de objetos EmployeeModel
           ObjectMapper objectMapper = new ObjectMapper();
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            Map<String, Object> responseMap = objectMapper.readValue(json, typeFactory.constructMapType(Map.class, String.class, Object.class));

            // Extract the "data" field as a list
            List<Map<String, Object>> data = (List<Map<String, Object>>) responseMap.get("data");

            // Convert each item in the "data" list to an EmployeeModel object
            ArrayList<EmployeeModel> employees = new ArrayList<>();
            for (Map<String, Object> employeeData : data) {
                EmployeeModel employee = new EmployeeModel();
                employee.setId(Long.valueOf(String.valueOf(employeeData.get("id"))));
                employee.setEmployee_name((String) employeeData.get("employee_name"));
                employee.setEmployee_salary(Double.valueOf(String.valueOf(employeeData.get("employee_salary"))));
                employee.setEmployee_age(Integer.valueOf(String.valueOf(employeeData.get("employee_age"))));
                employee.setProfile_image((String) employeeData.get("profile_image"));
                employees.add(employee);
            }

            return employees;

      
    }

    
    
}
