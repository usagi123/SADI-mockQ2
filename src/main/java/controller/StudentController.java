package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.List;

/**
 * Created by CoT on 10/14/17.
 */

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping(path = "/students", method = RequestMethod.GET)
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(path="/students/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @RequestMapping(path = "/students", method = RequestMethod.POST)
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }
}
