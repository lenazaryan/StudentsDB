package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //is @Component but more specific/readable it is for semantic. SpringBean class
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService (StudentRepository studentRepository){this.studentRepository = studentRepository;
    }
    public List<Student> getAllStudents(){return studentRepository.findAll();}

    public Student getStudentByID(Long studentId){return studentRepository.findById(studentId).get();
    }

    public Student addStudent(Student student){ // public void addStudent(Student student){ System.out.println(student);}
        Optional<Student> studentByEmail = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        return studentRepository.save(student);
    }

    @Transactional
    public Student updateStudentHeaders(Long id, String name, String email, LocalDate dob){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + id + " doesn't exist"));

        if(name != null && name.length() > 0 &&
                !Objects.equals(student.getName(), name))
            student.setName(name);

        if(email != null && email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()) throw new IllegalStateException(
                    "email " + email + " is taken");
            student.setEmail(email);
        }

        if(dob != null &&
                !Objects.equals(student.getDob(), dob))
            student.setDob(dob);
        return student;
    }

    //    public ResponseEntity<Student> updateStudentJson(Long id, Student studentBody) throws IllegalStateException {
//        Student student = studentRepository.findById(id)
//                .orElseThrow(() -> new IllegalStateException(
//                        "student with id " + id + " doesn't exist"));
//        student.setName(studentBody.getName());
//        student.setEmail(studentBody.getEmail());
//        student.setDob(studentBody.getDob());
//        final Student updatedStudent = studentRepository.save(student);
//        return ResponseEntity.ok(updatedStudent);
//    }
    public void deleteStudentByID (Long id){
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("record with id " + id + " doesn't exist");
        } studentRepository.deleteById(id);}

}

