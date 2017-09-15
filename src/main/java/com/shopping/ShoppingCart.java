package com.shopping;

import java.util.LinkedHashMap;
import java.util.Map;

import com.shopping.goods.Item;

public class ShoppingCart {

	private Map<Item, Integer> cartItems;
	{cartItems = new LinkedHashMap<Item, Integer>();}
	public Map<Item, Integer> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<Item, Integer> cartItems) {
		this.cartItems = cartItems;
	}

	public void add(Item item) {
		addItems(item, 1);
	}

	public void addItems(Item item, int count) {
		int curQty = 0;
		if (cartItems.containsKey(item)) {
			curQty = cartItems.get(item);
		}
		cartItems.put(item, curQty + count);
	}
	
	@Override
	public String toString() {
//		return "ShoppingCart [cartItems=" +  + "]";
			 String line = "--------------------------------\n";
		        StringBuffer sb = new StringBuffer();
		        sb.append(line);
		        sb.append("cartItems - ");
		        for (Item each : cartItems.keySet()) {
		            sb.append(" "+String.format(""+each.getIdentity())+ ": ");
		            sb.append(cartItems.get(each)+",");
		        }
		        sb.append("\n"+line);
		      return sb.toString();
	}

	public void remove(Item item) {
		removeItems(item, 1);
	}
	
	public void removeItems(Item item, int count) {
		if (cartItems.get(item) != null) {
			Integer itemscount = cartItems.get(item).intValue();
			if (itemscount > 1) {
				cartItems.put(item, itemscount - 1);
			} else {
				cartItems.remove(item);
			}
		}
	}
	
	
}
