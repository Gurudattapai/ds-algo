package learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack895 {

	public static void main(String[] args) {
		FreqStack s = new FreqStack();
		s.push(1);
		s.push(0);
		s.push(0);
		s.push(1);
		s.push(5);
		s.push(4);
		s.push(1);
		s.push(5);
		s.push(1);
		s.push(6);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}

class FreqStack {
    
    Map<Integer, Stack<Integer>> indexMap;
    int currentIndex = 0;

    public FreqStack() {
        indexMap = new HashMap<>();
    }
    
    public void push(int x) {
    	currentIndex += 1;
        if (!indexMap.containsKey(x)) {
        	indexMap.put(x, new Stack<>());
        }
        indexMap.get(x).push(currentIndex);
    }
    
    public int pop() {
        List<Map.Entry<Integer, Stack<Integer>>> list = new ArrayList<>(indexMap.entrySet());
    	
    	int maxVal = list.get(0).getKey();
        int maxCount = list.get(0).getValue().size();
        int maxIndex = list.get(0).getValue().peek();
        
        for (int i = 1; i < list.size(); i++) {
        	if (list.get(i).getValue().size() > maxCount) {
        		maxVal = list.get(i).getKey();
        		maxCount = list.get(i).getValue().size();
        		maxIndex = list.get(i).getValue().peek();
        	} else if (list.get(i).getValue().size() == maxCount) {
        		if (maxIndex < list.get(i).getValue().peek()) {
        			maxVal = list.get(i).getKey();
            		maxCount = list.get(i).getValue().size();
            		maxIndex = list.get(i).getValue().peek();
        		}
        	}
        }
    	
        indexMap.get(maxVal).pop();
        if (indexMap.get(maxVal).isEmpty()) {
        	indexMap.remove(maxVal);
        }
        return maxVal;
    }
}
