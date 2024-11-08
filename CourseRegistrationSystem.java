import java.util.*;

public class CourseRegistrationSystem {
    private List<Course> courses;
    private Student student;

    public CourseRegistrationSystem(Student student) {
        this.courses = new ArrayList<>();
        this.student = student;
        // Adding some sample courses
        courses.add(new Course("CS101", "Introduction to Computer Science", "Basic computer science course", 30));
        courses.add(new Course("CS102", "Data Structures", "Learn about different data structures", 25));
        courses.add(new Course("CS103", "Algorithms", "An advanced course on algorithms", 20));
    }

    public void displayCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void registerForCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                if (student.registerForCourse(course)) {
                    System.out.println("Successfully registered for " + course.getTitle());
                    System.out.println("Student: " + student.getName() + " (ID: " + student.getStudentId() + ")");
                    return;
                } else {
                    System.out.println("Course is full.");
                    return;
                }
            }
        }
        System.out.println("Course not found.");
    }

    public void dropCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                if (student.dropCourse(course)) {
                    System.out.println("Successfully dropped " + course.getTitle());
                    return;
                } else {
                    System.out.println("You are not registered for this course.");
                    return;
                }
            }
        }
        System.out.println("Course not found.");
    }

    public void showRegisteredCourses() {
        if (student.getRegisteredCourses().isEmpty()) {
            System.out.println("You are not registered for any courses.");
        } else {
            System.out.println("Your Registered Courses:");
            for (Course course : student.getRegisteredCourses()) {
                System.out.println(course);
            }
            System.out.println("Student: " + student.getName() + " (ID: " + student.getStudentId() + ")");
        }
    }
}
