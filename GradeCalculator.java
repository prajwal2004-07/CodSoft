import java.util.*;

public class GradeCalculator {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Full Name: ");
        String Student = sc.nextLine();

        System.out.print("Enter Number of Subject: "); 
        int subjectNumbers = sc.nextInt();

        
        String [] subjectName = new String[subjectNumbers];
        int [] subjectMarks = new int [subjectNumbers];

        for (int i = 0; i < subjectNumbers; i++) {
            System.out.print("Enter Subject Name with Subject Marks Out of 100: ");
            subjectName[i] = sc.next();
            subjectMarks[i] = sc.nextInt();
        }

        //Total all Marks in All Subjects
        int totalmarks = 0;
        for (int i = 0; i < subjectMarks.length; i++) {
            totalmarks = totalmarks + subjectMarks[i];
        }

        // Average Marks 
        int averageMarks = totalmarks / subjectNumbers;
        char grade;
        //Grade Calculation
        
        int limitMarks = subjectNumbers * 100;
        if (totalmarks >= (limitMarks * 0.90) && totalmarks <= (limitMarks * 100)) {
            grade = 'A';
        }else if (totalmarks >= (limitMarks * 0.80) && totalmarks  <= (limitMarks * 89)) {
            grade = 'B';
        }else if (totalmarks >= (limitMarks * 0.60) && totalmarks  <= (limitMarks * 0.79)) {
            grade = 'C';
        }else if (totalmarks >= (limitMarks * 0.50) && totalmarks  <= (limitMarks * 0.59)) {
            grade = 'D';
        }else {
            grade = 'E';
        }

        System.out.println("\n RESELT: \n");
        System.out.println("Student Name: " + Student);
        System.out.println("Total Marks: " + totalmarks);
        System.out.println("Average Marks: " + averageMarks);
        System.out.println("Grade: " + grade);
         if (totalmarks < (limitMarks*0.35)){
             System.out.println("Sorry! You have failed the exam.");
             System.exit(0);
         }
        System.out.println("Congratulations! You have passed the exam.");
    }
}