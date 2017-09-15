package com.shopping.stratergy;

import java.util.Map;

import com.shopping.goods.Item;

public class ItemWiseStratergy implements DiscountStratergy{

	public double applyDiscounts(Map<Item,Integer> cartitems){
			double totalCost=0;
			int goodCount=0;
			for(Item it: cartitems.keySet()){
				String s = it.getIdentity();
				switch(s){
				  case "A":
					    goodCount = cartitems.get(it);
						if (isBetween(goodCount, 1,3)) {
						  totalCost+= 10*goodCount;
						} else if (isBetween(goodCount, 4, 7)) {
							 totalCost+=  9*goodCount;
						} else if(goodCount>=8){
							 totalCost+=  8*goodCount;
						}
						break;
				  case "B":
					  goodCount = cartitems.get(it);
						if (isBetween(goodCount,1,5)) {
							 totalCost+=  20*goodCount;
						} else if(goodCount>=6){
							 totalCost+=  16*goodCount;
						}
						break;
				  case "C":
					  goodCount = cartitems.get(it);
					        totalCost+=  6*goodCount;
				        break;		
				 }
				}
			     if(cartitems.size()==3){
			    	 totalCost = totalCost -(5*totalCost/100);
			     }
			return totalCost;
			}
	
	 private static boolean isBetween(int x, int lower, int upper) {
//		  return ( x.compareTo(lower)==0 && x.compareTo(lower)==1 && x.compareTo(upper)==0 && x.compareTo(upper)==-1);
   	  return lower <= x && x <= upper;
		}
	
}
