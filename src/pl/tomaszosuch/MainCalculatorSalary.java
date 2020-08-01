package pl.tomaszosuch;

import pl.tomaszosuch.calculator.SalaryCalculator;
import pl.tomaszosuch.calculator.SalaryCalculatorConfig;
import pl.tomaszosuch.model.Employee;

public class MainCalculatorSalary {

    public static void main(String[] args) {
        Employee employee = new Employee("Jan", "Kowalski", 14.93, 8);
        SalaryCalculatorConfig calculatorConfig = new SalaryCalculatorConfig(0.0976, 0.015, 0.0245);
        SalaryCalculator calculator = new SalaryCalculator(calculatorConfig);

        System.out.println(employee.toString());
        System.out.println("Wynagrodzenie brutto pracownika to: " + calculator.calculatorGrossSalary(employee));
    }
}
