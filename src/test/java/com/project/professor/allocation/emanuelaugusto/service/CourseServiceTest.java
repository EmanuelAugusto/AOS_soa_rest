package com.project.professor.allocation.emanuelaugusto.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import com.project.professor.allocation.emanuelaugusto.entity.Course;
import java.text.ParseException;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class CourseServiceTest {

    @Autowired
    CourseService courseService;

    @Test
    public void findAll() {

        List<Course> courses = courseService.findAll();

        for (Course course : courses) {
            System.out.println(course + "\n");
        }
    }

    @Test
    public void findById() {
        Course course = courseService.findById(45L);

        System.out.println("\n" + course + "\n");
    }

    @Test
    public void save() throws ParseException {

        Course course = new Course();
        course.setId(null);
        int random = 1 + (int) (Math.random() * 100);
        course.setName("Tecnologia" + random);

        // Act
        course = courseService.saveOrUpdate(course);

        // Print
        System.out.println(course.toString());

    }

    @Test
    public void update() throws ParseException {
        try {
            Course course = courseService.findById(1L);

            course.setId(course.getId());
            int random = 1 + (int) (Math.random() * 100);
            course.setName("Tecnologia" + random);

            course = courseService.saveOrUpdate(course);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteById() {
        courseService.deleteById(5L);
    }

}
