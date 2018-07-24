package com.trustbank.creditapproval.impl.calc;

import com.trustbank.creditapproval.pojo.CreditCard;
import com.trustbank.creditapproval.pojo.CreditScore;
import com.trustbank.creditapproval.pojo.Customer;
import com.trustbank.creditapproval.pojo.Loan;

public class CreditScoreCalculator{
    
    public static void calc(Customer customer){
         Double totalOutgoing = new Double(0);
       
        for(CreditCard ccard: customer.getCurrentCreditCards()){
            totalOutgoing  = totalOutgoing + ccard.getCurrentAmountOfCreditOwed();
        }
        for(Loan loan: customer.getCurrentLoans()){
            totalOutgoing  = totalOutgoing + loan.getMinimumRequiredMonthlyPayment();
        }
        
        Double remainingSalary = customer.getCurrentSalary() - totalOutgoing;
        Double percentSalaryDiff = (remainingSalary / customer.getCurrentSalary()) * 100;
        if(percentSalaryDiff >= 40 && percentSalaryDiff <= 60){
            customer.setCurrentCreditScore(CreditScore.score1);
        }else if(percentSalaryDiff >= 60 && percentSalaryDiff <= 80){
            customer.setCurrentCreditScore(CreditScore.score2);
        }else if(percentSalaryDiff > 80){
            customer.setCurrentCreditScore(CreditScore.score3);
        } 
    }
   
    
}
