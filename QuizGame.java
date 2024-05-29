import java.util.Scanner;

public class QuizGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Array to store quiz questions
        String[] questions = {
            "What is the largest organ in the human body?",
            "Who is known as the father of modern chemistry?",
            "Who wrote 'Romeo and Juliet'?",
            "In which year did the Titanic sink?",
            "Which country is the largest producer of coffee in the world?"

                               
        };
        
        // 2D array to store options for each question
        String[][] options = {
            {"1. skin", "2. Heart", "3. Brain", "4. Liver"},
            {"1. Marie Curie", "2. Alexander Fleming", "3. Isaac Newton", "4. Albert Einstein"},
            {"1. Charles Dickens", "2. Jane Austen", "3. William Shakespeare", "4. Mark Twain"},
            {"1. 1911", "2. 1912", "3. 1913", "4. 1914"},
            {"1. Inia", "2. Japan", "3.Brazil", "4. Turkey"}
        };
        
        // Array to store the correct answer for each question
        int[] correctAnswers = {1, 2, 3, 4};
        
        // Variable to store user choice
        int userChoice = 0;
        
        // Loop through each question
        for (int i = 0; i < questions.length; i++) {
            // Print question and options
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            
            // Get user's answer
            System.out.print("Please enter the number of your answer: ");
            userChoice = scanner.nextInt();
            
            // Check if the answer is correct
            if (userChoice == correctAnswers[i]) {
                System.out.println("Correct answer!\n");
            } else {
                System.out.println("Wrong answer. The correct answer was " + correctAnswers[i] + ".\n");
            }
        }
        
        // Close the scanner
        scanner.close();
        
        System.out.println("Quiz finished. Thank you for playing!");
    }
}
