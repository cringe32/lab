package lab3;

public class Foreman extends Employee {
    private String workshopName;
    private int numberOfWorkers;

    public Foreman(String fio, String sex, String birthdate, int workExperience, int salary, String workshopName, int numberOfWorkers) {
        super(fio, sex, birthdate, workExperience, salary);
        this.workshopName = workshopName;
        this.numberOfWorkers = numberOfWorkers;
    }

    public String getWorkshopName() {
        return workshopName;
    }
    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public double calculateTheTax(double salary, int workExperience, int numberOfWorkers) {
        return super.calculateTheTax(salary + salary / 100 * numberOfWorkers, workExperience);
    }
}
