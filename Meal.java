import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Meal {
    private LocalDateTime time;
    private int mealID;
    private String name;
    private double carb;

    public Meal(int mealID, LocalDateTime time, String name, double carb) {
        this.mealID = mealID;
        this.time = time;
        this.name = name;
        this.carb = carb;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getMealID() {
        return mealID;
    }

    public void setMealID(int ID) {
        this.mealID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCarbs() {
        return carb;
    }

    public void setCarbs(double carb) {
        this.carb = carb;
    }

    public String toString() {
        return time.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + ": " + name + " | Carbohydrates: "
                + carb;
    }
}
