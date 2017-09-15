package com.shopping.goods;

public class Good implements Item {

	private String identity;
	private double price;
    private String description;
    
    public Good() {
	}
    public Good(String identity){
    	this.identity = identity;
    }
	
	public Good(String identity, String description, double price) {
		this.identity = identity;
		this.description = description;
        this.price = price;
    }
	
    public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	public double itemPrice() {
        return price;
    }

    public String description() {
        return description;
    }

    public double itemsPrice(int qty) {
        return price * ((double)qty);
    }

    @Override
	public String getIdentity() {
		return identity;
	}
    
    @Override
	public String toString() {
		return "Good [identity=" + identity + "]";
	}
}