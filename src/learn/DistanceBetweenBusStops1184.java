package learn;

public class DistanceBetweenBusStops1184 {

	public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
		
		if (distance == null || distance.length == 0) {
			return 0;
		}
		
		if (start == destination) {
			return 0;
		}
		
		int clockWiseDistance = 0;
		
		int index = start;
		while (index != destination) {
			clockWiseDistance += distance[index];
			index++;
			if (index == distance.length) {
				index = 0;
			}
		}
		int antiClockWiseDistance = 0;
		index = start;
		boolean destReached = false;
		while (index != destination) {
			if (index == 0) {
				index = distance.length - 1;
				antiClockWiseDistance += distance[index];
				destReached = true;
				continue;
			}
			antiClockWiseDistance += distance[index];
			index--;
		}
		if (!destReached)
		antiClockWiseDistance += distance[index];
		
		return Math.min(clockWiseDistance, antiClockWiseDistance);

	}

	public static void main(String[] args) {
		System.out.println(distanceBetweenBusStops(new int [] {1,2,3,4}, 0, 2));
	}

}
