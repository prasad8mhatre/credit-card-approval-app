package com.trustbank.creditapproval.search;

import com.trustbank.creditapproval.pojo.CardStatus;
import com.trustbank.creditapproval.pojo.CreditCardType;
import com.trustbank.creditapproval.pojo.Customer;
import java.util.stream.Collectors;
import java.util.List;

public class SearchUtil {
    
    public List<Customer> searchByCreditCardType(List<Customer> entities, CreditCardType cardType){
        return entities.stream().
                filter(e-> e.getApprovedCard().getCardType() == cardType).
                collect(Collectors.toList());
    }
    
    public List<Customer> searchByCreditStatus(List<Customer> entities, CardStatus cardStatus){
        return entities.stream().
                filter(e-> e.getApprovedCard().getCardStatus() == cardStatus).
                collect(Collectors.toList());
    }
    
    
    
}
