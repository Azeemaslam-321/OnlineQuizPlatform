
public class OnlineQuizPlatform {
    public static void main(String[] args) {
        try {
            // Create quiz questions
            Question[] questions = new Question[3];
            questions[0] = new Question("What is the capital of France?", new String[]{"Berlin", "Paris", "Madrid"}, 2);
            questions[1] = new Question("Which programming language is this quiz written in?", new String[]{"Java", "Python", "C++"}, 1);
            questions[2] = new Question("What is the largest planet in our solar system?", new String[]{"Mars", "Jupiter", "Saturn"}, 2);

            
            Quiz quiz = new Quiz(questions);

           
            quiz.start();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
