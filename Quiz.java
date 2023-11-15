import java.util.InputMismatchException;
import java.util.Scanner;

class Question {
    private String questionText;
    private String[] options;
    private int correctOption;

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private Question[] questions;
    private int score;

    public Quiz(Question[] questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            Question question = questions[i];

            System.out.println(question.getQuestionText());

            String[] options = question.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            int userAnswer = 0;
            try {
                System.out.print("Your answer (1-" + options.length + "): ");
                userAnswer = scanner.nextInt();

                if (userAnswer < 1 || userAnswer > options.length) {
                    System.out.println("Invalid answer! Please enter a number between 1 and " + options.length);
                    i--; 
                    continue;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine(); 
                i--; 
                continue;
            } finally {
                scanner.nextLine(); 
            }

            if (question.isCorrect(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " + question.getOptions()[question.getCorrectOption() - 1] + "\n");
            }
        }

        System.out.println("Quiz complete. Your score: " + score + "/" + questions.length);
    }
}
