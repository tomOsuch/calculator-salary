package pl.tomaszosuch.calculator;

public class SalaryCalculatorConfig {

    private double pensionContribution;
    private double disabilityPremium;
    private double sicknessContribution;

    public SalaryCalculatorConfig(double pensionContribution, double disabilityPremium, double sicknessContribution) {
        this.pensionContribution = pensionContribution;
        this.disabilityPremium = disabilityPremium;
        this.sicknessContribution = sicknessContribution;
    }

    public double getPensionContribution() {
        return pensionContribution;
    }

    public double getDisabilityPremium() {
        return disabilityPremium;
    }

    public double getSicknessContribution() {
        return sicknessContribution;
    }
}
