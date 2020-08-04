package pl.tomaszosuch.calculator;

import java.math.BigDecimal;

public class SalaryCalculatorConfig {

    private BigDecimal pensionContribution;
    private BigDecimal disabilityPremium;
    private BigDecimal sicknessContribution;
    private BigDecimal healthContribution;
    private BigDecimal costGettingIncome;
    private BigDecimal basisIncomeTax;
    private BigDecimal taxFreeAllowance;
    private BigDecimal healthTaxContribution;

    public static final class Builder {

        private BigDecimal pensionContribution;
        private BigDecimal disabilityPremium;
        private BigDecimal sicknessContribution;
        private BigDecimal healthContribution;
        private BigDecimal costGettingIncome;
        private BigDecimal basisIncomeTax;
        private BigDecimal taxFreeAllowance;
        private BigDecimal healthTaxContribution;

        public Builder pensionContribution(BigDecimal pensionContribution) {
            this.pensionContribution = pensionContribution;
            return this;
        }

        public Builder disabilityPremium(BigDecimal disabilityPremium) {
            this.disabilityPremium = disabilityPremium;
            return this;
        }

        public Builder sicknessContribution(BigDecimal sicknessContribution) {
            this.sicknessContribution = sicknessContribution;
            return this;
        }

        public Builder healthContribution(BigDecimal healthContribution) {
            this.healthContribution = healthContribution;
            return this;
        }

        public Builder costGettingIncome(BigDecimal costGettingIncome) {
            this.costGettingIncome = costGettingIncome;
            return this;
        }

        public Builder basisIncomeTax(BigDecimal basisIncomeTax) {
            this.basisIncomeTax = basisIncomeTax;
            return this;
        }

        public Builder taxFreeAllowance(BigDecimal taxFreeAllowance) {
            this.taxFreeAllowance = taxFreeAllowance;
            return this;
        }

        public Builder healthTaxContribution(BigDecimal healthTaxContribution) {
            this.healthTaxContribution = healthTaxContribution;
            return this;
        }

        public SalaryCalculatorConfig build() {
            SalaryCalculatorConfig salaryCalculatorConfig = new SalaryCalculatorConfig();
            salaryCalculatorConfig.disabilityPremium = this.disabilityPremium;
            salaryCalculatorConfig.pensionContribution = this.pensionContribution;
            salaryCalculatorConfig.sicknessContribution = this.sicknessContribution;
            salaryCalculatorConfig.healthContribution = this.healthContribution;
            salaryCalculatorConfig.costGettingIncome = this.costGettingIncome;
            salaryCalculatorConfig.basisIncomeTax = this.basisIncomeTax;
            salaryCalculatorConfig.taxFreeAllowance = this.taxFreeAllowance;
            salaryCalculatorConfig.healthTaxContribution = this.healthTaxContribution;
            return salaryCalculatorConfig;
        }
    }

    public BigDecimal getPensionContribution() {
        return pensionContribution;
    }

    public BigDecimal getDisabilityPremium() {
        return disabilityPremium;
    }

    public BigDecimal getSicknessContribution() {
        return sicknessContribution;
    }

    public BigDecimal getHealthContribution() {
        return healthContribution;
    }

    public BigDecimal getCostGettingIncome() {
        return costGettingIncome;
    }

    public BigDecimal getBasisIncomeTax() {
        return basisIncomeTax;
    }

    public BigDecimal getTaxFreeAllowance() {
        return taxFreeAllowance;
    }

    public BigDecimal getHealthTaxContribution() {
        return healthTaxContribution;
    }
}
