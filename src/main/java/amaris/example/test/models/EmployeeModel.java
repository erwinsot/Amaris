package amaris.example.test.models;



public class EmployeeModel {

    private Long id;
    private String employee_name;
    private double employee_salary;
    private double employee_anual_salary;
    private int employee_age;
    private String profile_image;


    public EmployeeModel() {
    }

    public EmployeeModel(Long id, String employee_name, double employee_salary, double employee_anual_salary, int employee_age, String profile_image) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_anual_salary = employee_anual_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return this.employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public double getEmployee_salary() {
        return this.employee_salary;
    }

    public void setEmployee_salary(double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public double getEmployee_anual_salary() {
        return this.employee_anual_salary;
    }

    public void setEmployee_anual_salary(double employee_anual_salary) {
        this.employee_anual_salary = employee_anual_salary;
    }

    public int getEmployee_age() {
        return this.employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return this.profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

}
