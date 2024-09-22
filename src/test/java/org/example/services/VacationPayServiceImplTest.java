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
        String expected = "142207,053";

        double actual = vacationPayService.calculateVacationSalary(yearSalary, vacationDays);

        DecimalFormat df = new DecimalFormat("#.###");
        String actualFormatted = df.format(actual);

        assertEquals(expected, actualFormatted);
    }

    @Test
    void calculateVacationSalaryThreeArgs() {
        double yearSalary = 5000000;
        LocalDate vacationBegin = LocalDate.parse("2024-04-29");
        LocalDate vacationEnd = LocalDate.parse("2024-05-10"); //10 оплачиваемых дня отпуска
        String expected = "142207,053";

        double actual = vacationPayService.calculateVacationSalary(yearSalary, vacationBegin, vacationEnd);

        DecimalFormat df = new DecimalFormat("#.###");
        String actualFormatted = df.format(actual);

        assertEquals(expected, actualFormatted);
    }
}