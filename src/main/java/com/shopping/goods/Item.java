package com.shopping.goods;

public interface Item {
	String getIdentity();
    double itemPrice();
    double itemsPrice(int qty);
    String description();
}
