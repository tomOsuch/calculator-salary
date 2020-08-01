package pl.tomaszosuch.calculator;

import pl.tomaszosuch.model.Employee;

import java.math.BigDecimal;

public interface SalaryCalculatorRepository {

    BigDecimal calculatorGrossSalary(Employee employee);
}
