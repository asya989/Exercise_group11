public class Course {
    
    private String courseCode;
    private String courseName;
    private String instructorName;
    private int creditHours;
    private int maxCapacity;
    private int enrolledStudents;
    private boolean isActive;

    public Course() {
        this.courseCode = "";
        this.courseName = "";
        this.instructorName = "";
        this.creditHours = 0;
        this.maxCapacity = 0;
        this.enrolledStudents = 0;
        this.isActive = true;
    }

    public Course(String courseCode, String courseName, int creditHours, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        setCreditHours(creditHours); 
        setMaxCapacity(maxCapacity); 
        this.enrolledStudents = 0;
        this.isActive = true;
    }

    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public String getInstructorName() { return instructorName; }
    public int getCreditHours() { return creditHours; }
    public int getMaxCapacity() { return maxCapacity; }
    public int getEnrolledStudents() { return enrolledStudents; }
    public boolean getIsActive() { return isActive; }

    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public void setCreditHours(int creditHours) {
        if (creditHours >= 1 && creditHours <= 6) {
            this.creditHours = creditHours;
        } else {
            System.out.println("Credit hours must be between 1 and 6.");
        }
    }

    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity > 0) {
            this.maxCapacity = maxCapacity;
        } else {
            System.out.println("Max capacity must be greater than 0.");
        }
    }

    public void assignInstructor(String name) {
        this.instructorName = name;
    }

    public boolean enrollStudent() {
        if (isActive && enrolledStudents < maxCapacity) {
            enrolledStudents++;
            return true;
        } else {
            System.out.println("Cannot enroll student. Course is full or inactive.");
            return false;
        }
    }

    public void dropStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
        } else {
            System.out.println("No students to drop.");
        }
    }

    public int getAvailableSeats() {
        return maxCapacity - enrolledStudents;
    }

    public boolean isFull() {
        return enrolledStudents >= maxCapacity;
    }

    public void cancelCourse() {
        if (enrolledStudents == 0) {
            isActive = false;
            System.out.println("Course cancelled.");
        } else {
            System.out.println("Cannot cancel. Students are enrolled.");
        }
    }

    public void displayCourseInfo() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructorName);
        System.out.println("Credit Hours: " + creditHours);
        System.out.println("Max Capacity: " + maxCapacity);
        System.out.println("Enrolled Students: " + enrolledStudents);
        System.out.println("Available Seats: " + getAvailableSeats());
        System.out.println("Active: " + isActive);
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        System.out.println("UNIVERSITY COURSE REGISTRATION SYSTEM");
        Course oop = new Course("PT821", "Object-Oriented Programming", 4, 3);
        oop.assignInstructor("Dr. Smith");
        oop.enrollStudent();
        oop.enrollStudent();
        oop.displayCourseInfo();

        // Second course
        Course db = new Course("DB101", "Database Systems", 3, 2);
        db.assignInstructor("Prof. Johnson");
        db.enrollStudent();
        db.dropStudent();
        db.cancelCourse();
        db.displayCourseInfo();
    }
}
