
/**
 * Write a description of class Exercise2_Employee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Employee {

    //Private attributes
    private String employeeId;
    private String fullName;
    private String department;
    private double basicSalary;
    private int yearsOfService;

    //Default constructor
    public Employee() {
        this.employeeId = "UNKNOWN";
        this.fullName = "UNKNOWN";
        this.department = "UNKNOWN";
        this.basicSalary = 500000;
        this.yearsOfService = 0;
    }

    //Parameterized constructor
    public Employee(String employeeId, String fullName, String department, double basicSalary) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.department = department;
        this.basicSalary = basicSalary; 
        this.yearsOfService = yearsOfService;
    }

    //Getters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    //Setters with validation
    public void setBasicSalary(double basicSalary) {
        if (basicSalary >= 500000) {
            this.basicSalary = basicSalary;
        } else {
            this.basicSalary = 500000;
            System.out.println("Basic salary must be at least 500,000.");
        }
    }

    public void setYearsOfService(int yearsOfService) {
        if (yearsOfService >= 0) {
            this.yearsOfService = yearsOfService;
        } else {
            this.yearsOfService = 0;
            System.out.println("Years of service cannot be negative.");
        }
    }

    //calculateBonus()
    public double calculateBonus() {
        double bonusPercentage = yearsOfService * 10;

        if (bonusPercentage > 50) {
            bonusPercentage = 50;
        }

        return basicSalary * bonusPercentage / 100;
    }

    //calculateNetSalary()
    public double calculateNetSalary() {
        double bonus = calculateBonus();
        double grossSalary = basicSalary + bonus;
        double tax = grossSalary * 0.15;

        return grossSalary - tax;
    }

    //promote()
    public void promote(String newDepartment, double salaryIncrease) {
        this.department = newDepartment;

        if (salaryIncrease > 0) {
            this.basicSalary += salaryIncrease;
        }

        System.out.println(fullName + " has been promoted to " + newDepartment);
    }

    //displayPayslip()
    public void displayPayslip() {
        System.out.println("------ PAYSLIP ------");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + fullName);
        System.out.println("Department: " + department);
        System.out.println("Years of Service: " + yearsOfService);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("Net Salary: " + calculateNetSalary());
        System.out.println("---------------------\n");
    }

    //Main method (testing)
    public static void main(String[] args) {
        System.out.println("=== Employee Payroll Exercise ===\n");

        // Employee 1
        Employee employee1 =
                new Employee("EMP001", "Ali Hassan", "IT", 1500000);

        // Employee 2
        Employee employee2 =
                new Employee("EMP002", "Fatma Said", "HR", 1200000);

        // Set years of service
        employee1.setYearsOfService(5);
        employee2.setYearsOfService(2);

        // Display payslips
        employee1.displayPayslip();
        employee2.displayPayslip();

        // Promote employee1
        employee1.promote("Senior IT", 300000);

        // Display payslip after promotion
        employee1.displayPayslip();

        System.out.println("=== Exercise Complete ===");
    }
}
