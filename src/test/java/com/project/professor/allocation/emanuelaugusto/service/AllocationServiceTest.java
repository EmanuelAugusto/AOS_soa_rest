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
            System.out.println(allocation + "\n");
        }
    }

    @Test
    public void findById() {
        Allocation allocation = allocationService.findById(45L);

        System.out.println("\n" + allocation + "\n");
    }

    @Test
    public void save() throws ParseException {
        // Arrange
        try {
            Allocation allocation = new Allocation();
            allocation.setId(null);
            allocation.setDay(DayOfWeek.SATURDAY);
            allocation.setStart(sdf.parse("17:00-0300"));
            allocation.setEnd(sdf.parse("18:00-0300"));
            allocation.setTeacherId(4L);
            allocation.setCourseId(8L);

            // Act
            allocation = allocationService.save(allocation);

            // Print
            System.out.println(allocation.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }

    }

    @Test
    public void update() throws ParseException {
        try {
            Allocation allocation = allocationService.findById(45L);

            allocation.setId(allocation.getId());
            allocation.setDay(DayOfWeek.WEDNESDAY);

            allocation = allocationService.save(allocation);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteById() {
        allocationService.deleteById(35L);
    }

}