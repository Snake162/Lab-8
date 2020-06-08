package edu.cscc;

import java.util.Scanner;
import java.lang.Math;

// Michael Heironimus, 4/2/2020, the purpose of this program is to calculate the BMI given the height and weight of the user, with added verification
public class Main {

    private static Scanner input = new Scanner(System.in);
    private static final String INPUT_ERROR = "Input is not valid, try again";

    public static void main(String[] args) {
        double lbs, meters=0, kgs=0, bmi, feet, g = 0, t;
        //changed to feet instead of inches because most people know their height in feet not inches
        String classification;
        String MetricOrUS, w;
        System.out.println("Would you like to calculate your BMI(Body Mass Index) using the Metric System (kilograms and meters) or the US System (feet and pounds)?");
        //added an option to use either metric system or us system depending on whether the user likes one or the other.
        MetricOrUS = input.nextLine();
        while (!("metric".equalsIgnoreCase(MetricOrUS) || "us".equalsIgnoreCase(MetricOrUS) || "metric system".equalsIgnoreCase(MetricOrUS) || "us system".equalsIgnoreCase(MetricOrUS))) {
            // this makes sure the user can type any of these four choices regardless of upper or lower case.
            // if anything else is typed it loops
            System.out.println("Would you like to calculate your BMI (Body Mass Index) using Metric System (kilograms and meters) or the US System (feet and pounds)? (type 'Metric' or 'US'");
            MetricOrUS = input.nextLine();
        }
        if ("metric".equalsIgnoreCase(MetricOrUS) || "metric system".equalsIgnoreCase(MetricOrUS)) {
            //different outputs and equations are used for each system
            System.out.println("Please enter your weight (in kilograms): ");
            w=input.nextLine();
            kgs=trycatch(w);
            while (kgs==0) {
                System.out.println(INPUT_ERROR);
                w=input.nextLine();
                kgs=trycatch(w);
            }
            System.out.println("Please enter your height (in meters): ");
            w=input.nextLine();
            meters=trycatch(w);
            while (meters==0) {
                System.out.println(INPUT_ERROR);
                w=input.nextLine();
                meters=trycatch(w);
            }
        }
        if ("us".equalsIgnoreCase(MetricOrUS) || "us system".equalsIgnoreCase(MetricOrUS)) {
            System.out.println("Please enter your weight (in pounds): ");
            w=input.nextLine();
            lbs=trycatch(w);
            while (lbs==0) {
                System.out.println(INPUT_ERROR);
                w=input.nextLine();
                lbs=trycatch(w);
            }
            kgs = convertToKilograms(lbs);
            System.out.println("Please enter your height (in feet): ");
            w=input.nextLine();
            feet=trycatch(w);
            while (feet==0) {
                System.out.println(INPUT_ERROR);
                w=input.nextLine();
                feet=trycatch(w);
            }
            meters = convertToMeters(feet);
        }
        bmi = calcBMI(kgs,meters);
        classification = bmiClassification(bmi);
        System.out.println("Your BMI is " +bmi+ " and your BMI classification is " +classification);
    }

    public static double convertToKilograms(double lbs) {
        return (lbs/2.2046);
    }

    public static double convertToMeters (double feet) {
        return (feet * 12) / 39.37;
        //this could be simplified but would be slightly less accurate
    }

    public static double calcBMI (double kgs, double meters) {
        return (Math.round(kgs / (meters * meters) * 100.0) /100.0);
        //this makes the output of the BMI round to the hundredths place making the output look nicer to the user.
    }

    public static String bmiClassification (double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
    public static double trycatch (String w) {
        int t = 1;
        try {
            Double.parseDouble(w);
        } catch (NumberFormatException e) {
            t = 0;
        }
        if (t == 0) {
            return t;
        } else {
            if (Double.parseDouble(w) <= 0) {
                return 0;
            } else {
                return Double.parseDouble(w);
            }
        }
    }
}


