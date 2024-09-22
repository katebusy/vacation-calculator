package org.example.services;

import java.time.LocalDate;

public interface VacationPayService {

    /**
     * Метод, который принимает в качестве аргументов среднюю готовую зарплату и количество отпускных дней
     * и возвращаяет сумму отпусных, округленных до тысячных, которые придут сотруднику.
     *
     * @param yearSalary средняя готовая зарплата
     * @param vacationDays количество отпускных дней
     * @return сумма отпускных
     */
    double calculateVacationSalary(double yearSalary, int vacationDays);

    /**
     * Метод, который принимает в качестве аргументов среднюю готовую зарплату, дату начала отпуска
     * и дату последнего дня отпуска и возвращает сумму откпускных, округленных до тысячных,
     * которые придут сотруднику с учетом праздников.
     *
     * @param yearSalary средняя готовая зарплата
     * @param vacationBegin дата начала отпуска
     * @param vacationEnd дата последнего дня отпуска
     * @return сумма отпускных
     */
    double calculateVacationSalary(double yearSalary, LocalDate vacationBegin, LocalDate vacationEnd);
}
