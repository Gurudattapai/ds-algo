package learn;

import java.util.Stack;

import learn.obj.ListNode;

public class ReverseLinkedList92 {
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		}
		
		ListNode cur = head;
		ListNode prev = null;
		for (int i = 1; i < m; i++) {
			prev = cur;
			cur = cur.next;
		}
		
		Stack<ListNode> stack = new Stack<>();
		for (int i = m; i <= n; i++) {
			stack.add(cur);
			cur = cur.next;
		}
		
		while (!stack.isEmpty()) {
			ListNode last = stack.pop();
			if (prev != null) {
				prev.next = last;
			} else {
				head = last;
			}
			prev = last;
		}
		prev.next = cur;
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(5);
		System.out.println(reverseBetween(head, 1, 2));
	}

}
