package learn;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	
	private static final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) throws InterruptedException {	
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 1);
		map.put(4, 1);
		map.put(5, 1);
		map.put(6, 1);
		map.put(7, 1);
		map.put(8, 1);
		map.put(9, 1);
		map.put(10, 1);
		map.put(11, 1);
		map.put(12, 1);
		map.put(13, 1);
		map.put(14, 1);
		map.put(15, 1);
		map.put(16, 1);	
		
		Thread t1 = new Thread() {
			public void run() {
				for(int i=0; i<20; i++) {
					if(i%2==0) {
						System.out.println("Removing " + i);
						map.remove(i);
					}
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				for(int i=0; i<20; i++) {
					if(i%2!=0) {
						System.out.println("Removing " + i);
						map.remove(i);
					}
				}
			}
		};
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.print(map);
	}

}
