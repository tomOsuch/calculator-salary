package pl.tomaszosuch.calculator;

import pl.tomaszosuch.model.Employee;

import java.math.BigDecimal;
import java.math.BigInteger;


public class SalaryCalculator implements SalaryCalculatorRepository {

    private SalaryCalculatorConfig calculatorConfig;
    private Employee employee;
    private BigDecimal sumInsurance = null;

    public SalaryCalculator(SalaryCalculatorConfig calculatorConfig) {
        this.calculatorConfig = calculatorConfig;
    }

    private BigDecimal netSalaryPermonth(Employee employee) {
        return employee.getNetSalaryPerMonth();
    }

    private BigDecimal socialInsuranceCalc(BigDecimal gross) {
        sumInsurance = calculatorConfig.getDisabilityPremium().add(calculatorConfig.getPensionContribution().add(calculatorConfig.getSicknessContribution()));
        return gross.multiply(sumInsurance);
    }

    private BigDecimal insuranceHealtCalc(BigDecimal gross) {
        return calculatorConfig.getHealthContribution().multiply(gross.multiply(new BigDecimal(1).subtract(sumInsurance)));
    }

    public BigDecimal incomeTaxCalc(BigDecimal gross) {
        BigDecimal insurance = socialInsuranceCalc(gross);

        BigInteger a = gross.subtract(insurance.subtract(calculatorConfig.getCostGettingIncome())).toBigInteger();//pseudo zaokrąglenie
        BigDecimal b = new BigDecimal(a);
        BigDecimal c = calculatorConfig.getBasisIncomeTax().multiply(b);
        BigDecimal d = calculatorConfig.getHealthTaxContribution().multiply(gross.subtract(insurance));
        BigDecimal e = c.subtract(calculatorConfig.getTaxFreeAllowance());
        BigInteger f = e.subtract(d).toBigInteger();
        BigDecimal result = new BigDecimal(f);
        return result;
    }

    @Override
    public BigDecimal calculatorGrossSalary(Employee employee) {
        BigDecimal factor = new BigDecimal(0.4);
        BigDecimal grossSalary = netSalaryPermonth(employee).add(netSalaryPermonth(employee).multiply(factor));
        BigDecimal netSalaryConst = netSalaryPermonth(employee);
        BigDecimal flag = null;
        do {
            socialInsuranceCalc(grossSalary);
            BigDecimal netSalaryEstimated = grossSalary.subtract(socialInsuranceCalc(grossSalary).subtract(insuranceHealtCalc(grossSalary).subtract(incomeTaxCalc(grossSalary))));
            if (netSalaryEstimated.compareTo(netSalaryConst) > 0) {
                flag = netSalaryEstimated.subtract(netSalaryConst);
            } else {
                flag = netSalaryConst.subtract(netSalaryEstimated);
            }
            grossSalary = grossSalary.subtract(flag);
        } while (flag.compareTo(flag.abs()) > 0); //TODO problem z warunkiem pętli i kolejnych iteracji
        return grossSalary;
    }
}