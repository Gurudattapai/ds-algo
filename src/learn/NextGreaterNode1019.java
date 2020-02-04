package learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import learn.obj.ListNode;

public class NextGreaterNode1019 {
	
	public int[] nextLargerNodes(ListNode head) {
		
		if (head == null) {
			return new int [0];
		}
		
		List<Integer> list = new ArrayList<>();
		ListNode cur = head;
		while (cur != null) {
			list.add(cur.val);
			cur = cur.next;
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int [] arr = new int [list.size()];
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= list.get(stack.peek())) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
					int index = stack.pop();
					arr[index] = list.get(i);
				}
				stack.push(i);
			}
		}
		return arr;
	}

	public static void main(String[] args) {

	}

}
