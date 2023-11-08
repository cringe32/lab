package lab1;

public class Milk {
    private String title;
    private double fat;
    private boolean availability;



    public boolean isAvailability() {
        return availability;
    }
    public String getTitle() {
        return title;
    }
    public double getFat() {
        return fat;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    public void setFat(double fat) {
        this.fat = fat;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public Milk(String title, double fat, boolean availability) {
        this.title = title;
        this.fat = fat;
        this.availability = availability;
    }

    public Milk(String title, double fat) {
        this.title = title;
        this.fat = fat;
        this.availability = true;
    }

    public Milk(String title) {
        this.title = title;
        this.fat = 0.0;
        this.availability = true;
    }

    public Milk() {
        this.title = "Untitled";
        this.fat = 0.0;
        this.availability = true;
    }

    public Milk(Milk obj) {
        this.title = obj.title;
        this.fat = obj.fat;
        this.availability = obj.availability;
    }

    public void printTitle() {
        System.out.println("Название молока: " + title);
    }

    public void printFat() {
        System.out.println("Жирность: " + fat + "%");
    }

    public void printAvailability() {
        if (availability)
            System.out.println("Есть в наличии");
        else
            System.out.println("Нет в наличии");
    }
}
