package learn;

import learn.obj.ListNode;

public class BinaryToDecimal1290 {

	public int getDecimalValue(ListNode head) {
		
		if (head == null) {
			return 0;
		}
		
		ListNode cur = head;
		StringBuilder sb = new StringBuilder();
		while (cur != null) {
			sb.append(cur.val+"");
			cur = cur.next;
		}
		return Integer.parseInt(sb.toString(), 2);
	}

	public static void main(String[] args) {

	}

}
