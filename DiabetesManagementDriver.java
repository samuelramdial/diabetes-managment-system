import java.util.*;

public class DiabetesManagementDriver {
    public static void main(String[] args) {
        DiabetesManagement aDiabetesManagement = new DiabetesManagement();
        boolean exitConditions = false;
        boolean validInput;
        boolean userRegistered = false;

        while (exitConditions == false) {
            Scanner scnr = new Scanner(System.in);
            System.out.println();
            System.out.println("\t 1. Register a user");
            System.out.println("\t 2. Add a Blood Sugar Record");
            System.out.println("\t 3. Display Blood Sugar Record");
            System.out.println("\t 4. Calculate Insulin Dosage Needed");
            System.out.println("\t 5. Display Total Carbohydrates");
            System.out.println("\t 6. Display Insulin Dosages");
            System.out.println("\t 7. Exit");

            int choice = scnr.nextInt();
            validInput = false;

            while (validInput == false) {
                scnr.nextLine();
                if (choice == 1) {
                    validInput = true;
                    System.out.print("What is your name?: ");
                    String name = scnr.nextLine();
                    System.out.print("What is your age?: ");
                    int age = scnr.nextInt();
                    System.out.print("What is your insulin to carb ratio?: ");
                    double insulinRatio = scnr.nextDouble();
                    System.out.print("What is your correction factor?: ");
                    double correctionFactor = scnr.nextDouble();
                    aDiabetesManagement.addUser(name, age, insulinRatio, correctionFactor);
                    userRegistered = true;
                } else if (choice == 2) {
                    if (userRegistered == false) {
                        System.out.println("User has not registered.");
                        break;
                    } else {
                        validInput = true;
                        System.out.println(aDiabetesManagement.getUsersString());
                        System.out.println("Please enter the ID number of your record: ");
                        int id = scnr.nextInt();
                        System.out.print("Please enter your blood sugar level: ");
                        double bloodSugarLevel = scnr.nextDouble();
                        aDiabetesManagement.addBloodSugarRecord(id, bloodSugarLevel);
                    }
                } else if (choice == 3) {
                    if (userRegistered == false) {
                        System.out.println("User has not registered.");
                        break;
                    } else {
                        validInput = true;
                        System.out.println(aDiabetesManagement.getUsersString());
                        System.out.print("Please enter the ID number of your record: ");
                        int id = scnr.nextInt();
                        System.out.println("Here are all the blood sugar level records you've entered: ");
                        System.out.println(aDiabetesManagement.getUserBloodRecords(id));
                        System.out.printf("Average Blood Sugar: %.2f", aDiabetesManagement.getAverageBloodSugar(id));
                        System.out.println();
                    }
                } else if (choice == 4) {
                    if (userRegistered == false) {
                        System.out.println("User has not registered.");
                        break;
                    } else {
                        validInput = true;
                        System.out.println(aDiabetesManagement.getUsersString());
                        System.out.print("Please enter the ID number of your record: ");
                        int id = scnr.nextInt();
                        scnr.nextLine();
                        System.out.print("Please enter your blood sugar level: ");
                        double bloodSugarLevel = scnr.nextDouble();
                        scnr.nextLine();
                        aDiabetesManagement.addBloodSugarRecord(id, bloodSugarLevel);
                        System.out.print("Please enter the name of your meal: ");
                        String name = scnr.nextLine();
                        System.out.print("Please enter the amount of carbs in your meal: ");
                        double carb = scnr.nextDouble();
                        aDiabetesManagement.addMealRecord(id, name, carb);
                        System.out.printf("\n%.2f units\n", aDiabetesManagement.calculateInsulinDosage(id));
                    }
                } else if (choice == 5) {
                    if (userRegistered == false) {
                        System.out.println("User has not registered.");
                        break;
                    } else {
                        validInput = true;
                        System.out.println(aDiabetesManagement.getUsersString());
                        System.out.print("Please enter the ID number of your record: ");
                        int id = scnr.nextInt();
                        System.out.println();
                        System.out.println("Here are all the meals you've eaten: ");
                        System.out.println(aDiabetesManagement.getUserMealRecords(id));
                        System.out.println("Total Carbohydrates: " + aDiabetesManagement.getTotalCarbohydrates(id));
                    }
                } else if (choice == 6) {
                    if (userRegistered == false) {
                        System.out.println("User has not registered.");
                        break;
                    } else {
                        validInput = true;
                        System.out.println(aDiabetesManagement.getUsersString());
                        System.out.print("Please enter the ID number of your record: ");
                        int id = scnr.nextInt();
                        System.out.println();
                        System.out.println("Here are all the insulin dosages you've administered: ");
                        System.out.println(aDiabetesManagement.getInsulinDosages(id));
                    }
                } else if (choice == 7) {
                    exitConditions = true;
                    validInput = true;
                    scnr.close();
                    System.out.println("Thank you for using our system! Have a good day.");
                } else {
                    System.out.println("Sorry, but you need to enter 1, 2, 3, 4, 5, 6, or 7");
                    System.out.println("\t 1. Register a user");
                    System.out.println("\t 2. Add a Blood Sugar Record");
                    System.out.println("\t 3. Display Blood Sugar Record");
                    System.out.println("\t 4. Calculate Insulin Dosage Needed");
                    System.out.println("\t 5. Display Total Carbohydrates");
                    System.out.println("\t 6. Display Insulin Dosages");
                    System.out.println("\t 7. Exit");
                    choice = scnr.nextInt();
                }
            }
        }
    }
}
