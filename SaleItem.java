//***************SaleItem******************************
// a class for items that know their name, price and condition.
// two methods can be called on them to see if they sold and if there was any haggling

public class SaleItem{  
  
  private String name;
  private int startPrice;
  private int endPrice;
  private int condition;
  
  public SaleItem(String itemName, int itemPrice, int itemConditon){  // constructor to set states for each object
    name = itemName;
    startPrice = itemPrice;
    endPrice = itemPrice;
    condition = itemConditon;
  }
  
  public String getName(){
    return name;
  }
  public int getStartPrice(){
    return startPrice;
  }
  public int getEndPrice(){
    return endPrice;
  }
  public void setPrice(int newPrice){
    endPrice = newPrice;
  }
  public int getCondition(){
    return condition;
  }
  
  public boolean didISell(){  //generate a random value btwn 1-10. If less than 5 it didn't sell.  Return boolean either way.
    int chance = 1 + (int)(Math.random() * 10);
    if (chance < 6){
      return false;
    }else{
      return true;
    }
  }// end didISell

  public void soldPrice(){ //get the condition, use it to calculate if there was haggling. Set sold price. 
    int myCondition = this.getCondition();
    int endPrice = this.getEndPrice();
    //int endPrice = startPrice;
    double haggleChance = Math.random();
    
    if (myCondition < 4){  //if condition is 1-3 100% chance price lowered btwn 40-70%
      endPrice = setHagglePrice(4, 7, endPrice);
    }else if (myCondition > 3 && myCondition < 7){ // if condition is 4-6 50% chance price lowered 20-40%
      if (haggleChance > .5){
        endPrice = setHagglePrice(2, 4, endPrice);
      }
    }else if (myCondition > 7){ // if condition is 7-10 20% chance price lowered 10-30%
      if (haggleChance <.5){
        endPrice = setHagglePrice(1, 3, endPrice);
      }
   // }//else{
      //endPrice = startPrice;
    }// end outer if
    this.setPrice(endPrice);
  }// end soldPrice
  
  public int setHagglePrice(int min, int max, int startPrice){  // helper method to calculate price based on min/max passed by calling method
    int myStartPrice = startPrice;
    int myMin = min;
    int myMax = max;

    double factor = myMin + (int)(Math.random() * ((myMax - myMin) +1)); // get a factor in the range of the min/max

    float myEndPrice = myStartPrice - (float)(myStartPrice * (factor*.1));
    return (int)myEndPrice;
  
  } // end setHagglePrice
} // end SaleItem class