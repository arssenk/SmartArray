package ua.edu.ucu;


public class Student implements Comparable<Student> {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    double getGPA() {
        return GPA;
    }

    int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname + ", " + "GPA=" + GPA + ", year=" + year + '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getSurname().compareTo(o.getSurname());
    }
}
