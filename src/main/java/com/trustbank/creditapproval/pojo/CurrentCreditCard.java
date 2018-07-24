package com.trustbank.creditapproval.pojo;

public class CurrentCreditCard{
    private CardStatus cardStatus;
    private CreditCard card;
    private CreditCardType cardType;

    public CreditCardType getCardType() {
        return cardType;
    }

    public void setCardType(CreditCardType cardType) {
        this.cardType = cardType;
    }
    
    

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }
    
    

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    @Override
    public String toString() {
        return "CurrentCreditCard{" + "cardStatus=" + cardStatus + ", card=" + card + '}';
    }
    
    
    
}