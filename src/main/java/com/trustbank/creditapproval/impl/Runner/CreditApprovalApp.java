package com.trustbank.creditapproval.impl.Runner;

import com.trustbank.creditapproval.pojo.CreditCardType;
import java.util.Scanner;

public class CreditApprovalApp {
    
    public static void main(String[] args) {
        System.out.println("***************************************************\n");
        System.out.println("************Credit Approval App********************\n");
        System.out.println("***************************************************\n");
        Scanner input = new Scanner(System.in);
        RandomNumProvider numProvider =  new RandomNumProvider();
        SeedDataDao dao = new SeedDataDao();
        

        do {
            System.out.println("\n\n Menu");
            System.out.println("--------------------------------------");
            System.out.println("1 - Add Customer");
            System.out.println("2 - Update Customer");
            System.out.println("3 - Delete Customer");
            System.out.println("4 - List All Customer");
            System.out.println("5 - Search for or view Ultimate card approved customers");
            System.out.println("6 - Search for or view Silver card approved customers");
            System.out.println("7 - Search for or view Gold card approved customers");
            System.out.println("8 - View all declined current customers");
            System.out.println("9 - Grant the approved type of new card to an individual approved customer");
            System.out.println("10 - Grant the approved type of new card to all approved customers");
            System.out.print("11 - Exit");
            System.out.print("\n Select a Menu Option: ");
            Integer i;
            try{
               i = input.nextInt();
              
            }catch(Exception e){
                System.out.println("Invalid input, exit");
                i = 11;
            }
            
            getInput(i); 
           
        }while(true);
        
    }
    
    


private static void getInput(Integer input) {
    CustomerManagerService cms = new CustomerManagerServiceImpl();
    switch(input) {
        case 1:
            cms.addCustomer();
            break;
        case 2: 
            cms.updateCustomer();
            break;
        case 3: 
            cms.deleteCustomer();
            break;
        case 4: cms.getAllCustomer();
            break;
        case 5: 
            cms.search(CreditCardType.Ultimate);
            break;
        case 6: 
            cms.search(CreditCardType.Sliver);
            break;
        case 7: 
            cms.search(CreditCardType.Gold);
            break;
        case 8: 
            cms.declinedCustomer();
            break;
        case 9:
            cms.grantToSingleCustomer();
            break;
        case 10:
            cms.grantToAllCustomers();
            break;
        case 11:
           System.exit(0);
        default:
            System.out.print("The entered value is unrecognized!");
            break;
    }
}
    
}
