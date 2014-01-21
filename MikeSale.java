//***********Program to simulate a garage sale**********************
//    Takes user input to make garage sale items and then runs a simulated sale day 
//    Outputs the results in a formatted report
import java.util.ArrayList;

public class MikeSale{ 
  
  ArrayList<SaleItem> saleItemsList = new ArrayList<SaleItem>();
  UserInput userIn = new UserInput();
  
  public ArrayList<SaleItem> buildSaleItemList(){ // creates saleItem objects and returns an ArrayList of them
    
    String moreItems = userIn.getUserInput("Enter an item to sell or type \"q\" to quit inputting items ");  // checks to see if you want to add an item then makes an array and passes it to SaleItem constructor
      if (moreItems.equals("q")){
        System.out.println("Ok, no more items for the sale.");
      }else{  
        String[] saleItemArgs = new String[3];
        saleItemArgs[0] = moreItems; 
        saleItemArgs[1] = userIn.getUserInput("Enter item price (integers only): ");
        saleItemArgs[2] = userIn.getUserInput("Enter item condition (1-10): ");
        // pass args from array to constructor casting String numbers to ints
        SaleItem toSell = new SaleItem( saleItemArgs[0], Integer.parseInt(saleItemArgs[1]), Integer.parseInt(saleItemArgs[2]));
        saleItemsList.add(toSell);
        System.out.println("Added item successfully!");
        buildSaleItemList(); //recursive call!! no loops be here
      }
      return(saleItemsList);  // after list is built return it to caller
    }
    
  public void listingReader(ArrayList<SaleItem> passedInList){
    String name = "Name";
    String price = "Price";
    String condition = "Condition";
    System.out.println(" ");
    System.out.println("                        Listed Items ");
    System.out.println("-----------------------------------------------------------");
    String header = String.format("%-15s %-15s %s ", name, price, condition);
    System.out.println(header);
    System.out.println("-----------------------------------------------------------");
    for(SaleItem item : passedInList){  // go through list and print out each object's properties
      String itemLine = String.format("%-17s $%-17d %d ", item.getName(), item.getStartPrice(), item.getCondition());
      System.out.println(itemLine);
    }
    System.out.println(" ");
  }
  public void finalReportReader(ArrayList<SaleItem> soldList, ArrayList<SaleItem> unsoldList){
    String name = "Name";
    String price1 = "Asking Price";
    String price2 = "Sold Price";
    String discount = "Discount";
    String condition = "Condition";
    System.out.println(" ");
    System.out.println("                          Sold Items ");
    System.out.println("-----------------------------------------------------------");
    String header = String.format("%-15s %-15s %-15s %s", name, price1, price2, discount);
    System.out.println(header);
    System.out.println("-----------------------------------------------------------");
    for(SaleItem item : soldList){  // go through list and print out each object's properties
      double disc = Math.floor(100 * (((double)item.getStartPrice()-(double)item.getEndPrice()) / (double)item.getStartPrice()));
      String itemLine = String.format("%-17s $%-17d $%-17d %.2f %%", item.getName(), item.getStartPrice(), item.getEndPrice(), disc);
      System.out.println(itemLine);
    }
    System.out.println(" ");
    System.out.println("                         Unsold Items ");
    System.out.println("-----------------------------------------------------------");
    header = String.format("%-15s %-15s %s ", name, price1, condition);
    System.out.println(header);
    System.out.println("-----------------------------------------------------------");
    for(SaleItem item : unsoldList){  // go through list and print out each object's properties
      String itemLine = String.format("%-17s $%-17d %d ", item.getName(), item.getStartPrice(), item.getCondition());
      System.out.println(itemLine);
    }
  
  
  }
  
  // public void finalReportReader(ArrayList<SaleItem> passedInList){
    // System.out.println("Final soldItemsList: ");
    // for(SaleItem item : passedInList){  // go through list and print out each object's properties
      // System.out.println("You sold: " + item.getName() + " for $" + item.getPrice());
    // }
  // }
  
  
  
  public ArrayList<ArrayList<SaleItem>> sellOrNot(ArrayList<SaleItem> stuffToSell){  // runs sale simulation on SaleItemsList and returns a new Arraylist  
    ArrayList<SaleItem> soldItemsList = new ArrayList<SaleItem>();
    ArrayList<SaleItem> notSoldItemsList = new ArrayList<SaleItem>();
    ArrayList<ArrayList<SaleItem>> listOlists = new ArrayList<ArrayList<SaleItem>>();
    int i = 0;
    String saleCycles = userIn.getUserInput("How many sale cycles? ");
    
    while (i < Integer.parseInt(saleCycles)){
      for(SaleItem item : stuffToSell){  // go through not stuffToSell and sort into two new lists sold and didn't sell 
        if(item.didISell()){
          soldItemsList.add(item);
        } // end if
      }//end forloop
      stuffToSell.removeAll(soldItemsList); // remove any items in the sold list from the stuffToSell list before next trip through loop
      i++;
      // // test code!!!!
      // System.out.println("cycle: " + i);
      // System.out.println("SOLD LIST");
      // for(SaleItem item : soldItemsList){  // go through list and print out each object's properties
        // System.out.print("You sold: " + item.getName() + ", " );
      // }
      // System.out.println(" ");
      
      // System.out.println("UNSOLD LIST");
      // for(SaleItem item : stuffToSell){  // go through list and print out each object's properties
        // System.out.print("Still listed: " + item.getName() +  ", ");
      // }
      // System.out.println(" ");
    // // end test code!!!  
    } // end while
    for(SaleItem item : soldItemsList){  // go through list and calculate any discounts taken
      item.soldPrice(); 
    }
    listOlists.add(soldItemsList);  //Put sold and unsold lists into a container to pass back
    listOlists.add(stuffToSell);
    return(listOlists);  // after list is built return it to caller
  } // end sellOrNot 
} // end MikeSale
