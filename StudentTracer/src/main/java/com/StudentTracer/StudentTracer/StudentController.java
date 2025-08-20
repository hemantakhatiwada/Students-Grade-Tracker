package com.StudentTracer.StudentTracer;



import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public String addStudent(@RequestBody StudentModel student) {
        studentService.addStudent(student);
        return "Student added successfully!";
    }

    @GetMapping
    public List<StudentModel> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/summary")
    public Map<String, Object> getSummary() {
        Map<String, Object> summary = new HashMap<>();
        summary.put("average", studentService.getAverage());
        summary.put("highest", studentService.getHighest());
        summary.put("lowest", studentService.getLowest());
        return summary;
    }
}

