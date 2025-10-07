package org.softwaretechnologies;

import org.softwaretechnologies.employee.*;

public class EmployeeFactory {

    /**
     * Сначала создайте классы, наследуемые от  {@link  org.softwaretechnologies.employee.Employee Employee} для каждого из значений в EmployeeType.
     * Функция должна создавать и возвращать Employee нужного типа. Тип зависит от значения параметра type.
     *  name имя сотрудника
     *  baseSalary базовая зарплата сотрудника
     *  type тип сотрудника
     * @return созданного сотрудника нужного типа. Тип зависит от параметра type.
     */



    public static Employee createEmployee(String name, int baseSalary, EmployeeType type) {
        return switch (type) {
            case Manager -> new Manager(name, baseSalary);
            case Programmer -> new Programmer(name, baseSalary);
            case Tester -> new Tester(name, baseSalary);
            default -> throw new IllegalArgumentException("Неизвестный тип сотрудника: " + type);
        };
    }
}
