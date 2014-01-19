//***************SaleItem******************************
// a class for items that know their name, price and condition.
// two methods can be called on them to see if they sold and if there was any haggling

public class SaleItem{  
  
  private String name;
  private int price;
  private int condition;
  
  public SaleItem(String itemName, int itemPrice, int itemConditon){  // constructor to set states for each object
    name = itemName;
    price = itemPrice;
    condition = itemConditon;
  }
  
  public String getName(){
    return name;
  }
  public int getPrice(){
    return price;
  }
  public int getCondition(){
    return condition;
  }
  
  
  public boolean didISell(){  //generate a random value btwn 1-10 If less than 5 it didn't sell.  Return boolean either way.
    int chance = 1 + (int)(Math.random() * 10);
    //System.out.println("Chance =  " + chance);
    if (chance < 6){
      return false;
    }else{
      return true;
    }
  }

  public int soldPrice(){ //get the condition, use it to calculate if there was haggling. Return sold price. 
    int myCondition = this.getCondition();
   // System.out.println("Condition = " + myCondition);
    int startPrice = this.getPrice();
    // System.out.println("Price = " + startPrice);
    int endPrice = startPrice;
    double haggleChance = Math.random();
    
    if (myCondition < 4){  //if condition is 1-3 100% chance price lowered btwn 40-70%
      endPrice = setHagglePrice(4, 7, startPrice);
    }else if (myCondition > 3 && myCondition < 7){ // if condition is 4-6 50% chance price lowered 20-40%
      if (haggleChance > .5){
        endPrice = setHagglePrice(2, 4, startPrice);
      }
    }else if (myCondition > 7){ // if condition is 7-10 20% chance price lowered 10-30%
      if (haggleChance <.5){
        endPrice = setHagglePrice(1, 3, startPrice);
      }
    }else{
      endPrice = startPrice;
    }
    
    return endPrice;
  }
  
  public int setHagglePrice(int min, int max, int startPrice){
    int myStartPrice = startPrice;
    int myMin = min;
    int myMax = max;

    double factor = myMin + (int)(Math.random() * ((myMax - myMin) +1)); // get a factor in the range of the min/max

    float myEndPrice = myStartPrice - (float)(myStartPrice * (factor*.1));
    return (int)myEndPrice;
  
  }
}