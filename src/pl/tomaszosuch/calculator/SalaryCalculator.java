package pl.tomaszosuch.calculator;

import pl.tomaszosuch.model.Employee;

import java.math.BigDecimal;

public class SalaryCalculator implements SalaryCalculatorRepository {

    private SalaryCalculatorConfig calculatorConfig;

    public SalaryCalculator(SalaryCalculatorConfig calculatorConfig) {
        this.calculatorConfig = calculatorConfig;

    }

    private double netSalaryPerMonth(Employee employee) {
        return employee.getRatePerHour() * employee.getHoursWorked() * 30;
    }

    private double socialInsuranceCalc(double gross) {
        return gross * (calculatorConfig.getDisabilityPremium() + calculatorConfig.getPensionContribution()
                + calculatorConfig.getSicknessContribution());
    }

    private double insuranceHealtCalc(double gross) {
        return gross * (1 - calculatorConfig.getDisabilityPremium() - calculatorConfig.getPensionContribution()
                - calculatorConfig.getSicknessContribution()) * 0.09;
    }

    private double incomeTaxCalc(double gross) {
        double insurance = socialInsuranceCalc(gross);
        return Math.round(Math.round(gross - insurance - 250) * 0.17 - 43.76 - (gross - insurance) * 0.0775);
    }

    @Override
    public BigDecimal calculatorGrossSalary(Employee employee) {
        double grossSalary = netSalaryPerMonth(employee) * (1 + 0.4);
        double netSalaryConst = netSalaryPerMonth(employee);
        double flag = 0;
        do {

            socialInsuranceCalc(grossSalary);
            double netSalaryEstimated = grossSalary - socialInsuranceCalc(grossSalary) - insuranceHealtCalc(grossSalary) - incomeTaxCalc(grossSalary);
            if (netSalaryEstimated > netSalaryConst) {
                flag = netSalaryEstimated - netSalaryConst;
            } else {
                flag = netSalaryConst - netSalaryEstimated;
            }
            grossSalary -= flag;
        } while (flag > 0.01);
        return BigDecimal.valueOf(grossSalary);
    }
}
