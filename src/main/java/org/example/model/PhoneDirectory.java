package org.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Справочник сотрудников
 */
public class PhoneDirectory {

    private final List<Employee> employees = new ArrayList<>();

    /**
     * Метод добавления нового сотрудника
     *
     * @param employee сотрудник
     */
    public void add(Employee employee) {
        employees.add(employee);
    }

    /**
     * Метод поиска сотрудников по стажу
     *
     * @param years минимум лет стажа
     * @return список сотрудников
     */
    public List<Employee> findByExperience(int years) {
        return employees.stream().filter(employee -> employee.getExperience() >= years).toList();
    }

    /**
     * Метод поиска сотрудников по имени
     *
     * @param name имя
     * @return список сотрудников
     */
    public List<Employee> findByFirstName(String name) {
        return employees.stream().filter(employee -> employee.firstName().equals(name)).toList();
    }

    /**
     * Метод поиска сотрудника по личному номеру
     *
     * @param id личный номер
     * @return если сотрудник с таким id найден - Employee, если нет - null
     */
    public Employee findById(int id) {
        for (Employee employee : employees) {
            if (employee.id() == id) return employee;
        }
        return null;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
