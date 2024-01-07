package org.example.model;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Класс сотрудника
 *
 * @param id              личный номер
 * @param phone           телефон
 * @param firstName       имя
 * @param secondName      фамилия
 * @param experienceSince стаж с определенной даты
 */
public record Employee(Integer id, String phone, String firstName, String secondName, Date experienceSince) {
    @Override
    public String toString() {
        return String.format("Id: %d, phone: %s, name: %s, secondName: %s, job experience since: %s",
                id, phone, firstName, secondName, experienceSince.getYear());
    }

    public int getExperience() {
        return LocalDateTime.now().getYear() - experienceSince.getYear();
    }
}
