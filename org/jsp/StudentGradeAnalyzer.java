package org.jsp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentGradeAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();

        // Input loop
        while (true) {
            System.out.print("Enter a student's grade (or type 'done' to finish): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int grade = Integer.parseInt(input);
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid grade or 'done' to finish.");
            }
        }

        // Calculating average
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        double average = sum / grades.size();

        // Finding highest and lowest grades
        int highest = Collections.max(grades);
        int lowest = Collections.min(grades);

        // Displaying results
        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);
    }
}
