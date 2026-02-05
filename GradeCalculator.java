
/**
 * Write a description of class calculator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Grade Calculator");
        System.out.print("Enter your exam score (0-100): ");
        int score = input.nextInt();

        if (score < 0 || score > 100) {
            System.out.println("Invalid score! Please enter a value between 0 and 100.");
            return;
        }

        String grade = "";
        String remark = "";
        String status = "";

        if (score >= 90) {
            grade = "A";
            remark = "Excellent";
            status = "PASSED! Congratulations!";
        } else if (score >= 80) {
            grade = "B";
            remark = "Very Good";
            status = "PASSED! Congratulations!";
        } else if (score >= 70) {
            grade = "C";
            remark = "Good";
            status = "PASSED! Congratulations!";
        } else if (score >= 60) {
            grade = "D";
            remark = "Satisfactory";
            status = "PASSED! Congratulations!";
        } else if (score >= 50) {
            grade = "E";
            remark = "Pass";
            status = "PASSED! Congratulations!";
        } else {
            grade = "F";
            remark = "Fail";
            status = "FAILED! Please try again.";
        }

        System.out.println("Results");
        System.out.println("Score: " + score);
        System.out.println("Grade: " + grade + " (" + remark + ")");
        System.out.println("Status: " + status);

        input.close();
    }
}


