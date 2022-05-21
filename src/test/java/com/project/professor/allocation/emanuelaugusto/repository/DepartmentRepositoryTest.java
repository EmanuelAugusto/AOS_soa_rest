package com.project.professor.allocation.emanuelaugusto.repository;

import com.project.professor.allocation.emanuelaugusto.entity.Department;
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

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTest {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

    @Autowired
    DepartmentRepository departamentRepository;

    @Test
    public void findAll() {
        List<Department> departments = departamentRepository.findAll();

        for (Department department : departments) {
            System.out.println(department.toString());
        }

    }

    @Test
    public void findById() {
        Department department = departamentRepository.getById(1L);

        System.out.println(department.toString());

    }

    @Test
    public void save_create() throws ParseException {
        Department department = new Department();

        department.setId(null);
        int random = 1 + (int) (Math.random() * 100);
        department.setName("teste " + random);

        department = departamentRepository.save(department);

        System.out.println(department);

    }

    @Test
    public void save_update() throws ParseException {
        Department department = departamentRepository.getById(1L);

        department.setId(department.getId());
        int random = 1 + (int) (Math.random() * 100);
        department.setName("teste " + random);

        department = departamentRepository.save(department);

    }

    @Test
    public void deleteById() {
        departamentRepository.deleteById(2L);

    }

    @Test
    public void deleteAll() {
        departamentRepository.deleteAllInBatch();

    }
}