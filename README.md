CSCI-2467 Lab 8 – Body Mass Index
Background
In Lab 8, we are going to re-write Lab 3 and add code to validate user input.
The Body Mass Index (BMI) is a calculation used to categorize whether a person’s weight is at a healthy level for a given height. The formula is as follows:
	bmi = kilograms / (meters2)
	where kilograms = person’s weight in kilograms, meters = person’s height in meters
BMI is then categorized as follows:
Classification	BMI Range
Underweight	Less than 18.5
Normal	18.5 or more, but less than 25.0
Overweight	25.0 or more, but less than 30.0
Obese	30.0 or more

To convert inches to meters:
	meters = inches / 39.37
To convert pounds (lbs) to kilograms:
	kilograms = lbs / 2.2046
Assignment
Ask the user for their weight in pounds and height in inches. Compute their BMI and BMI classification and output the results.
The program must implement and use the following methods:
convertToKilograms – convert pounds to kilograms
convertToMeters – convert inches to meters
calcBMI – take weight in kilograms and height in meters and return the BMI
bmiClassification – take the value for the BMI and return a String with the BMI classification
 
Use the following code as a starting point for your assignment:
package edu.cscc;

import java.util.Scanner;

// TODO Student name, date, purpose
public class Main {

    private static Scanner input = new Scanner(System.in);
    private static final String INPUT_ERROR = "Input is not valid, try again";


    public static void main(String[] args) {
        double lbs, inches, meters, kgs, bmi;
        String classification;

System.out.println("Calculate BMI");
lbs = inputWeight();
inches = inputHeight();


       // TODO add code here
    }

   // TODO add your methods here (make them static)
}

As always use the package name edu.cscc and include a comment with your name, the date, and the purpose of the program.
Validations
You will include code that will validate all user input. If the user inputs an invalid value, the program will respond with an error message and will ask the user to input the data again (use a do / while loop). Invalid values include:
•	Weight or height are less than or equal to zero
•	Weight or height contain non-numeric characters
When you get user input, read in the values as Strings. Convert the weight and height String values using the Double.parseDouble() method. Be sure to handle all exceptions. See:
https://docs.oracle.com/javase/10/docs/api/java/lang/Double.html#parseDouble(java.lang.String)
for details. 
You will create and use two new methods:
inputWeight() – return a double with the user’s valid weight in pounds
inputHeight() – return a double with the user’s valid height in inches
 
Example Output
Calculate BMI
Enter weight (lbs): -17
Input is not valid, try again
Enter weight (lbs): 0
Input is not valid, try again
Enter weight (lbs): abcd
Input is not valid, try again
Enter weight (lbs): 200
Enter height (inches): -12
Input is not valid, try again
Enter height (inches): 0
Input is not valid, try again
Enter height (inches): 1abc
Input is not valid, try again
Enter height (inches): 72
Your BMI is 27.124767811523153
Your BMI classification is Overweight
