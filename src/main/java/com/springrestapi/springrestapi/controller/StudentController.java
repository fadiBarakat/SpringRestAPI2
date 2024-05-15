package com.springrestapi.springrestapi.controller;

import com.springrestapi.springrestapi.model.Student;
import com.springrestapi.springrestapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

  //  private ٍStudentService stServ;

    private final StudentService stService ;

    @Autowired
    public StudentController(StudentService studentService) {
        this.stService = studentService;
    }


    //Get All the students

   @GetMapping("/students")
   //localhost:8080/students
   public List<Student>getAllStudents()
    {
        List<Student> listOfAllStudents = stService.getStudents();
        return listOfAllStudents;
    }



    //Get a student by Id

    @GetMapping("/students/{id}")
    //localhost:8080/students/id
    public  Student getStudentById(@PathVariable int id)
    {
        return  stService.getStudentById(id);

    }


    //localhost:8080/students/add
    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewStudent(@RequestBody Student student){
        stService.addNewStudent(student);

    }
    //localhost:8080/students/update/id

    @PutMapping("/students/update/{id}")
    public Student updateStudent(@PathVariable int id)
    {

        Student student =  stService.updateStudent(id);
        return student;
    }
    //localhost:8080/students/delete/id
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @DeleteMapping("/student/delete/{id}")
    public void delete(@PathVariable int id)
    {
        stService.deleteStudent(id);

    }


}
