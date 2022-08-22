package javaseapp.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//
public class MapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("a", "apple");
		map.put("b", "banana");
		map.put("c", "cocoa");
		map.put("m", "mango");
		map.put("p", "pineapple");
		
		System.out.println("size : " + map.size());
		
		Set <String> set = map.keySet();		// map을 set으로 바꿔주고 (반환형이 Set이기 때문.)
	
		Iterator<String> it = set.iterator();		// set을 Iterator로 바꿔주고
		
		while(it.hasNext() ) {
			String key = it.next();			// next()를 이용하여 하나씩 지나가면서 key에 넣어주고 출력
			
			System.out.println(map.get(key));		// 데이터가 있는 맵에서 키를 가져온다.
			
		}
	
	
	
	
	
	}


}
