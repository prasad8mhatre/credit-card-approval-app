package com.trustbank.creditapproval.impl.Runner;

import com.trustbank.creditapproval.pojo.CreditCardType;


public interface CustomerManagerService {
    
    public void addCustomer();
    public void updateCustomer();
    public void getAllCustomer();
    public void getCustomer();
    public void deleteCustomer();
    public void search(CreditCardType cardType);
    public void declinedCustomer();
    public void grantToSingleCustomer();
    public void grantToAllCustomers();
 
}
