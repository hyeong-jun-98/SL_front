package javaseapp.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public SetTest() {

	}//

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();

		set.add("파인애플");
		set.add("오렌지");
		set.add("키위");
		set.add("망고");
		set.add("사과");

		// 담겨진 과일 수 출력하기.
		System.out.println("size : " + set.size());

		// 순서없는 집합이므로 별도의; 도구를 이용한다. 이때 지원되는 도구들은 객체들을 일렬로 늘어트리는 기능을 가진 Iterator와
		// Enumeration을 이용한다
		// 담겨진 과일 출력하기
		Iterator<String> it = set.iterator(); // 일렬로 다시 담는다.

		while (it.hasNext()) { // 요소가 존재하는 동안  (값이 존재하면 true)
			
			String name = it.next();  // next()는 지나가면서 값을 반환해준다
			System.out.println(name);

		}

	}

}
