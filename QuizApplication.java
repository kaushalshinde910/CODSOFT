import java.util.Scanner;

public class QuizApplication {

    // Question class for quiz
    static class Question {
        String question;
        String[] options;
        int correctAnswer;

        Question(String question, String[] options, int correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    // Timer thread to display the countdown for the entire quiz duration
    static class CountdownTimer extends Thread {
        private int totalSeconds;
        private boolean running;

        public CountdownTimer(int minutes) {
            this.totalSeconds = minutes * 60; // Convert minutes to seconds
            this.running = true;
        }

        @Override
        public void run() {
            while (totalSeconds > 0 && running) {
                int minutes = totalSeconds / 60;
                int seconds = totalSeconds % 60;
                System.out.print("\rTime Remaining: " + String.format("%02d:%02d", minutes, seconds));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                totalSeconds--;
            }
            running = false;
        }

        public void stopTimer() {
            running = false;
        }

        public boolean isRunning() {
            return running;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question[] quizQuestions = {
                new Question("What is the default value of a boolean variable in Java?",
                        new String[]{"1. true", "2. false", "3. null", "4. 0"}, 2),
                new Question("Which of the following is not a Java keyword?",
                        new String[]{"1. if", "2. switch", "3. for", "4. goto"}, 4),
                new Question("What is the size of a char in Java?",
                        new String[]{"1. 8 bits", "2. 16 bits", "3. 32 bits", "4. 64 bits"}, 2),
                new Question("Which method is used to start a thread in Java?",
                        new String[]{"1. run()", "2. start()", "3. begin()", "4. execute()"}, 2),
                new Question("Which keyword is used to prevent a class from inheritance?",
                        new String[]{"1. static", "2. final", "3. abstract", "4. private"}, 2)
        };

        int score = 0;

        // Set quiz duration in minutes
        int quizDurationInMinutes = 5;
        CountdownTimer timer = new CountdownTimer(quizDurationInMinutes);

        // Start the countdown timer for the entire quiz duration
        timer.start();

        // Loop through each question
        for (int i = 0; i < quizQuestions.length; i++) {
            // Check if time is up
            if (!timer.isRunning()) {
                System.out.println("\nTime is up!");
                break;
            }

            // Display question and options
            Question currentQuestion = quizQuestions[i];
            System.out.println("\n\nQuestion " + (i + 1) + ": " + currentQuestion.question);
            for (String option : currentQuestion.options) {
                System.out.println(option);
            }

            boolean answered = false;
            int answer = -1;

            // Allow answering while timer is still running
            while (!answered && timer.isRunning()) {
                System.out.print("\nSelect your answer (1-4): ");
                if (scanner.hasNextInt()) {
                    answer = scanner.nextInt();
                    if (answer >= 1 && answer <= 4) {
                        answered = true;
                    } else {
                        System.out.println("Invalid option. Please select a number between 1 and 4.");
                    }
                } else {
                    System.out.println("Invalid input. Please select a number between 1 and 4.");
                    scanner.next(); // Clear invalid input
                }
            }

            // Check if the answer is correct and increment score
            if (answered && answer == currentQuestion.correctAnswer) {
                score++;
            }
        }

        // Stop the timer after quiz ends
        timer.stopTimer();

        // Final result screen
        System.out.println("\n\nQuiz Over! Your final score is: " + score + "/" + quizQuestions.length);
        scanner.close();
    }
}

