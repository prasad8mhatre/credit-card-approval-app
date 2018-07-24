package com.trustbank.creditapproval.pojo;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String address;
    private String custId;
    private CreditScore currentCreditScore;
    private CreditScore previousCreditScore;
    private List<CreditCard> currentCreditCards = new ArrayList<>();
    private List<Loan> currentLoans = new ArrayList<>();
    private Double currentSalary;
    private CurrentCreditCard approvedCard;

    public CurrentCreditCard getApprovedCard() {
        return approvedCard;
    }

    public void setApprovedCard(CurrentCreditCard approvedCard) {
        this.approvedCard = approvedCard;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public CreditScore getCurrentCreditScore() {
        return currentCreditScore;
    }

    public void setCurrentCreditScore(CreditScore currentCreditScore) {
        this.currentCreditScore = currentCreditScore;
    }

    public CreditScore getPreviousCreditScore() {
        return previousCreditScore;
    }

    public void setPreviousCreditScore(CreditScore previousCreditScore) {
        this.previousCreditScore = previousCreditScore;
    }

    public List<CreditCard> getCurrentCreditCards() {
        return currentCreditCards;
    }

    public void setCurrentCreditCards(List<CreditCard> currentCreditCards) {
        this.currentCreditCards = currentCreditCards;
    }

    public List<Loan> getCurrentLoans() {
        return currentLoans;
    }

    public void setCurrentLoans(List<Loan> currentLoans) {
        this.currentLoans = currentLoans;
    }

    public Double getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(Double currentSalary) {
        this.currentSalary = currentSalary;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", address=" + address + ", custId=" + custId + ", currentCreditScore=" + currentCreditScore + ", previousCreditScore=" + previousCreditScore + ", currentCreditCards=" + currentCreditCards + ", currentLoans=" + currentLoans + ", currentSalary=" + currentSalary + '}';
    }
    
    
}
