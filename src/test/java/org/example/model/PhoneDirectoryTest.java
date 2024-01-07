package org.example.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class PhoneDirectoryTest {
    private static PhoneDirectory phoneDirectory;

    @BeforeAll
    static void setUp() {
        phoneDirectory = new PhoneDirectory();
        phoneDirectory.add(new Employee
                (1, "89283849582", "Alan", "Wake", new Date(2019, 6, 21)));
        phoneDirectory.add(new Employee
                (2, "89298498485", "Kate", "Beckinsale", new Date(2006, 5, 15)));
        phoneDirectory.add(new Employee
                (3, "87478483465", "John", "Wick", new Date(2021, 5, 8)));
    }

    @Test
    void add() {
        Employee employee = new Employee
                (4, "9393949494949", "TestName", "TestSecondName", new Date(2024, 1, 7));
        phoneDirectory.add(employee);

        assertTrue(phoneDirectory.getEmployees().contains(employee));
    }

    @Test
    void findByExperiencePositive() {
        assertEquals(2, phoneDirectory.findByExperience(4).size());
    }
    @Test
    void findByExperienceNegative() {
        assertEquals(0, phoneDirectory.findByExperience(19).size());
    }

    @Test
    void findByFirstNamePositive() {
        assertEquals("Alan", phoneDirectory.findByFirstName("Alan").get(0).firstName());
    }

    @Test
    void findByFirstNameNegative() {
        assertEquals(0, phoneDirectory.findByFirstName("Lalka").size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void findByIdPositive(int index) {
        assertEquals(index, phoneDirectory.findById(index).id());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 5})
    void findByIdNegative(int index) {
        assertNull(phoneDirectory.findById(index));
    }
}