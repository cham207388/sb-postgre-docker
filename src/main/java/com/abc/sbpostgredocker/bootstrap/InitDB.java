package com.abc.sbpostgredocker.bootstrap;

import com.abc.sbpostgredocker.student.Student;
import com.abc.sbpostgredocker.student.StudentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final StudentRepository studentRepository;

    @PostConstruct
    public void init() {

        studentRepository.deleteAll();

        Student horeja = new Student();
        horeja.setName("Horeja Cham");

        Student abc = new Student();
        horeja.setName("Alhagie Bai Cham");

        Student ebrahim = new Student();
        horeja.setName("Ebrahim Cham");

        List<Student> students = List.of(horeja, abc, ebrahim);
        studentRepository.saveAll(students);
    }
}
