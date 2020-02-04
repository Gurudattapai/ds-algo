package learn;

public class FlattenMultiLevelDuoblyLinkedList430 {

	public DoublyLinkedListNode flatten(DoublyLinkedListNode head) {

		if (head == null) {
			return null;
		}
		flattenAndGetTail(head);
		return head;
	}

	public DoublyLinkedListNode flattenAndGetTail(DoublyLinkedListNode head) {

		if (head == null) {
			return null;
		}

		DoublyLinkedListNode cur = head;
		while (cur.next != null) {
			while (cur.next != null && cur.child == null) {
				cur = cur.next;
			}
			if (cur.child != null) {
				DoublyLinkedListNode next = cur.next;
				DoublyLinkedListNode child = cur.child;
				cur.next = child;
				child.prev = cur;
				cur.child = null;
				DoublyLinkedListNode tail = flattenAndGetTail(child);
				tail.next = next;
				next.prev = tail;
				cur = cur.next;
			}
		}
		return cur;
	}

	public static void main(String[] args) {

	}

}

class DoublyLinkedListNode {
	public int val;
	public DoublyLinkedListNode prev;
	public DoublyLinkedListNode next;
	public DoublyLinkedListNode child;
}
