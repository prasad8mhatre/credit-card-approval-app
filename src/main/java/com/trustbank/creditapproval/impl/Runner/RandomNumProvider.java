package com.trustbank.creditapproval.impl.Runner;

import com.trustbank.creditapproval.pojo.CardStatus;
import com.trustbank.creditapproval.pojo.CreditCard;
import com.trustbank.creditapproval.pojo.CreditCardType;
import com.trustbank.creditapproval.pojo.CreditScore;
import com.trustbank.creditapproval.pojo.CurrentCreditCard;
import com.trustbank.creditapproval.pojo.Customer;
import com.trustbank.creditapproval.pojo.Loan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomNumProvider{

    public static ArrayList<CreditCard> cards;
    public static ArrayList<Loan> loans;
    public static ArrayList<CurrentCreditCard> currentCreditCards;
    public RandomNumProvider() {
        cards = new ArrayList<>();
        for(int i = 0; i < 10 ; i++){
           CreditCard card = new CreditCard();
           card.setCardId("card" + i);
           card.setCurrentAmountOfCreditOwed(getRandomNum(20000));
           card.setMaxCreditAmountAllowance(getRandomNum(200000));
           card.setMinimumRequiredMonthlyPayment(getRandomNum(20000));
           cards.add(card);
        }
        
        loans = new ArrayList<>();
        for(int i = 0; i < 10 ; i++){
           Loan loan = new Loan();
           loan.setName("loan" + i);
           loan.setCurrentAmountOfLoanRemaining(getRandomNum(20000));
           loan.setMinimumRequiredMonthlyPayment(getRandomNum(2000));
           loan.setNumberOfYearsOfPaymentsRemaining(getRandomNum(20));
           loans.add(loan);
        }
        
        currentCreditCards = new ArrayList<>();
        for(int i = 0; i < 10 ; i++){
           CurrentCreditCard currentCreditCard = new CurrentCreditCard();
           currentCreditCard.setCard(getRandomCreditCard().get(0));
           currentCreditCard.setCardType(getRandomCardType());
           currentCreditCards.add(currentCreditCard);
        }
    }
    
    
    
    public static double getRandomNum(int m){
        Random rand = new Random();
        int  n = rand.nextInt(m) + 1;
        return n;
    }
    
    public static CreditCardType getRandomCreditCardType(){
        return CreditCardType.values()[(int)(Math.random()*CreditCardType.values().length)];
    }
    
    public static CreditScore getRandomCreditScore(){
        return CreditScore.values()[(int)(Math.random()*CreditScore.values().length)];
    }
    
    public static CardStatus getRandomCardStatus(){
        return CardStatus.values()[(int)(Math.random()*CardStatus.values().length)];
    }
    
    private CreditCardType getRandomCardType() {
        return CreditCardType.values()[(int)(Math.random()*CreditCardType.values().length)];
    }
    
    
    public static List<CreditCard> getRandomCreditCard(){
        double num = getRandomNum(10);
        int n = (int) num;
        List<CreditCard> cards1 = new ArrayList<>();
        for(int i = 0; i < n; i++){
            cards1.add(cards.get(i));
        }
        return cards1;
    }
    
    public static List<Loan> getRandomloans(){
        double num = getRandomNum(10);
        int n = (int) num;
        List<Loan> loans1 = new ArrayList<>();
        for(int i = 0; i < n; i++){
            loans1.add(loans.get(i));
        }
        return loans1;
    }
    
    public static CurrentCreditCard getRandomCurrentCreditCards(){
        double num = getRandomNum(10);
        int n = (int) num;
        return currentCreditCards.get(n-1);
    }

 
    
}
