package pl.tomaszosuch.model;

public class Employee {

    private String firstName;
    private String lastName;
    private double ratePerHour;
    private double hoursWorked;

    public Employee(String firstName, String lastName, double ratePerHour, double hoursWorked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ratePerHour = ratePerHour;
        this.hoursWorked = hoursWorked;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return "Pracownik: " +
                "firstName: " + firstName +
                ", lastName: " + lastName +
                ", ratePerHour: " + ratePerHour +
                ", hoursWorked: " + hoursWorked;
    }
}
