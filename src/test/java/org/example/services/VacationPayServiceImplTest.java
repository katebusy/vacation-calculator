package org.example.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import java.text.DecimalFormat;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig({
        VacationPayServiceImpl.class
})
class VacationPayServiceImplTest {
    @Autowired
    VacationPayService vacationPayService;

    @Test
    void calculateVacationSalaryTwoArgs() {
        double yearSalary = 5000000;
        int vacationDays = 10;
        double expected = 142207.053;
        double actual = vacationPayService.calculateVacationSalary(yearSalary, vacationDays);
        assertEquals(expected, actual);
    }

    @Test
    void calculateVacationSalaryThreeArgs() {
        double yearSalary = 5000000;
        LocalDate vacationBegin = LocalDate.parse("2024-04-29");
        LocalDate vacationEnd = LocalDate.parse("2024-05-10");
        double expected = 142207.053;
        double actual = vacationPayService.calculateVacationSalary(yearSalary, vacationBegin, vacationEnd);
        assertEquals(expected, actual);
    }
}