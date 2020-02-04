package learn;

import java.util.Stack;

public class LongestAbsoluteFilePath388 {

	public static int lengthLongestPath(String input) {
		
		if (input == null || input.length() == 0) {
			return 0;
		}
		
		if (input.indexOf(".") < 0) {
            return 0;
        }
		String [] arr = input.split("\n");
		StringBuilder sb = new StringBuilder(arr[0]);
		Stack<String> stack = new Stack<>();
		String currentDelimiter = "\t";
		int maxLength = arr[0].length();
		int curindex = 1;
		while(curindex < arr.length) {
			String currentString = arr[curindex];
			if (currentString.indexOf(currentDelimiter) < 0) {
				int currentLength = sb.toString().length();
				maxLength = Math.max(maxLength, currentLength);
				int index = sb.indexOf(stack.pop());
				sb.delete(index - 1, sb.length());
				currentDelimiter = currentDelimiter.substring(0, currentDelimiter.length() - 1);
			} else {
				String temp = currentString.replace(currentDelimiter, "");
				sb.append("/").append(temp);
				currentDelimiter = currentDelimiter + "\t";
				stack.push(temp);
				curindex++;
			}
		}
		maxLength = Math.max(maxLength, sb.toString().length());
		
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(lengthLongestPath("dir\n\t\tfile.txt"));
	}

}
