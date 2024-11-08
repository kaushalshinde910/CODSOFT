import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {
    private String studentId;
    private String name;
    private List<Course> registeredCourses;

    private static final String[] NAMES = {"Daya", "Raj", "Mayur", "Shubham", "Shubas", "Kaustubh"};
    private static final Random RANDOM = new Random();

    public Student() {
        this.studentId = "S" + (RANDOM.nextInt(1000) + 1);  // Random student ID
        this.name = generateRandomName();  // Generate a random name
        this.registeredCourses = new ArrayList<>();
    }

    private String generateRandomName() {
        return NAMES[RANDOM.nextInt(NAMES.length)];
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public boolean registerForCourse(Course course) {
        if (course.getAvailableSlots() > 0) {
            registeredCourses.add(course);
            course.setAvailableSlots(course.getAvailableSlots() - 1); // Decrease available slots
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.setAvailableSlots(course.getAvailableSlots() + 1); // Increase available slots
            return true;
        }
        return false;
    }
}
