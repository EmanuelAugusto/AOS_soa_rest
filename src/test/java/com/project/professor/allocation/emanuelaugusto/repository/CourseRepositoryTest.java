package com.project.professor.allocation.emanuelaugusto.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.project.professor.allocation.emanuelaugusto.entity.Course;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CourseRepositoryTest {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findAll() {
        List<Course> course = courseRepository.findAll();

        for (Course course2 : course) {
            System.out.println(course2.toString());
        }
    }

    @Test
    public void findById() {
        Course course = courseRepository.findById(1L).orElse(null);

        System.out.println(course.toString());

    }

    @Test
    public void save_create() throws ParseException {
        Course course = new Course();
        course.setId(null);
        int random = 1 + (int) (Math.random() * 100);
        course.setName("Tecnologia" + random);

        course = courseRepository.save(course);

        System.out.println(course);

    }

    @Test
    public void save_update() throws ParseException {
        Course course = courseRepository.getById(2L);

        int random = 1 + (int) (Math.random() * 100);
        course.setName("T.i" + random);
        course.setId(course.getId());

        course = courseRepository.save(course);

        System.out.println(course.toString());
    }

    @Test
    public void deleteById() {
        courseRepository.deleteById(3L);

    }

    @Test
    public void deleteAll() {
        courseRepository.deleteAllInBatch();
    }
}