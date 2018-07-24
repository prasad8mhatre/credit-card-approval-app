package com.trustbank.creditapproval.impl.Runner;

import com.trustbank.creditapproval.impl.calc.CreditCardCal;
import com.trustbank.creditapproval.impl.calc.CreditScoreCalculator;
import com.trustbank.creditapproval.pojo.CardStatus;
import com.trustbank.creditapproval.pojo.CreditCard;
import com.trustbank.creditapproval.pojo.CreditCardType;
import com.trustbank.creditapproval.pojo.CurrentCreditCard;
import com.trustbank.creditapproval.pojo.Customer;
import com.trustbank.creditapproval.search.SearchUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManagerServiceImpl implements CustomerManagerService{

    @Override
    public void addCustomer() {
        System.out.println("----------------------------------");
        System.out.println("Add New Customer");
        System.out.println("----------------------------------");
        Scanner input = new Scanner(System.in);
        Customer customer =  new Customer();
        System.out.println("Enter customer name:");
        customer.setName(input.next());
        System.out.println("Enter customer Address:");
        customer.setAddress(input.next());
        System.out.println("Enter customer Salary:");
        Double sal = 0.0;
        try{
            sal = input.nextDouble();
        }catch(Exception e){
            System.out.println("invalid input, defaulting to zero");
        }
        customer.setCurrentSalary(sal);
        customer.setCustId("cust"+(int)RandomNumProvider.getRandomNum(1000));
        SeedDataDao.addData(customer);
    }

    @Override
    public void updateCustomer() {
        System.out.println("----------------------------------");
        System.out.println("Update Customer");
        System.out.println("----------------------------------");
        Scanner input = new Scanner(System.in);
        Customer customer =  null;
        System.out.println("Enter customer name:");
        String name = input.next();
        customer = SeedDataDao.getSingle(name);
        if(customer != null){
            System.out.println("Enter customer name:");
            customer.setName(input.next());
            System.out.println("Enter customer Address:");
            customer.setAddress(input.next());
            Double sal = 0.0;
            try{
                sal = input.nextDouble();
            }catch(Exception e){
                System.out.println("invalid input, defaulting to zero");
            }
            customer.setCurrentSalary(sal);
            SeedDataDao.updateData(customer);
        }else{
            System.out.println("No data found");
        }
        
        
    }

    @Override
    public void getAllCustomer() {
        System.out.println("----------------------------------");
        System.out.println("All Customers");
        System.out.println("----------------------------------");
        List<Customer> customers = SeedDataDao.getAllData();
        print(customers);
    }

    private void print(List<Customer> customers) {
        System.out.println("Id | Name | Address | Salary | Credit Card | status");
        customers.forEach(cus ->{
            CreditCardType cardType = cus.getApprovedCard() != null ? cus.getApprovedCard().getCardType(): null;
            CardStatus cardStatus = cus.getApprovedCard() != null ? cus.getApprovedCard().getCardStatus():null;
            System.out.println("" + cus.getCustId() + " | " +
                    cus.getName() + " | " + cus.getAddress() + " | " +
                    cus.getCurrentSalary().toString() + " | " +
                    cardType + " | " + cardStatus
                    
            );
        });
        System.out.println("Count:" + customers.size());
    }

    @Override
    public void getCustomer() {
        System.out.println("----------------------------------");
        System.out.println("View Customer");
        System.out.println("----------------------------------");
        //return SeedDataDao.getSingle(id);
    }

    @Override
    public void deleteCustomer() {
        System.out.println("----------------------------------");
        System.out.println("Delete Customer");
        System.out.println("----------------------------------");
        Scanner input = new Scanner(System.in);
        Customer customer =  null;
        System.out.println("Enter customer name:");
        String name = input.next();
        customer = SeedDataDao.getSingle(name);
        if(customer != null){
             SeedDataDao.delete(customer.getName());
        }else{
            System.out.println("No data found");
        }
       
    }
    
    @Override
    public void search(CreditCardType cardType){
        System.out.println("----------------------------------");
        System.out.println("Search Customer");
        System.out.println("----------------------------------");
        SearchUtil searchUtil = new SearchUtil();
        List<Customer> customers = searchUtil.searchByCreditCardType(SeedDataDao.getAllData(), cardType);
        print(customers);
        
    }

    @Override
    public void declinedCustomer() {
        System.out.println("----------------------------------");
        System.out.println("View all declined current customers");
        System.out.println("----------------------------------");
        SearchUtil searchUtil = new SearchUtil();
        List<Customer> customers = searchUtil.searchByCreditStatus(SeedDataDao.getAllData(), CardStatus.DECLINE);
        print(customers);
        
        
    }

    @Override
    public void grantToSingleCustomer() {
        System.out.println("----------------------------------");
        System.out.println("Grant the approved type of new card to an individual approved customer");
        System.out.println("----------------------------------");
        Scanner input = new Scanner(System.in);
        Customer customer =  null;
        System.out.println("Enter customer name:");
        String name = input.next();
        customer = SeedDataDao.getSingle(name);
        if(customer != null){
            System.out.println("Card details:");
            CreditCard card = new CreditCard();
            
            System.out.println("Enter Card maxCreditAmountAllowance:");
            Double mx = 0.0, min = 0.0, curr = 0.0;
            try{
                mx = input.nextDouble();
            }catch(Exception e ){
                System.out.println("Invalid input, defaulting to zero");
            }
            card.setMaxCreditAmountAllowance(mx);
            
            System.out.println("Enter Card currentAmountOfCreditOwed:");
            try{
                curr = input.nextDouble();
            }catch(Exception e ){
                System.out.println("Invalid input, defaulting to zero");
            }
            card.setCurrentAmountOfCreditOwed(curr);
            
            System.out.println("Enter Card minimumRequiredMonthlyPayment:");
            try{
                min = input.nextDouble();
            }catch(Exception e ){
                System.out.println("Invalid input, defaulting to zero");
            }
            
            card.setMinimumRequiredMonthlyPayment(min);
            
            CurrentCreditCard newCard = new CurrentCreditCard();
            newCard.setCard(card);
            newCard.setCardType(CreditCardType.Ultimate);
            CurrentCreditCard creditCard = CreditCardCal.calc(customer, newCard);
            customer.setApprovedCard(creditCard);
            System.out.println("customer: " + customer.getApprovedCard().toString());
            SeedDataDao.updateData(customer);
        }else{
            System.out.println("No data found");
        }
        
    }

    @Override
    public void grantToAllCustomers() {
        System.out.println("----------------------------------");
        System.out.println("Grant the approved type of new card to all approved customers");
        System.out.println("----------------------------------");
        Scanner input = new Scanner(System.in);
        System.out.println("Card details:");
        CreditCard card = new CreditCard();

        System.out.println("Enter Card maxCreditAmountAllowance:");
        Double mx = 0.0, min = 0.0, curr = 0.0;
        try{
            mx = input.nextDouble();
        }catch(Exception e ){
            System.out.println("Invalid input, defaulting to zero");
        }
        card.setMaxCreditAmountAllowance(mx);

        System.out.println("Enter Card currentAmountOfCreditOwed:");
        try{
            curr = input.nextDouble();
        }catch(Exception e ){
            System.out.println("Invalid input, defaulting to zero");
        }
        card.setCurrentAmountOfCreditOwed(curr);

        System.out.println("Enter Card minimumRequiredMonthlyPayment:");
        try{
            min = input.nextDouble();
        }catch(Exception e ){
            System.out.println("Invalid input, defaulting to zero");
        }
        card.setMinimumRequiredMonthlyPayment(min);

        CurrentCreditCard newCard = new CurrentCreditCard();
        newCard.setCard(card);
        newCard.setCardType(CreditCardType.Ultimate);
        
        List<Customer> cs = new ArrayList<>();
        for(Customer customer : SeedDataDao.customers){
            if(customer.getCurrentSalary() != null){
                CurrentCreditCard creditCard = CreditCardCal.calc(customer, newCard);
                if(creditCard.getCardStatus() == CardStatus.APPROVED){
                    customer.setApprovedCard(creditCard);
                    System.out.println("customer: " + customer.getApprovedCard().toString());
                }
            }
            cs.add(customer);
        }
        
        SeedDataDao.setAllData(cs);
            
    }
    
}
