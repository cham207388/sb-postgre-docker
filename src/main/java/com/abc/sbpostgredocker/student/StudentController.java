package com.abc.sbpostgredocker.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository studentRepository;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.ok(savedStudent.getId());
    }
}
