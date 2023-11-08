package lab3;

public class Employee {
    private String fio;
    private String sex;
    private String birthdate;
    private int workExperience;
    private double salary;

    public double getSalary() {
        return salary;
    }
    public int getWorkExperience() {
        return workExperience;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public String getSex() {
        return sex;
    }
    public String getFio() {
        return fio;
    }

    public Employee(String fio, String sex, String birthdate, int workExperience, double salary) {
        this.fio = fio;
        this.sex = sex;
        this.birthdate = birthdate;
        this.workExperience = workExperience;
        this.salary = salary;
    }

    public double calculateTheTax(double salary, int workExperience) {
        return (salary + salary / 10 * workExperience) / 10;
    }


}