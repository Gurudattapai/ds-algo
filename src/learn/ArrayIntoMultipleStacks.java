package learn;

import java.util.EmptyStackException;

public class ArrayIntoMultipleStacks {
		
	int arraySize = 0;
	int [] valuesArray;
	int [] individualArraySize = {0,0,0};
	int firstTop = 0;
	int secondTop = 0;
	int thirdTop = 0;
	
	public ArrayIntoMultipleStacks(int arraySize) {
		this.arraySize = arraySize;
		valuesArray = new int[arraySize];
		secondTop = arraySize - arraySize/3 -1;
		thirdTop = arraySize - (2 * arraySize/3) - 1;
	}
	
	public void push(int stackToPut, int value) {
		if(individualArraySize[stackToPut] == arraySize/3) {
			throw new StackOverflowError();
		}
		if(stackToPut == 0) {
			valuesArray[firstTop] = value;
			firstTop++;
		} else if(stackToPut == 1) {
			valuesArray[secondTop] = value;
			secondTop++;
		} else if(stackToPut == 2) {
			valuesArray[thirdTop] = value;
			thirdTop++;
		}
		individualArraySize[stackToPut] = individualArraySize[stackToPut] + 1;
	}
	
	public void pop(int stackToRemoveFrom) {
		if(individualArraySize[stackToRemoveFrom] == 0) {
			throw new EmptyStackException();
		}
		if(stackToRemoveFrom == 0) {
			valuesArray[firstTop] = 0;
			firstTop--;
		} else if(stackToRemoveFrom == 1) {
			valuesArray[secondTop] = 0;
			secondTop--;
		} else if(stackToRemoveFrom == 2) {
			valuesArray[thirdTop] = 0;
			thirdTop--;
		}
		individualArraySize[stackToRemoveFrom] = individualArraySize[stackToRemoveFrom] - 1;
	}
	
	public int peek(int stackToPeek) {
		if(individualArraySize[stackToPeek] == 0) {
			throw new EmptyStackException();
		}
		if(stackToPeek == 0) {
			return valuesArray[firstTop];
		} else if(stackToPeek == 1) {
			return valuesArray[secondTop];
		} else if(stackToPeek == 2) {
			return valuesArray[thirdTop];
		}
		return 0;
	}
	
	public boolean isEmpty(int stack) {
		return individualArraySize[stack] == 0;
	}
	

	public static void main(String[] args) {
		

	}

}
