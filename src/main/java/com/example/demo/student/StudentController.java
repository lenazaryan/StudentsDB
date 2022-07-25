package com.example.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class StudentController {

    private final StudentService studentService; // StudentService class should be instantiated or has to be SpringBean

    @Autowired //autowired annotation means that we pass/inject StudentService into this constructor studentService
    public StudentController(StudentService studentService) {
        this.studentService = studentService; // new StudentService()
    }

    @GetMapping(path = "/students")
    public @ResponseBody List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/students/student")
    public Student getStudentByID(@RequestParam Long id){
        return studentService.getStudentByID(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){ //public void addStudent(@RequestBody Student student){ studentService.addStudent(student); }
        return studentService.addStudent(student);
    }

    @PutMapping
    public Student updateStudent(@RequestParam Long id,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) String email,
                                 @RequestParam(required = false) LocalDate dob){
        return studentService.updateStudentHeaders(id, name, email, dob);
    }
//    @PutMapping(path = "students/student/id",
//            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
//    public Student updateStudentJson(@PathVariable (value = "id") Long id, @RequestBody Student student) {
//        Student returnValue = new Student();
//        return returnValue;
//    }

    @DeleteMapping
    public void deleteStudent(@RequestParam Long id) { studentService.deleteStudentByID(id);}

}
