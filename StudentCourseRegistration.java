import java.util.Scanner;

public class StudentCourseRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new student instance
        Student student = new Student(); // Initializing the student object

        // Pass the student object to the CourseRegistrationSystem
        CourseRegistrationSystem system = new CourseRegistrationSystem(student);

        while (true) {
            System.out.println("\nWelcome to the Student Course Registration System");
            System.out.println("1. Display Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Show Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    system.displayCourses();
                    break;
                case 2:
                    System.out.print("Enter the course code to register: ");
                    String courseCodeToRegister = scanner.nextLine();
                    system.registerForCourse(courseCodeToRegister);
                    break;
                case 3:
                    System.out.print("Enter the course code to drop: ");
                    String courseCodeToDrop = scanner.nextLine();
                    system.dropCourse(courseCodeToDrop);
                    break;
                case 4:
                    system.showRegisteredCourses();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
