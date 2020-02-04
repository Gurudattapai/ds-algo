package learn;

import java.util.HashSet;
import java.util.Set;

import learn.obj.ListNode;

public class LinkedListComponents817 {

	public int numComponents(ListNode head, int[] G) {
		
		if (head == null) {
			return 0;
		}
		
		Set<Integer> set = new HashSet<>();
		for (int i : G) {
			set.add(i);
		}
		
		int count = 0;
		ListNode cur = head;
		boolean prevConnected = false;
		while (cur != null) {
			if (set.contains(cur.val) && !prevConnected) {
				count++;
				prevConnected = true;
			} else if (!set.contains(cur.val)) {
				prevConnected = false;
			}
			cur = cur.next;
		}
		
		return count;
	}

	public static void main(String[] args) {

	}

}
