import java.util.ArrayList;
import java.util.List;

class Admin {
    List<Student> students;

    public Admin() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, String nim,String faculty, String program) {
        if (nim.length() != 15) {
            System.out.println("NIM must have exactly 15 characters.");
            return;
        }
        students.add(new Student(name,faculty,nim,program));
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.name + ", Faculty: " + student.faculty + ", Program: " + student.program + ", NIM: " + student.nim);
        }
    }
}
