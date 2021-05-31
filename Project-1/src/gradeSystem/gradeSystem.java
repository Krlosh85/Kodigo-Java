package gradeSystem;

/*
* Console/terminal grade evaluation system for a section of 20 students.
*We need to manage your grades as a group, we need to input your name and your evaluation result (one number from 0 to 10). Use text files as a database. Statistical module of grades obtained will be required. Is not necessary to use OOP, but we need a good structure of the application.
* We will need to see your top-down design as well.
*Present statistics on screen and at the end of the file.
*Statistics: min, max, avg (promedio), most repeated, less repeated.
* */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class gradeSystem {
    public static void main(String[] args) throws IOException {
        grades();
    }

    //Method used to type the grades and use each method
    private static void grades(){
        try{
            //Insert the n students name and Grade
            HashMap<String, Double> grades = new HashMap<String, Double>();
            Scanner scan = new Scanner(System.in);

            System.out.println("Welcome to the Kodigo's Grade System ");
            System.out.println("Instructions: insert the Name, then type the grade (Note: It can't be a grade above 10 and beneath 1).");
            int students = 5;

            double avg = 0;

            for (int i = 1; i <= students; i++){
                String name;
                double grade;
                System.out.println("Student name:");
                name = scan.nextLine();

                if (name.isEmpty()){
                    System.out.println("You must type the name of one Student at last, insert one again");
                    System.out.println("Student name:");
                    name = scan.nextLine();
                }

                System.out.println(name+" grade:");
                grade = Double.parseDouble(scan.nextLine());
                if (grade > 10 || grade < 1){
                    System.out.println("You must type a valid number, insert it again");
                    System.out.println(name+" grade:");
                    grade = Double.parseDouble(scan.nextLine());
                }

                grades.put(name, grade);

                avg += grade;
            }

            //Statistics and File module
            //Task: ask what would be a better option: making all the Statistics module with different methods or using it the way it is now
            System.out.println("Statisticsat Kodigo:");
            System.out.println("--------------------------------------------------------------------------");

            //Create a file
            File file1 = new File("Kodigo-Grades.txt");

            //Create a file Writer class
            FileWriter fw = new FileWriter(file1);
            PrintWriter pw = new PrintWriter(fw);

            pw.println("Statistics at Kodigo:");
            pw.println("--------------------------------------------------------------------------");
            pw.println((maxValue(grades)));
            pw.println((minValue(grades)));
            pw.println(avgGrade(avg, students));
            pw.println((mode(grades)));
            pw.close();

        }catch (Exception ex){
            System.out.println("Warning, Fatal Error");
        }
    }

    //Statistics module Methods

    //Method to calculate the average grade
    private static String avgGrade(double avg, int students){
        double avgGrade = (avg/students);
        System.out.println("The average grade in Kodigo is: "+String.valueOf(avgGrade));
        return ("The average grade in Kodigo is: "+String.valueOf(avgGrade));
    }

    //Method to calculate the highest value
    private static String maxValue(HashMap<String, Double> grades){
        double max = 0.0;
        for (double i : grades.values()){
            if (i > max){
                max = i;
            }
        }
        System.out.println("The maximum grade is: "+max);
        return ("The maximum grade is: "+max);
    }

    //Method to calculate the lowest value
    private static String minValue(HashMap<String, Double> grades){
        //Min, using the hashmap as an array
        Double[] values = grades.values().toArray(new Double[0]);
        double min = values[0];
        for (int i = 0; i < grades.size(); i++){
            double tempMin = values[i];
            if (tempMin < min){
                min = tempMin;
            }
        }
        System.out.println("The Minimum grade is: "+min);
        return ("The Minimum grade is: "+min);
    }

    //Method to calculate the mode of the grades
    private static String mode(HashMap<String, Double> grades){
        //Mode
        double mostRepeated = 0.0;
        int maxCount = 0;
        Double[] values = grades.values().toArray(new Double[0]);

        for (int i = 0; i < grades.size(); i++){
            double tempMostRepeated = values[i];
            int tempCount = 0;
            for (int j = 0; j < grades.size(); j++){
                if (values[j] == tempMostRepeated){
                    tempCount++;
                }
            }
            if (tempCount > maxCount){
                mostRepeated = tempMostRepeated;
                maxCount = tempCount;
            }
        }
        System.out.println("The most frequent grade is: "+mostRepeated+", and it's repeated: "+maxCount);
        return ("The most frequent grade is: "+mostRepeated+", and it's repeated: "+maxCount);
    }
}
