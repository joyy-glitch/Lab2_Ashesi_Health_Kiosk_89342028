import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args) {
        // Task 0
        System.out.println("Welcome to Ashesi Health Kiosk");

        Scanner input = new Scanner(System.in);
        // Task 1
        System.out.println("Enter service code (P/L/T/C):");
        char serviceCode = input.nextLine().toUpperCase().charAt(0);
        String serviceDesk = "";
        switch (serviceCode) {
            case 'P': serviceDesk = "Pharmacy Desk"; break;
            case 'L': serviceDesk = "Lab Desk"; break;
            case 'T': serviceDesk = "Triage Desk"; break;
            case 'C': serviceDesk = "Counselling Desk"; break;
            default: System.out.println("Invalid service code"); break;
        }
        System.out.println("Go to:" + serviceDesk);

        // Task 2
        System.out.println("Choose metric (1 for BMI, 2 for Dosage, 3 for Trig):");
        int healthMetric = input.nextInt();

        double bmi = 0;
        double radians = 0;
        String bmiCategory;
        final double pharmacyDosage = 250;
        int tablets = 0;

        if (healthMetric == 1) {
            System.out.println("Enter your weight in kg:");
            double weight = input.nextDouble();
            System.out.println("Enter your height in meters:");
            double height = input.nextDouble();
            bmi = weight/(Math.pow(height,2));
            double roundedBmi = Math.round(bmi * 10) / 10.0;
            if (bmi < 18.5){
                bmiCategory = "Underweight";}
            else if((bmi >= 18.5) && (bmi <= 24.9)){
                bmiCategory = "Normal";}
            else if((bmi >= 25) && (bmi <= 29.9)){
                bmiCategory = "Overweight";}
            else {
                bmiCategory = "Obese";}
            System.out.println("BMI: " + roundedBmi + " ,Category : " + bmiCategory);

        }
        else if (healthMetric == 2) {
            System.out.println("Enter required dosage in mg:");
            double dosage = input.nextDouble();
            tablets = (int) Math.ceil(dosage/pharmacyDosage);
            System.out.println("Tablets: " + tablets);
        }
        else if (healthMetric == 3) {
            System.out.println("Enter an angle in degrees:");
            double degrees = input.nextDouble();
            radians = Math.toRadians(degrees);
            double sin = Math.round(Math.sin(radians) * 1000) / 1000.0;
            double cos = Math.round(Math.cos(radians) * 1000) / 1000.0;
            System.out.println("sin:"+ sin);
            System.out.println("cos:"+ cos);
        }
        else {
            System.out.println("Invalid metric choice.");
        }
        // Task 3
        char randomChar = (char) ('A' + Math.random()*26);
        int num1 = 3 + (int) (Math.random() * 7);
        int num2 = 3 + (int) (Math.random() * 7);
        int num3 = 3 + (int) (Math.random() * 7);
        int num4 = 3 + (int) (Math.random() * 7);

        String shortId = "" + randomChar + num1 + num2 + num3 + num4;

        boolean validLength = shortId.length() == 5;
        boolean firstIsLetter = Character.isLetter(shortId.charAt(0));
        boolean restAreDigits = Character.isDigit(shortId.charAt(1)) &&
                Character.isDigit(shortId.charAt(2)) &&
                Character.isDigit(shortId.charAt(3)) &&
                Character.isDigit(shortId.charAt(4));

        if (!validLength) {
            System.out.println("Invalid length.");
        } else if (!firstIsLetter) {
            System.out.println("Invalid: first char must be a letter.");
        } else if (!restAreDigits) {
            System.out.println("Invalid: last 4 must be digits.");
        } else {
            System.out.println("ID OK");
        }

        input.nextLine(); // to fix a nextline error that was occurring
        // Task 4
        System.out.println("Enter your first name:");
        String firstName = input.nextLine();
        char base = firstName.toUpperCase().charAt(0);
        System.out.println("Base code:" + base);
        char shiftedChar;
        shiftedChar = (char)('A' + (base - 'A' + 2) % 26);
        String lastTwoId = shortId.substring(3);
        int roundedMetric;
        if (healthMetric == 1) {
            roundedMetric = (int) Math.round(bmi);
        } else if (healthMetric == 2) {
            roundedMetric = tablets;
        } else {
            roundedMetric = (int) Math.round(Math.sin(radians) * 100);
        }
        String displayCode = shiftedChar + lastTwoId + "-" + roundedMetric;
        System.out.println("Display Code: " + displayCode);

        String summary = serviceDesk.toUpperCase() + " | ID=" + shortId;


        if (serviceCode == 'T' && healthMetric == 1) {
            summary += " | BMI=" + roundedMetric;}

        summary += " | Code=" + displayCode;
        System.out.println("Summary: " + summary);
















    }
}
