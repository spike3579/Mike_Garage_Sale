//***********Program to simulate a garage sale**********************
//    Takes user input to make garage sale items and then runs a simulated sale day 
//    Outputs the results and then prompts to run again
import java.util.ArrayList;

public class MikeSale{   
  ArrayList<SaleItem> saleItemsList = new ArrayList<SaleItem>();
  
  public void addAnotherItem(){ // checks to see if you want to add an item then makes an array and passes it to SaleItem constructor
    UserInput userIn = new UserInput();
    String moreItems = userIn.getUserInput("Would you like to add a item to sell? (y/n) ");
      if (moreItems.equals("y")){
      
        String[] saleItemArgs;
        saleItemArgs = new String[3];
       
        saleItemArgs[0] = userIn.getUserInput("Enter item name: ");
        saleItemArgs[1] = userIn.getUserInput("Enter item price (integers only): ");
        saleItemArgs[2] = userIn.getUserInput("Enter item condition (1-10): ");
        // pass args from array to constructor casting String numbers to ints
        SaleItem toSell = new SaleItem( saleItemArgs[0], Integer.parseInt(saleItemArgs[1]), Integer.parseInt(saleItemArgs[2]));
        saleItemsList.add(toSell);
        System.out.println("Added item successfully!");
        addAnotherItem(); //recursive call!! no loops be here
      }else{
      System.out.println("Ok, no more items for the sale.");
      }
    }
    
  public void notSoldListReader(ArrayList<SaleItem> passedInList){
    ArrayList<SaleItem> listToRead = new ArrayList<SaleItem>();
    listToRead = passedInList;
    for(SaleItem item : listToRead){  // go through list and print out each object's properties
      System.out.println("You listed: " + item.getName() + " for $" + item.getPrice() + " with a condition of " + item.getCondition());
    }
  }
  public void soldListReader(ArrayList<SaleItem> passedInList){
    ArrayList<SaleItem> listToRead = new ArrayList<SaleItem>();
    listToRead = passedInList;
    for(SaleItem item : listToRead){  // go through list and print out each object's properties
      System.out.println("You sold: " + item.getName() + " for $" + item.getPrice());
    }
  }
  public ArrayList<SaleItem> makeSaleItemsList(){  // calls maker of SaleItem and returns an Arraylist  
    addAnotherItem();
    return(saleItemsList);  // after list is built return it to caller
  } // end makeSaleItemList
  
  public ArrayList<ArrayList<SaleItem>> sellOrNot(ArrayList<SaleItem> passedInList){  // runs sale simulation on SaleItemsList and returns a new Arraylist  
    ArrayList<SaleItem> soldItemsList = new ArrayList<SaleItem>();
    ArrayList<SaleItem> notSoldItemsList = new ArrayList<SaleItem>();
    ArrayList<ArrayList<SaleItem>> listOlists = new ArrayList<ArrayList<SaleItem>>();
    
    for(SaleItem item : passedInList){  // go through list and sort them into two new lists sold and didn't sell 
      if(item.didISell()){
        item.soldPrice();
        soldItemsList.add(item);
      }else{
        notSoldItemsList.add(item);
      }
      listOlists.add(soldItemsList);
      listOlists.add(notSoldItemsList);
    }//end forloop
    return(listOlists);  // after list is built return it to caller
  } // end sellOrNot 
} // end MikeSale
