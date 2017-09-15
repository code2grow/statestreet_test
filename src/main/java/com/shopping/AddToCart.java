package com.shopping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.shopping.stratergy.ApplyITotalDiscount;
import com.shopping.stratergy.DiscountStratergy;
import com.shopping.stratergy.ItemWiseStratergy;
import com.shopping.util.IdentityUtil;

public class AddToCart {
	private ShoppingCart shopingCart;
	private IdentityUtil identityUtil;
	private ApplyITotalDiscount discount;
	public ApplyITotalDiscount getDiscount() {
		return discount;
	}
	{
		shopingCart = new ShoppingCart();
		identityUtil = new IdentityUtil();
		discount = new ApplyITotalDiscount();
	}
	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.print("Enter cart with ItemType A,B,C - We will provide the total cost : ");
				String input = br.readLine();
				if ("q".equals(input)) {
					System.out.println("Exited Console!- No cart enteries.");
					System.exit(0);
				}
				AddToCart addCart= new AddToCart();
				addCart.setGoodsMap(input);
				System.out.println(addCart.getShopingCart());
				addCart.setDiscount(new ItemWiseStratergy());
				double totalCost = 0;
				if(addCart.getShopingCart().getCartItems()!=null){
				totalCost = addCart.getDiscount().applyITotalDiscount1(addCart.getShopingCart().getCartItems());}
				
				System.out.println("Please pay "+totalCost+"$.");
				System.out.println("_______________________\n");
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {br.close();} 
				catch (IOException e) {e.printStackTrace();}
			}
		}
	}
	
	public ShoppingCart getShopingCart() {
		return shopingCart;
	}

	public void setShopingCart(ShoppingCart shopingCart) {
		this.shopingCart = shopingCart;
	}

	private void setGoodsMap(String s) {
		shopingCart.setCartItems(identityUtil.identiyItems(s));
	}
	
	private void setDiscount(DiscountStratergy s){
		discount.setDiscountStratergy(s);
	}
	
	
}
