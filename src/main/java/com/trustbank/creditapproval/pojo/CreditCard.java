package com.trustbank.creditapproval.pojo;

public class CreditCard {
    private String name;
    private String cardId;
    private Double maxCreditAmountAllowance;
    private Double currentAmountOfCreditOwed;
    private Double minimumRequiredMonthlyPayment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Double getMaxCreditAmountAllowance() {
        return maxCreditAmountAllowance;
    }

    public void setMaxCreditAmountAllowance(Double maxCreditAmountAllowance) {
        this.maxCreditAmountAllowance = maxCreditAmountAllowance;
    }

    public Double getCurrentAmountOfCreditOwed() {
        return currentAmountOfCreditOwed;
    }

    public void setCurrentAmountOfCreditOwed(Double currentAmountOfCreditOwed) {
        this.currentAmountOfCreditOwed = currentAmountOfCreditOwed;
    }

    public Double getMinimumRequiredMonthlyPayment() {
        return minimumRequiredMonthlyPayment;
    }

    public void setMinimumRequiredMonthlyPayment(Double minimumRequiredMonthlyPayment) {
        this.minimumRequiredMonthlyPayment = minimumRequiredMonthlyPayment;
    }

    @Override
    public String toString() {
        return "CreditCard{" + "name=" + name + ", cardId=" + cardId + ", maxCreditAmountAllowance=" + maxCreditAmountAllowance + ", currentAmountOfCreditOwed=" + currentAmountOfCreditOwed + ", minimumRequiredMonthlyPayment=" + minimumRequiredMonthlyPayment + '}';
    }
    
    
}
