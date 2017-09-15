package goodsshopping;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before; 
import org.junit.Test;

import com.shopping.goods.Item;
import com.shopping.util.IdentityUtil;

public class TestAddCart {

	private IdentityUtil util;
	private String input;
	
	@Before
    public void init() {
        util= new IdentityUtil();
        input= new String("");
    }

    @Test
    public void filterItemsTest() {
    	Map<Item, Integer> map = new HashMap<Item,Integer>();
    	assertNotNull(util.identiyItems(input));
        for(Item item: util.identiyItems(input).keySet()){
        	assertTrue("Checks it collects only A,B,C as mentioned in the catalog.","A".equals(item.getIdentity()) ||"B".equals(item.getIdentity())
        			||"C".equals(item.getIdentity()));
        }
    }
}
