package com.trustbank.creditapproval.pojo;

public class Loan {
    private String name;
    private Double amountBorrowed;
    private Double currentAmountOfLoanRemaining;
    private Double minimumRequiredMonthlyPayment;
    private Double numberOfYearsOfPaymentsRemaining;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmountBorrowed() {
        return amountBorrowed;
    }

    public void setAmountBorrowed(Double amountBorrowed) {
        this.amountBorrowed = amountBorrowed;
    }

    public Double getCurrentAmountOfLoanRemaining() {
        return currentAmountOfLoanRemaining;
    }

    public void setCurrentAmountOfLoanRemaining(Double currentAmountOfLoanRemaining) {
        this.currentAmountOfLoanRemaining = currentAmountOfLoanRemaining;
    }

    public Double getMinimumRequiredMonthlyPayment() {
        return minimumRequiredMonthlyPayment;
    }

    public void setMinimumRequiredMonthlyPayment(Double minimumRequiredMonthlyPayment) {
        this.minimumRequiredMonthlyPayment = minimumRequiredMonthlyPayment;
    }

    public Double getNumberOfYearsOfPaymentsRemaining() {
        return numberOfYearsOfPaymentsRemaining;
    }

    public void setNumberOfYearsOfPaymentsRemaining(Double numberOfYearsOfPaymentsRemaining) {
        this.numberOfYearsOfPaymentsRemaining = numberOfYearsOfPaymentsRemaining;
    }

    @Override
    public String toString() {
        return "Loan{" + "name=" + name + ", amountBorrowed=" + amountBorrowed + ", currentAmountOfLoanRemaining=" + currentAmountOfLoanRemaining + ", minimumRequiredMonthlyPayment=" + minimumRequiredMonthlyPayment + ", numberOfYearsOfPaymentsRemaining=" + numberOfYearsOfPaymentsRemaining + '}';
    }
    
    
}
