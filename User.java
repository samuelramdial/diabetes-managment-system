import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class User {
    private int userID;
    private String name;
    private int age;
    private double insulinRatio;
    private ArrayList<bloodSugarRecord> bloodSugarRecords;
    private ArrayList<Meal> mealRecords;
    private ArrayList<Double> insulinDosages;
    private double correctionFactor;

    public User(int userID, String name, int age, double insulinRatio, double correctionFactor) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.insulinRatio = insulinRatio;
        this.bloodSugarRecords = new ArrayList<>();
        this.mealRecords = new ArrayList<>();
        this.insulinDosages = new ArrayList<>();
        this.correctionFactor = correctionFactor;
    }

    public void addBloodSugarRecord(int userID, LocalDate date, double bloodSugarLevel) {
        bloodSugarRecords.add(new bloodSugarRecord(userID, date, bloodSugarLevel));
    }

    public void addMealRecord(int userID, LocalDateTime time, String name, double carb) {
        mealRecords.add(new Meal(userID, time, name, carb));
    }

    public void addInsulinDosage(double dosage) {
        insulinDosages.add(dosage);
    }

    public ArrayList<Double> getInsulinDosages() {
        return insulinDosages;
    }

    public ArrayList<Meal> getMealRecords() {
        return mealRecords;
    }

    public ArrayList<bloodSugarRecord> getBloodSugarRecords() {
        return bloodSugarRecords;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getInsulinRatio() {
        return insulinRatio;
    }

    public void setInsulinRatio(double insulinRatio) {
        this.insulinRatio = insulinRatio;
    }

    public double getCorrectionFactor() {
        return correctionFactor;
    }

    public void setCorrectionFactor(double correctionFactor) {
        this.correctionFactor = correctionFactor;
    }

    public String toString() {
        return userID + ". " + name;
    }

}
