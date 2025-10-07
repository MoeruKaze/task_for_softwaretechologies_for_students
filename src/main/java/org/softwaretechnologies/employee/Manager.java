package org.softwaretechnologies.employee;

public class Manager extends Employee {
    public Manager(String name, int baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public int getMonthSalary(int month) {
        // Если месяц четный, то baseSalary, иначе baseSalary/2
        if (month % 2 == 0) {
            return baseSalary;
        } else {
            return baseSalary / 2;
        }
    }
}