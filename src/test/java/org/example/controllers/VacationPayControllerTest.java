package org.example.controllers;

import org.example.calculators.VacationPayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringJUnitConfig({
        VacationPayController.class
})
class VacationPayControllerTest {

    @Autowired
    VacationPayController vacationPayController;

    @MockBean
    private VacationPayService vacationPayService;

    @Test
    void calculateTwoArgs() {
        double yearSalary = 5000000;
        int vacationDays = 10;
        double expected = 142207.053;
        when(vacationPayService.calculateVacationSalary(anyDouble(), anyInt())).thenReturn(expected);

        ResponseEntity<Double> response = vacationPayController.calculate(yearSalary, vacationDays);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).isGreaterThan(0);

        assertThat(response.getBody()).isEqualTo(expected);

        verify(vacationPayService).calculateVacationSalary(anyDouble(), anyInt());
        verifyNoMoreInteractions(vacationPayService);
    }

    @Test
    void calculateThreeArgs() {
        double yearSalary = 5000000;
        LocalDate vacationBegin = LocalDate.parse("2024-04-29");
        LocalDate vacationEnd = LocalDate.parse("2024-05-10");
        double expected = 142207.053;
        when(vacationPayService.calculateVacationSalary(anyDouble(), any(), any())).thenReturn(expected);

        ResponseEntity<Double> response = vacationPayController.calculate(yearSalary, vacationBegin, vacationEnd);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).isGreaterThan(0);

        assertThat(response.getBody()).isEqualTo(expected);

        verify(vacationPayService).calculateVacationSalary(anyDouble(), any(), any());
        verifyNoMoreInteractions(vacationPayService);
    }
}