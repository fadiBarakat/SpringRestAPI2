package com.springrestapi.springrestapi.service;

import com.springrestapi.springrestapi.Repository.StudentRepository;
import com.springrestapi.springrestapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

private StudentRepository repo;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.repo = studentRepository;
    }


    public List<Student> getStudents()
    {


        return repo.findAll();
    }

    public Student getStudentById (Integer studentIds)
    {


        if(studentIds.toString().isEmpty()) {
            throw new IllegalStateException("Id Cannot Be empty");

        }
        else {

            boolean b = repo.existsById(studentIds);
            if (!b) {
                throw new IllegalStateException("Student with Id " + studentIds + " doesn't exist");
            } else {
                Student st = repo.findById(studentIds).get();
                return st;


            }
        }

    }
    public void addNewStudent(Student student) {

        //String reqName=student.getName();



        boolean nameexist = repo.existsByName(student.getName());
        boolean braexist = repo.existsByBranch(student.getBranch());
        boolean lnameexi = repo.existsByLname(student.getLname());

        if (nameexist && braexist && lnameexi)
        {
            throw new IllegalStateException("Student With  exactly the Same Info exists");
        }
        else if (nameexist){
            throw new IllegalStateException("Student With the Same Name "  +student.getName()+ " already exists");

        }


        repo.save(student);
    }

    public Student updateStudent(int id) {
        Student student = repo.findById(id).get();
        student.setName("ALi");
        repo.save(student);
        return student;

    }

    public void deleteStudent(int id) {
        boolean b = repo.existsById(id);

        if (b)
        {
            repo.deleteById(id);
        }
        else {
            throw new IllegalStateException("Student With the Id "  +id+ " is not existed");

        }


    }
}
