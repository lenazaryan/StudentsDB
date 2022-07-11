//package com.example.demo;
//
//import com.example.demo.student.Student;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class DataBase {
//
//    private static final List<Student> students = new ArrayList<>();
//
//    public static void fillDB() {
//        students.add(new Student(
//                1L,
//                "Mary",
//                "mary@gmail.com",
//                LocalDate.of(2000, Month.APRIL, 23),
//                21));
//        students.add(new Student(
//                2L,
//                "Elena",
//                "elena@gmail.com",
//                LocalDate.of(2000, Month.APRIL, 23),
//                21));
//    }
//
//    public static List<Student> getAllStudents() {
//        return students;
//    }
//
//    public static Student getByID(Long id) {
//        for (int i = 0; i < students.size(); i++) {
//            if (Objects.equals(students.get(i).getId(), id)) {
//                return students.get(i);
//            }
//        }
//        return null;
//    }
//
//    public static Student add(Student student) {
//        students.add(student);
//        return student;
//    }
//
//    public static List<Student> delete(Long id) {
//        for (int i = 0; i < students.size(); i++) {
//            if (Objects.equals(students.get(i).getId(), id)) {
//                students.remove(i);
//                i--;
//            }
//        } return null;
//    }
//}
