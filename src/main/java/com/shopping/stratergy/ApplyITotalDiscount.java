package com.shopping.stratergy;

import java.util.Map;

import com.shopping.goods.Item;

public class ApplyITotalDiscount {

	private DiscountStratergy discountStratergy;
	public void setDiscountStratergy(DiscountStratergy discountStratergy) {
	    this.discountStratergy = discountStratergy;
	  }
	
	//use the strategy
	  public double applyITotalDiscount1(Map<Item,Integer> cartItems) {
		  return discountStratergy.applyDiscounts(cartItems);
	  }
}
