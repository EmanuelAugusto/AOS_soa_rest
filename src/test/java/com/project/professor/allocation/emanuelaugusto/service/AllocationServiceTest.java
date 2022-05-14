package com.project.professor.allocation.emanuelaugusto.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import com.project.professor.allocation.emanuelaugusto.entity.Allocation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationServiceTest {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

    @Autowired
    AllocationService allocationService;

    @Test
    public void findAll() {

        List<Allocation> allocations = allocationService.findAll();

        for (Allocation allocation : allocations) {
            System.out.println(allocation);
        }
    }

    @Test
    public void findByProfessor() {
        // Arrange

        // Act

        // Print
    }

    @Test
    public void findByCourse() {
        // Arrange

        // Act

        // Print
    }

    @Test
    public void findById() {
        // Arrange

        // Act

        // Print
    }

    @Test
    public void save() throws ParseException {
        // Arrange

        // Act

        // Print
    }

    @Test
    public void update() throws ParseException {
        // Arrange

        // Act

    }

    @Test
    public void deleteById() {
        // Arrange

        // Act
    }

    @Test
    public void deleteAll() {
        // Act
    }
}