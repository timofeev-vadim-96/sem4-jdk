package org.example;

import org.example.model.Employee;
import org.example.view.View;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        view
                .add(new Employee(1, "89283849582", "Alan", "Wake", new Date(2019, 6, 21)))
                .add(new Employee(2, "89298498485", "Kate", "Beckinsale", new Date(2006, 5, 15)))
                .add(new Employee(3, "87478483465", "John", "Wick", new Date(2021, 5, 8)));

        view.findByFirstName("Alan");
        view.findByFirstName("Oleg");

        view.findById(2);
        view.findById(5);

        view.findByExperience(4);
        view.findByExperience(30);
    }
}
