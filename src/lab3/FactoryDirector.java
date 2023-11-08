package lab3;

public class FactoryDirector extends Employee {
    private int termOfElection;

    public FactoryDirector(String fio, String sex, String birthdate, int workExperience, double salary, int termOfElection) {
        super(fio, sex, birthdate, workExperience, salary);
        this.termOfElection = termOfElection;
    }

    public int getTermOfElection() {
        return termOfElection;
    }

    @Override
    public double calculateTheTax(double salary, int workExperience) {
        return super.calculateTheTax(salary, workExperience);
    }
}
