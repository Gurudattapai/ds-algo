package learn;

import learn.obj.ListNode;

public class Add2Num445 {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		int m = 0;
		int n = 0;
		
		ListNode cur = l1;
		while (cur != null) {
			m++;
			cur = cur.next;
		}
		
		cur = l2;
		while (cur != null) {
			n++;
			cur = cur.next;
		}
		cur = null;
		int result;
		int diff = Math.abs(m - n);
		ListNode res = null;
		ListNode [] head = new ListNode[1]; 
		if (m > n) {
			int index = 0;
			cur = l1;
			while (index < diff) {
				cur = cur.next;
				index++;
			}
			result = add(cur, l2, res, head);
			result = addRest(l1, cur, res, result, head);
		} else if (n > m) {
			int index = 0;
			cur = l2;
			while (index < diff) {
				cur = cur.next;
				index++;
			}
			result = add(l1, cur, res, head);
			result = addRest(l2, cur, res, result, head);
		} else {
			result = add(l1, l2, res, head);
		}
		if (result >= 10) {
			ListNode l = new ListNode(1);
			l.next = head[0];
			head[0] = l;
		}
		return head[0];
	}
	
	public static int addRest(ListNode listNode, ListNode index, ListNode res, int last, ListNode [] head) {
		if (listNode == index) {
			return last;
		}
		int result = addRest(listNode.next, index, res, last, head);
		if (result >= 10) {
			result = 1 + listNode.val;
		} else {
			result = listNode.val;
		}
		ListNode l = new ListNode(result % 10);
		if (head[0] == null) {
			head[0] = l;
		} else {
			l.next = head[0];
			head[0] = l;
		}
		//head[0] = res;
		return result;
	}
	
	public static int add(ListNode l1, ListNode l2, ListNode res, ListNode [] head) {
		if (l1 == null && l2 == null) {
			return 0;
		}
		
		int result = add(l1.next, l2.next, res, head);
		if (result >= 10) {
			result = 1 + l1.val + l2.val;
		} else {
			result = l1.val + l2.val;
		}
		ListNode l = new ListNode(result % 10);
		if (head[0] == null) {
			head[0] = l;
		} else {
			l.next = head[0];
			head[0] = l;
		}
		//head[0] = res;
		return result;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		//l1.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		ListNode l3 = addTwoNumbers(l1, l2);
		System.out.println(l3.val);
	}

}
