package com.trustbank.creditapproval.impl.Runner;

import com.trustbank.creditapproval.impl.calc.CreditCardCal;
import com.trustbank.creditapproval.impl.calc.CreditScoreCalculator;
import com.trustbank.creditapproval.pojo.CurrentCreditCard;
import com.trustbank.creditapproval.pojo.Customer;
import java.util.ArrayList;
import java.util.List;

public class SeedDataDao{

    public static List<Customer> customers = new ArrayList<>(); 
    
    public SeedDataDao() {
        for(int i = 1; i <= 200; i++){
            Customer c = new Customer();
            c.setAddress("Street no." + i + ", Dubline");
            c.setCustId("customer" + i);
            c.setName("customer" + i);
            c.setCurrentSalary(100000 + RandomNumProvider.getRandomNum(2000));
            c.setPreviousCreditScore(RandomNumProvider.getRandomCreditScore());
            c.setCurrentCreditScore(RandomNumProvider.getRandomCreditScore());
            c.setCurrentCreditCards(RandomNumProvider.getRandomCreditCard());
            c.setCurrentLoans(RandomNumProvider.getRandomloans());
            CreditScoreCalculator.calc(c);
            CurrentCreditCard card = RandomNumProvider.getRandomCurrentCreditCards();
            CreditCardCal.calc(c, card);
            c.setApprovedCard(card);
            customers.add(c);
        }
        
    }
    
    public static List<Customer> getAllData(){
        return customers;
    }
    
    public static void setAllData(List<Customer> customers){
        SeedDataDao.customers = customers;
    }
    
    public static void addData(Customer customer){
        SeedDataDao.customers.add(customer);
    }
    
    public static void updateData(Customer customer){
        for(int i = 0 ;i < SeedDataDao.customers.size(); i++){
            if(customer.getCustId().equalsIgnoreCase(SeedDataDao.customers.get(i).getCustId())){
                Customer c = SeedDataDao.customers.get(i);
                c = customer;
            }
        }
    }
    
    public static Customer getSingle(String name) {
        Customer c1 = null;
        for(int i = 0 ;i < SeedDataDao.customers.size(); i++){
            if(name.equalsIgnoreCase(SeedDataDao.customers.get(i).getName())){
                c1 = SeedDataDao.customers.get(i);
                break;
            }
        }
        
        return c1;
    }
    
    public static void delete(String name) {
        int index = -1;
        Customer c = null;
        for(int i = 0 ;i < SeedDataDao.customers.size(); i++){
            if(name.equalsIgnoreCase(SeedDataDao.customers.get(i).getName())){
               index = i;
               c = SeedDataDao.customers.get(i);
            }
        }
        if(c != null){
            SeedDataDao.customers.remove(index);
        }
       
    }
    
}
