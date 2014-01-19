import java.util.ArrayList;

public class TestMikeSale{  // Get user input to pass to SaleItem when it's constructed
                                     // Then print out some stuff to see it worked
  
	public static void main(String[] args){  
  
  MikeSale currentMikeSale = new MikeSale();  // make an instance of MikeSale
  ArrayList<SaleItem> beforeSale = new ArrayList<SaleItem>();
  beforeSale = currentMikeSale.makeSaleItemsList(); // make an Arraylist of SaleItems passed back from MikeSale
  currentMikeSale.notSoldListReader(beforeSale); // run the list through listreader
  ArrayList<ArrayList<SaleItem>> soldOrNot = new ArrayList<ArrayList<SaleItem>>(); // container for sold and not sold lists
  soldOrNot = currentMikeSale.sellOrNot(beforeSale); // holds the results of having the sale and returning a sold list and an unsold list
  currentMikeSale.soldListReader(soldOrNot.get(1));
  currentMikeSale.notSoldListReader(soldOrNot.get(0));
   
  } // end main
} // end TestMikeSale
