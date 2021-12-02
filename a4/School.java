import java.util.Objects;

public class School {
    private String name;
    private int limit;
    private Student[] students;
    private int studentCount;

    public School(String pnu, int i) {
        name = pnu;
        limit = i;
        students = new Student[limit];
    }

    public void addStudent(Student newStudent) {
        students[studentCount] = newStudent;
        studentCount++;
    }

    public void removeAllStudent() {
        studentCount = 0;
        students = new Student[]{};
    }

    public Student findStudent(String studentName, int schoolYear) {
        Student cmpStudent = new Student(studentName,schoolYear);
        for (Student student:students) {
            if (cmpStudent.equals(student)) return cmpStudent;
        }
        return null;
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(name,year);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof School)) return false;
        School school = (School) obj;
        return Objects.equals(name,school.name)
                && year== student.year;
    }*/

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder("School Name: " + name + " Student Count: " + studentCount + "\n");
        for (int i = 0; i < studentCount; i++) {
            msg.append("\t").append(students[i]).append("\n");
        }
        return msg.toString();
    }
}
