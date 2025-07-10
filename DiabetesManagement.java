import java.time.LocalDateTime;
import java.util.*;

public class DiabetesManagement {
    private final ArrayList<User> users;
    private static int nextUserID = 0;
    private User addUser;

    public DiabetesManagement() {
        users = new ArrayList<User>();
    }

    public static int getNextUserID() {
        return nextUserID;
    }

    private static void incrementNextUserID() {
        nextUserID += 1;
    }

    public void addUser(String name, int age, double insulinRatio, double correctionFactor) {
        incrementNextUserID();
        addUser = new User(getNextUserID(), name, age, insulinRatio, correctionFactor);
        users.add(addUser);
    }

    public void addBloodSugarRecord(int userID, double bloodSugarLevel) {
        users.get(userID - 1).addBloodSugarRecord(userID, java.time.LocalDate.now(), bloodSugarLevel);
    }

    public void addMealRecord(int userID, String name, double carb) {
        users.get(userID - 1).addMealRecord(userID, LocalDateTime.now(), name, carb);
    }

    public String getUserBloodRecords(int userID) {
        ArrayList<bloodSugarRecord> record = users.get(userID - 1).getBloodSugarRecords();
        String text = "";
        if (record.size() > 0) {
            for (int i = 0; i < record.size(); i++) {
                text += record.get(i) + "\n";
            }
        } else {
            text += "You have not recorded any blood sugar levels";
        }
        return text;
    }

    public String getUsersString() {
        String text = "";
        if (users.size() > 0) {
            for (User aUser : users) {
                text += aUser + "\n";
            }
        } else {
            text += "You have not registered any users.";
        }
        return text;
    }

    public String getUserMealRecords(int userID) {
        ArrayList<Meal> record = users.get(userID - 1).getMealRecords();
        String text = "";
        if (record.size() > 0) {
            for (int i = 0; i < record.size(); i++) {
                text += record.get(i) + "\n";
            }
        } else {
            text += "You have not entered any meals";
        }
        return text;
    }

    public String getInsulinDosages(int userID) {
        ArrayList<Double> dosages = users.get(userID - 1).getInsulinDosages();
        String text = "";
        if (dosages.size() > 0) {
            for (int i = 0; i < dosages.size(); i++) {
                System.out.printf("%.2f units \n", dosages.get(i));
            }
        } else {
            text += "You have not entered any dosages";
        }
        return text;
    }

    public double calculateInsulinDosage(int userID) {
        double insulinRatio = users.get(userID - 1).getInsulinRatio();
        ArrayList<Meal> mealRecord = users.get(userID - 1).getMealRecords();
        double carbs = mealRecord.get(mealRecord.size() - 1).getCarbs();
        ArrayList<bloodSugarRecord> bloodSugarRecords = users.get(userID -
                1).getBloodSugarRecords();
        double bloodSugarRecord = bloodSugarRecords.get(bloodSugarRecords.size() -
                1).getBloodSugarLevel();
        double correctionFactor = users.get(userID - 1).getCorrectionFactor();
        double correctionBolus = (bloodSugarRecord - 110) / correctionFactor;
        double mealBolus = carbs / insulinRatio;
        double dosage = mealBolus + correctionBolus;
        users.get(userID - 1).addInsulinDosage(dosage);
        return dosage;
    }

    public double getTotalCarbohydrates(int userID) {
        double totalCarbohydrates = 0;
        ArrayList<Meal> mealRecord = users.get(userID - 1).getMealRecords();
        for (int i = 0; i < mealRecord.size(); i++) {
            totalCarbohydrates += mealRecord.get(i).getCarbs();
        }
        return totalCarbohydrates;
    }

    public double getAverageBloodSugar(int userID) {
        double total = 0;
        double average = 0;
        ArrayList<bloodSugarRecord> bloodSugarRecords = users.get(userID - 1).getBloodSugarRecords();
        for (int i = 0; i < bloodSugarRecords.size(); i++) {
            total += bloodSugarRecords.get(i).getBloodSugarLevel();
        }
        average = total / bloodSugarRecords.size();
        return average;
    }
}