import java.util.Objects;

public class Student {
    private String name;
    private int year;

    public Student(String studentName, int schoolYear) {
        name = studentName;
        year = schoolYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,year);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) return false;
        Student student = (Student) obj;
        return Objects.equals(name,student.name)
                && year== student.year;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d학년]",name,year);
    }
}
