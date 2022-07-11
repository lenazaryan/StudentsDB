package com.example.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
                              @RequestParam(required = false) String email){
        return studentService.updateStudent(id, name, email);
    }

    @DeleteMapping
    public void deleteStudent(@RequestParam Long id) { studentService.deleteStudentByID(id);}

}
