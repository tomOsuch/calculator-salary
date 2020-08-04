package pl.tomaszosuch;

import pl.tomaszosuch.calculator.SalaryCalculator;
import pl.tomaszosuch.calculator.SalaryCalculatorConfig;
import pl.tomaszosuch.model.Employee;

import java.math.BigDecimal;

public class MainCalculatorSalary {

    public static void main(String[] args) {
        Employee employee = new Employee("Jan", "Kowalski", new BigDecimal(3500));
        SalaryCalculatorConfig calculatorConfig = new SalaryCalculatorConfig.Builder()
                .disabilityPremium(new BigDecimal(0.0976))
                .pensionContribution(new BigDecimal(0.015))
                .sicknessContribution(new BigDecimal(0.0245))
                .healthContribution(new BigDecimal(0.09))
                .costGettingIncome(new BigDecimal(250))
                .basisIncomeTax(new BigDecimal(0.17))
                .taxFreeAllowance(new BigDecimal(43.76))
                .healthTaxContribution(new BigDecimal(0.0775))
                .build();
        SalaryCalculator calculator = new SalaryCalculator(calculatorConfig);

        System.out.println(employee.toString());
        System.out.println("Wynagrodzenie brutto pracownika to: " + calculator.calculatorGrossSalary(employee));
    }
}
