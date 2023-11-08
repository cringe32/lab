package lab3;

public class Worker extends Employee {
    private int workshopNumber;
    private int rank;

    public Worker(String fio, String sex, String birthdate, int workExperience, double salary, int workshopNumber, int rank) {
        super(fio, sex, birthdate, workExperience, salary);
        this.workshopNumber = workshopNumber;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
    public int getWorkshopNumber() {
        return workshopNumber;
    }

    public double calculateTheTax(double salary, int workExperience, int rank) {
        return super.calculateTheTax(salary + salary / 5 * rank, workExperience);
    }
}
