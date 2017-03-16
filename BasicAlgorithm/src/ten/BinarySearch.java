package ten;

import java.util.Arrays;

public class BinarySearch {
	
	public static int search(int[] number, int des) {
		if(number == null || number.length== 0) {
			return -1;
		}
		int low = 0;
		int high = number.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (number[mid] < des) {
				low = mid + 1;
			} else if (number[mid] > des) {
				high = mid - 1;
			} else { 
				return mid; 
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] number = { 23, 5, 2, 1, 44, 77, 90, 221, 25, 8 };
		Arrays.sort(number);
		System.out.println(search(number, 23));
	}

}
