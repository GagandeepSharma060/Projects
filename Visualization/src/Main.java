import java.util.*;
public class Main{

public static void display(ArrayList<Double> sales , ArrayList<Double> cost){
	
	//Column headers
	System.out.println("SALE PRICE      COST        PROFIT");
	double totalSale=0;
	double totalCost=0;
	double totalProfit =0;
	
	//Displaying the data
	for(int i=0;i<sales.size();i++)
	{
		
		double profit = sales.get(i)-cost.get(i);
		System.out.println(sales.get(i)+"            "+cost.get(i)+"        " +(float)profit);
		
		//updating totalSale, totalCost and totalProfit
		totalSale+=sales.get(i);
		totalCost+=cost.get(i);
		totalProfit+=profit;
	}
	
	System.out.println("--------------------------------------------");
	//Displaying the column totals
	System.out.println(totalSale+"            "+totalCost+"        " +totalProfit);
	
	return ;
}
	
public static void main(String[] args) {
	
  //ArrayList for sales price data
  ArrayList<Double> sales = new ArrayList<>();
  sales.add(3.55);
  sales.add(12.34);
  sales.add(2.67);
  sales.add(4.99);
  sales.add(15.95);
  
  //ArrayList for cost data
  ArrayList<Double> cost = new ArrayList<>();
  cost.add(3.27);
  cost.add(10.61);
  cost.add(2.46);
  cost.add(4.59);
  cost.add(13.72);
  
  //Calling the display method
  display(sales,cost);

	
	
}

}
