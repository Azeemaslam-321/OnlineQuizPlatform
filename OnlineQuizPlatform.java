import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineQuizPlatform {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
           
            List<Question> questions = new ArrayList<>();

            
            questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Paris", "Madrid"}, 2));
            questions.add(new Question("Which programming language is this quiz written in?", new String[]{"Java", "Python", "C++"}, 1));
            questions.add(new Question("What is the largest planet in our solar system?", new String[]{"Mars", "Jupiter", "Saturn"}, 2));
            questions.add(new Question("Who is the author of 'To Kill a Mockingbird'?", new String[]{"Harper Lee", "J.K. Rowling", "George Orwell"}, 1));
            questions.add(new Question("What is the capital of Japan?", new String[]{"Seoul", "Beijing", "Tokyo"}, 3));

            
            Quiz quiz = new Quiz(questions);

            // Start the quiz
            quiz.start();

            // Print a message based on the user's performance
            int totalQuestions = questions.size();
            int userScore = quiz.getScore();

            if (userScore == totalQuestions) {
                System.out.println("Congratulations! You answered all questions correctly. You're a quiz master!");
            } else if (userScore == 0) {
                System.out.println("Oops! You didn't answer any questions correctly. Don't worry; practice makes perfect!");
            } else {
                System.out.println("Not bad! You got " + userScore + " out of " + totalQuestions + " questions correct. Keep it up!");
            }

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
