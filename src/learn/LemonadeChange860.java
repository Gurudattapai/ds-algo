package learn;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange860 {

	public static boolean lemonadeChange(int[] bills) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < bills.length; i++) {
			if (bills[i] == 5) {
				map.put(5, map.get(5) == null ? 1 : map.get(5) + 1);
			} else if (bills[i] == 10) {
				if (map.get(5) == null || !(map.get(5) > 0)) {
					return false;
				}
				map.put(10, map.get(10) == null ? 1 : map.get(10) + 1);
				map.put(5, map.get(5) - 1);
			} else {
				if (map.get(5) != null && map.get(10) != null) {
					if (map.get(10) > 0 && map.get(5) > 0) {
						map.put(5, map.get(5) - 1);
						map.put(10, map.get(10) - 1);
						continue;
					} else if (map.get(5) > 2){
						map.put(5, map.get(5) - 3);
						continue;
					} else {
						return false;
					}
				} else if (map.get(5) == null) {
					return false;
				} else {
					if (map.get(5) < 3) {
						return false;
					} else {
						map.put(5, map.get(5) - 3);
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(lemonadeChange(new int [] {5,5,5,5,20,20,5,5,20,5}));
	}

}
