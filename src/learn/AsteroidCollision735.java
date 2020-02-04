package learn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision735 {

	public static int[] asteroidCollision(int[] asteroids) {
		
		if (asteroids == null || asteroids.length == 0) {
			return new int [0];
		}
		
		List<Integer> remaining = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		stack.push(asteroids[0]);
		for(int i = 1; i < asteroids.length; i++) {
			if (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
				if (!stack.isEmpty() && Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
					stack.pop();
					continue;
				}
				boolean needToAdd = true;
				while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
					if (!stack.isEmpty() && Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
						stack.pop();
						needToAdd = false;
						break;
					}
					if (Math.abs(stack.peek()) < Math.abs(asteroids[i])) {
						stack.pop();
						continue;
					}
					if (Math.abs(stack.peek()) > Math.abs(asteroids[i])) {
						needToAdd = false;
						break;
					}
				}
				if (needToAdd) {
					stack.push(asteroids[i]);
				}
			} else {
				stack.push(asteroids[i]);
			}
		}
		while (!stack.isEmpty()) {
			remaining.add(0, stack.pop());
		}
		
		int [] arr = new int [remaining.size()];
		for (int i = 0; i < remaining.size(); i++) {
			arr[i] = remaining.get(i);
		}
		return arr;

	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(asteroidCollision(new int [] {-2, -2, 1, -2})));
	}

}
