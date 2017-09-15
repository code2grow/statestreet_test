package goodsshopping;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.shopping.goods.Good;
import com.shopping.goods.Item;
import com.shopping.stratergy.DiscountStratergy;
import com.shopping.stratergy.ItemWiseStratergy;

public class TestDiscountStratergy {
	
	private DiscountStratergy strat;
	private Map<Item,Integer> goodsMap;
	@Before
    public void init() {
       strat= new ItemWiseStratergy();
       goodsMap =  new HashMap<Item,Integer>();
         Good itA= new Good();
         itA.setIdentity("A");
         goodsMap.put(itA,7);
         Good itB= new Good();
         itB.setIdentity("B");
         goodsMap.put(itB,8);
         Good itC= new Good();
         itC.setIdentity("C");
         goodsMap.put(itC,9);
    }

	@Test
	public void testDiscounts(){
//		System.out.println(strat.applyDiscounts(goodsMap));
		assertEquals(232.75,strat.applyDiscounts(goodsMap),0.001);
		
	}

}
