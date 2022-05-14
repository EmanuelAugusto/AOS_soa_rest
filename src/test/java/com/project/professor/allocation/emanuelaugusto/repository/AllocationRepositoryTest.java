package com.project.professor.allocation.emanuelaugusto.repository;

import com.project.professor.allocation.emanuelaugusto.entity.Allocation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationRepositoryTest {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

    @Autowired
    AllocationRepository allocationRepository;

    @Test
    public void findAll() {
        List<Allocation> allocation = allocationRepository.findAll();

        for (Allocation allocation2 : allocation) {
            System.out.println(allocation2.toString());
        }

    }

    @Test
    public void findById() {
        Allocation allocation = allocationRepository.findById(17L).orElse(null);

        System.out.println(allocation.toString());
    }

    @Test
    public void findByTeacherId() {
        List<Allocation> allocation = allocationRepository.findByTeacherId(1L);

        for (Allocation allocation2 : allocation) {
            System.out.println(allocation2.toString());
        }

    }

    @Test
    public void findByCourseId() {
        List<Allocation> allocation = allocationRepository.findByTeacherId(1L);

        for (Allocation allocation2 : allocation) {
            System.out.println(allocation2.toString());
        }

    }

    @Test
    public void save_update() throws ParseException {
        Allocation allocation = allocationRepository.findById(17L).orElse(null);

        allocation.setId(allocation.getId());
        allocation.setDay(DayOfWeek.MONDAY);

        allocation = allocationRepository.save(allocation);

        System.out.println(allocation.toString());
    }

    @Test
    public void deleteById() {
        Long id = 28L;

        allocationRepository.deleteById(id);

    }

    @Test
    public void save_create() throws ParseException {
        // Arrange
        Allocation allocation = new Allocation();
        allocation.setId(null);
        allocation.setDay(DayOfWeek.SUNDAY);
        allocation.setStart(sdf.parse("17:00-0300"));
        allocation.setEnd(sdf.parse("18:00-0300"));
        allocation.setTeacherId(1L);
        allocation.setCourseId(1L);

        // Act
        allocation = allocationRepository.save(allocation);

        // Print
        System.out.println(allocation);
    }

    @Test
    public void deleteAll() {
        allocationRepository.deleteAll();
    }

}