package learn;

import java.util.Stack;

public class RemoveAllAdjDuplicates1209 {

	public static String removeDuplicates(String s, int k) {

		if (k == 0 || s.length() < k) {
			return s;
		}

		Stack<IndexVsSize> stack = new Stack<>();
		stack.add(new IndexVsSize(0, 1));
		StringBuilder sb = new StringBuilder(s);
		int index = 1;
		while (index < sb.length()) {
			if (!stack.isEmpty()) {
				IndexVsSize peek = stack.peek();
				if (sb.charAt(peek.startIndex) == sb.charAt(index)) {
					int count = peek.size;
					if (count + 1 == k) {
						sb.delete(peek.startIndex, index + 1);
						stack.pop();
						index = peek.startIndex;
					} else {
						index++;
						peek.size++;
					}
					continue;
				}
			}
			stack.push(new IndexVsSize(index++, 1));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));

	}

}

class IndexVsSize {
	public int startIndex;
	public int size;

	public IndexVsSize(int startIndex, int size) {
		this.startIndex = startIndex;
		this.size = size;
	}
}
