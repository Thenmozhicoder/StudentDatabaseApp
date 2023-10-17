import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String course;

    public Student(String name, int rollNumber, String course) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getCourse() {
        return course;
    }
}

class StudentDatabase {
    private ArrayList<Student> students;

    public StudentDatabase() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the database.");
        } else {
            System.out.println("Student Database:");
            for (Student student : students) {
                System.out.println("Name: " + student.getName() + ", Roll Number: " +
                                   student.getRollNumber() + ", Course: " + student.getCourse());
            }
        }
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }
}

public class StudentDatabaseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDatabase studentDatabase = new StudentDatabase();

        boolean exit = false;

        while (!exit) {
            System.out.println("Student Database Application");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search for Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter student course: ");
                    String course = scanner.nextLine();

                    Student newStudent = new Student(name, rollNumber, course);
                    studentDatabase.addStudent(newStudent);
                    break;
                case 2:
                    studentDatabase.displayStudents();
                    break;
                case 3:
                    System.out.print("Enter the roll number to search: ");
                    int searchRollNumber = scanner.nextInt();
                    Student foundStudent = studentDatabase.searchStudent(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent.getName() +
                                           ", Roll Number: " + foundStudent.getRollNumber() +
                                           ", Course: " + foundStudent.getCourse());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting Student Database Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
