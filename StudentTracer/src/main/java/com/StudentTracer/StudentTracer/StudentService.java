package com.StudentTracer.StudentTracer;



import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<StudentModel> students = new ArrayList<>();

    public void addStudent(StudentModel student) {
        students.add(student);
    }

    public List<StudentModel> getAllStudents() {
        return students;
    }

    public int getAverage() {
        if (students.isEmpty()) return 0;
        return students.stream().mapToInt(StudentModel::getMarks).sum() / students.size();
    }

    public int getHighest() {
        return students.stream().mapToInt(StudentModel::getMarks).max().orElse(0);
    }

    public int getLowest() {
        return students.stream().mapToInt(StudentModel::getMarks).min().orElse(0);
    }
}

