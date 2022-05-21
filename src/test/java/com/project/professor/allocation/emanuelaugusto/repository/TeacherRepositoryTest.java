package com.project.professor.allocation.emanuelaugusto.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import com.project.professor.allocation.emanuelaugusto.entity.Teacher;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class TeacherRepositoryTest {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void findAll() {
        List<Teacher> teacher = teacherRepository.findAll();

        for (Teacher teacher2 : teacher) {
            System.out.println(teacher2.toString());
        }
    }

    @Test
    public void findById() {
        Teacher teacher = teacherRepository.findById(2L).orElse(null);

        System.out.println(teacher.toString());
    }

    @Test
    public void save_create() throws ParseException {
        Teacher teacher = new Teacher();

        teacher.setId(null);
        teacher.setCpf("00000000000");
        teacher.setName("Emanuel Teste");
        teacher.setdepartmentId(1L);

        teacher = teacherRepository.save(teacher);

        System.out.println(teacher);

    }

    @Test
    public void save_update() throws ParseException {
        Teacher teacher = teacherRepository.findById(2L).orElse(null);

        teacher.setId(teacher.getId());
        teacher.setCpf("13455369413");

        teacher = teacherRepository.save(teacher);

    }

    @Test
    public void deleteById() {
        teacherRepository.deleteById(3L);

    }

    @Test
    public void deleteAll() {
        teacherRepository.deleteAllInBatch();

    }
}