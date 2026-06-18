package Lesson_2_6.Task_1;

import java.util.List;
import java.util.Objects;

public class Student {

    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        int sum = 0;

        for (int grade : grades) {
            sum = sum + grade;
        }

        return (double) sum / grades.size();
    }

    public void moveToNextCourse() {
        course = course + 1;
    }

    @Override
    public String toString() {
        return name + ", группа " + group + ", курс " + course;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Student student = (Student) object;
        return Objects.equals(name, student.name)
                && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group);
    }
}
