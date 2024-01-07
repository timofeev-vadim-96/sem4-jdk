package org.example.view;

import org.example.model.Employee;
import org.example.model.PhoneDirectory;

import java.util.Arrays;
import java.util.List;

public class View {
    PhoneDirectory phoneDirectory;

    public View() {
        this.phoneDirectory = new PhoneDirectory();
    }

    public View add(Employee employee) {
        phoneDirectory.add(employee);
        return this;
    }

    public void findByExperience(int years) {
        List<Employee> employees = phoneDirectory.findByExperience(years);
        if (employees.isEmpty()) System.out.println("Сотрудники с указанным стажем не найдены!");
        else {
            System.out.println("Список сотрудников с указанным стажем и выше: ");
            employees.forEach(System.out::println);
        }
    }

    public void findByFirstName(String name) {
        List<Employee> employees = phoneDirectory.findByFirstName(name);
        if (employees.isEmpty()) System.out.println("Сотрудники с указанным именем не найдены!");
        else {
            System.out.println("Список сотрудников с указанным именем: ");
            employees.forEach(System.out::println);
        }

    }

    public void findById(int id) {
        Employee employee = phoneDirectory.findById(id);
        if (employee == null) System.out.println("Сотрудник с таким личным номером не найден!");
        else System.out.printf("Искомый сотрудник: %s\n", employee);
    }
}
