package edu.pnu.admin;

import edu.pnu.collection.GenericList;

import java.util.Objects;

public class School {
    private String name;
    private GenericList<Student> students = new GenericList<Student>();


    public School(final String name, int size) {this.name = name;}

    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }

    public void removeAllStudent() {
        students.clear();
    }

    public Student findStudent(String studentName, int schoolYear) {
        Student cmpStudent = new Student(studentName,schoolYear);
        for (int i=0;i<students.size();++i) {
            if (cmpStudent.equals(students.get(i))) return cmpStudent;
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
        String msg = "School Name: "+name+" Student Count: "+students.size()+"\n";
        for (int i = 0; i < students.size(); i++) {
            msg += "\t"+students.get(i)+"\n";
        }
        return msg;
    }
}
