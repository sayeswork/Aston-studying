package Lesson_2_6.Task_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Фродо", "QA-101", 1, createGrades(5, 4, 4, 5)));
        students.add(new Student("Пиппин", "QA-102", 1, createGrades(2, 3, 2, 3)));
        students.add(new Student("Сэм", "QA-201", 2, createGrades(3, 4, 3, 4)));
        students.add(new Student("Мерри", "QA-202", 2, createGrades(5, 5, 4, 5)));

        System.out.println("Студенты 1 курса до проверки:");
        printStudents(students, 1);

        removeBadStudents(students);

        for (Student student : students) {
            moveStudentToNextCourse(student);
        }

        System.out.println();
        System.out.println("Студенты 2 курса после проверки:");
        printStudents(students, 2);
    }

    public static void removeBadStudents(Set<Student> students) {
        Set<Student> badStudents = new HashSet<>();

        for (Student student : students) {
            if (student.getAverageGrade() < 3) {
                badStudents.add(student);
            }
        }

        students.removeAll(badStudents);
    }

    public static void moveStudentToNextCourse(Student student) {
        if (student.getAverageGrade() >= 3) {
            student.moveToNextCourse();
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static List<Integer> createGrades(int firstGrade, int secondGrade, int thirdGrade, int fourthGrade) {
        List<Integer> grades = new ArrayList<>();
        grades.add(firstGrade);
        grades.add(secondGrade);
        grades.add(thirdGrade);
        grades.add(fourthGrade);
        return grades;
    }
}
