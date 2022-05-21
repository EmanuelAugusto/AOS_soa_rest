package com.project.professor.allocation.emanuelaugusto.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import com.project.professor.allocation.emanuelaugusto.entity.Department;
import java.text.ParseException;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentServiceTest {

    @Autowired
    DepartmentService departmentService;

    @Test
    public void findAll() {

        List<Department> Departments = departmentService.findAll();

        for (Department Department : Departments) {
            System.out.println(Department + "\n");
        }
    }

    @Test
    public void findById() {
        Department Department = departmentService.findById(45L);

        System.out.println("\n" + Department + "\n");
    }

    @Test
    public void save() throws ParseException {

        Department Department = new Department();
        Department.setId(null);
        int random = 1 + (int) (Math.random() * 100);
        Department.setName("Tecnologia" + random);

        // Act
        Department = departmentService.saveOrUpdate(Department);

        // Print
        System.out.println(Department.toString());

    }

    @Test
    public void update() throws ParseException {
        try {
            Department Department = departmentService.findById(1L);

            Department.setId(Department.getId());
            int random = 1 + (int) (Math.random() * 100);
            Department.setName("Tecnologia" + random);

            Department = departmentService.saveOrUpdate(Department);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteById() {
        departmentService.deleteById(5L);
    }

}
