package com.trustbank.creditapproval.impl.calc;

import com.trustbank.creditapproval.pojo.CardStatus;
import com.trustbank.creditapproval.pojo.CreditCard;
import com.trustbank.creditapproval.pojo.CreditCardType;
import com.trustbank.creditapproval.pojo.CurrentCreditCard;
import com.trustbank.creditapproval.pojo.Customer;
import com.trustbank.creditapproval.pojo.Loan;

public class CreditCardCal{
    
    public static CurrentCreditCard calc(Customer customer, CurrentCreditCard creditCard){
        boolean isApproved = true;
        if(customer.getCurrentCreditCards().size() > 5 || customer.getCurrentLoans().size() > 5 ||
                customer.getCurrentCreditCards().size() + customer.getCurrentLoans().size() > 8){
            isApproved = false;
        }
        
        Double totalOutgoing = new Double(0);
       
        for(CreditCard ccard: customer.getCurrentCreditCards()){
            totalOutgoing  = totalOutgoing + ccard.getCurrentAmountOfCreditOwed();
        }
        for(Loan loan: customer.getCurrentLoans()){
            totalOutgoing  = totalOutgoing + loan.getMinimumRequiredMonthlyPayment();
        }
        
        Double remainingSalary = customer.getCurrentSalary() - totalOutgoing;
        if( remainingSalary < (40 * creditCard.getCard().getMinimumRequiredMonthlyPayment() / 100)){
            isApproved = false;
        }
        
        if(isApproved){
            creditCard.setCardStatus(CardStatus.APPROVED);
        }else{
            creditCard.setCardStatus(CardStatus.DECLINE);
        }
        
        return creditCard;
        
       
        
        
    }
   
    
}
