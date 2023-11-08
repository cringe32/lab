package lab3;

public class WorkerA1 extends WorkerA{
    private String fio;

    public WorkerA1(double salary, String fio) {
        super(salary);
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public double calculateTheTax() {
        return salary / 10;
    }

    @Override
    public void print() {
        System.out.format("%s выплачивает налог: %.2f", fio, calculateTheTax());
    }
}
