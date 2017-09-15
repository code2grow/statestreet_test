package com.shopping.util;

import java.util.HashMap;
import java.util.Map;

import com.shopping.goods.Good;
import com.shopping.goods.Item;

public class IdentityUtil {
	//filters out items A,B C only
	public Map<Item, Integer> identiyItems(String s) {
		 Map<Character, Integer> goodsMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (c.equals('A') || c.equals('B') || c.equals('C')) {
				Integer oldCount = goodsMap.get(c);
				if (oldCount == null) {
					oldCount = 0;
				}
				goodsMap.put(c, oldCount + 1);
			}
		}
		Map<Item, Integer> itemsMap = new HashMap<Item, Integer>();
		for (Character c:goodsMap.keySet()){
			Good item = new Good();
			item.setIdentity(c.toString());
			itemsMap.put(item, goodsMap.get(c));
		}
		return itemsMap;
	}
	
}

