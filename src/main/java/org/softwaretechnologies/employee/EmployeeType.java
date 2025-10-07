package org.softwaretechnologies.employee;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * Тип сотрудника
 */
public enum EmployeeType {
    /*
    Формула вычисления зп: если месяц четный, то baseSalary, иначе baseSalary/2
     */
    Manager{

        public int calculateSalary(int baseSalary, int month) {
            if (month % 2 == 0) {
                return baseSalary;
            } else {
                return baseSalary / 2;
            }
        }
    },

    /*
    Формула вычисления зп: всегда baseSalary
     */
    Programmer{
        public int calculateSalary(int baseSalary, int month) {
            return baseSalary;
        }

    },
    /*
    Формула вычисления зп: baseSalary * количество дней в месяце в текущем году
    Вычисление количества дней в месяце: YearMonth.of(LocalDate.now().getYear(), month).lengthOfMonth()
     */
    Tester{
        public int calculateSalary(int baseSalary, int month){
            int daysInMonth = YearMonth.of(LocalDate.now().getYear(), month).lengthOfMonth();
            return baseSalary * daysInMonth;
        }
    };
}
