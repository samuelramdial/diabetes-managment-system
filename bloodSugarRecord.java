import java.time.LocalDate;

public class bloodSugarRecord {
    private int userID;
    private LocalDate date;
    private double bloodSugarLevel;

    public bloodSugarRecord(int userID, LocalDate date, double bloodSugarLevel) {
        this.date = date;
        this.bloodSugarLevel = bloodSugarLevel;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getBloodSugarLevel() {
        return bloodSugarLevel;
    }

    public void setBloodSugarLevel(double bloodSugarLevel) {
        this.bloodSugarLevel = bloodSugarLevel;
    }

    public String toString() {
        return date + ", " + bloodSugarLevel;
    }
}
