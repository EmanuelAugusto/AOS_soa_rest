package com.project.professor.allocation.emanuelaugusto.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import com.project.professor.allocation.emanuelaugusto.entity.Teacher;
import java.text.ParseException;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class TeacherServiceTest {

    @Autowired
    TeacherService teacherService;

    @Test
    public void findAll() {

        List<Teacher> Teachers = teacherService.findAll();

        for (Teacher Teacher : Teachers) {
            System.out.println(Teacher + "\n");
        }
    }

    @Test
    public void findById() {
        Teacher Teacher = teacherService.findById(45L);

        System.out.println("\n" + Teacher + "\n");
    }

    @Test
    public void save() throws ParseException {

        Teacher Teacher = new Teacher();
        Teacher.setId(null);
        int random = 1 + (int) (Math.random() * 100);
        Teacher.setName("Tecnologia" + random);
        Teacher.setCpf("13455369" + random);
        Teacher.setdepartmentId(4L);

        // Act
        Teacher = teacherService.saveOrUpdate(Teacher);

        // Print
        System.out.println(Teacher.toString());

    }

    @Test
    public void update() throws ParseException {
        try {
            Teacher Teacher = teacherService.findById(1L);

            Teacher.setId(Teacher.getId());
            int random = 1 + (int) (Math.random() * 100);
            Teacher.setName("Tecnologia" + random);
            Teacher.setCpf("13455369" + random);
            Teacher.setdepartmentId(4L);

            Teacher = teacherService.saveOrUpdate(Teacher);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteById() {
        teacherService.deleteById(5L);
    }

}
