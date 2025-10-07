package org.softwaretechnologies.employee;

import java.time.LocalDate;
import java.time.YearMonth;

public class Tester extends Employee {
    public Tester(String name, int baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public int getMonthSalary(int month) {
        // baseSalary * количество дней в месяце в текущем году
        int daysInMonth = YearMonth.of(LocalDate.now().getYear(), month).lengthOfMonth();
        return baseSalary * daysInMonth;
    }
}