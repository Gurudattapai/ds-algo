package learn;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class ReverseSubstring1190 {

	public static String reverseParentheses(String s) {
		
		if (s == null || s.isEmpty()) {
			return "";
		}
		
		Map<Integer, Integer> map = new LinkedHashMap<>();
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else if (!stack.isEmpty() && s.charAt(i) == ')') {
				int open = stack.pop();
				map.put(open, i);
			}
		}
		
		StringBuilder sb = new StringBuilder(s);
		for (Integer key : map.keySet()) {
			int value = map.get(key);
			StringBuilder sbi = new StringBuilder(sb.substring(key+1, value));
			sbi.reverse();
			sb.replace(key+1, value, sbi.toString());
		}
		
		String ret = sb.toString();
		ret = ret.replace("(", "");
		ret = ret.replace(")", "");
		
		return ret;
	
	}

	public static void main(String[] args) {
		System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
	}

}
