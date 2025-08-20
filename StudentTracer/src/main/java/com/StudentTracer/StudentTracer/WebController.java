package com.StudentTracer.StudentTracer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class WebController {

    private final StudentService studentService;

    public WebController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("student", new StudentModel());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("summary", Map.of(
                "average", studentService.getAverage(),
                "highest", studentService.getHighest(),
                "lowest", studentService.getLowest()
        ));
        return "index"; // loads templates/index.html
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute StudentModel student) {
        studentService.addStudent(student);
        return "redirect:/";
    }
}
