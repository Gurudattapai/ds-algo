package learn;

import java.util.ArrayList;
import java.util.List;

import learn.obj.ListNode;

public class ConvertSortedListToBST109 {

	public TreeNode sortedListToBST(ListNode head) {
		
		if (head == null) {
			return null;
		}
		
		List<Integer> list = new ArrayList<>();
		ListNode cur = head;
		while (cur != null) {
			list.add(cur.val);
			cur = cur.next;
		}
		
		return convert(list, 0, list.size()-1);

	}

	private TreeNode convert(List<Integer> list, int start, int end) {
		if (start > end) {
			return null;
		}
		
		if (start == end) {
			return new TreeNode(list.get(start));
		}
		
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(list.get(mid));
		TreeNode left = convert(list, start, mid-1);
		TreeNode right = convert(list, mid+1, end);
		root.left = left;
		root.right = right;
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
