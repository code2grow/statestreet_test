package com.shopping.stratergy;

import java.util.Map;

import com.shopping.goods.Item;

public interface DiscountStratergy {
	public double applyDiscounts(Map<Item,Integer> cartitems);
} 
