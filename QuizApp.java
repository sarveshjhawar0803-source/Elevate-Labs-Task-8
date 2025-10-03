import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctAnswer; // index (0-based)

    Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    void display() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    boolean checkAnswer(int userChoice) {
        return (userChoice - 1) == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Quiz Questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Which language is platform independent?", 
                                   new String[]{"C", "C++", "Java", "Python"}, 2));
        questions.add(new Question("Who developed Java?", 
                                   new String[]{"Microsoft", "Sun Microsystems", "Apple", "Google"}, 1));
        questions.add(new Question("Which keyword is used to inherit a class in Java?", 
                                   new String[]{"implement", "extends", "inherits", "super"}, 1));
        questions.add(new Question("Which of these is not OOP concept?", 
                                   new String[]{"Encapsulation", "Polymorphism", "Compilation", "Inheritance"}, 2));

        int score = 0;

        System.out.println("===== Welcome to the Online Quiz App =====\n");

        // Loop through questions
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ":");
            q.display();
            System.out.print("Your Answer: ");
            int choice = sc.nextInt();

            if (q.checkAnswer(choice)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + (q.correctAnswer + 1) + ". " + q.options[q.correctAnswer] + "\n");
            }
        }

        System.out.println("===== Quiz Over =====");
        System.out.println("Your Score: " + score + " out of " + questions.size());

        if (score == questions.size()) {
            System.out.println("🎉 Excellent! Perfect Score!");
        } else if (score >= questions.size() / 2) {
            System.out.println("👍 Good Job! You passed.");
        } else {
            System.out.println("😢 Better luck next time.");
        }

        sc.close();
    }
}
