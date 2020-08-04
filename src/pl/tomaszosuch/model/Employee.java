package pl.tomaszosuch.model;

import java.math.BigDecimal;

public class Employee {

    private String firstName;
    private String lastName;
    private BigDecimal netSalaryPerMonth;

    public Employee(String firstName, String lastName, BigDecimal netSalaryPerMonth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.netSalaryPerMonth = netSalaryPerMonth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getNetSalaryPerMonth() {
        return netSalaryPerMonth;
    }

    @Override
    public String toString() {
        return "Pracownik: " +
                "firstName: " + firstName +
                ", lastName: " + lastName +
                ", netSalaryPerMonth: " + netSalaryPerMonth;
    }
}