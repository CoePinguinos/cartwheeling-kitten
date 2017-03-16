package ten;
public class QuickSort {
	static void quickSort(int n[], int left, int right) {
		int k;
		if (left < right) {
			k =   partition(n, left, right);
			quickSort(n, left, k - 1);
			quickSort(n, k + 1, right);
		}
	}
	
	static int partition(int n[], int left, int right) {
		int pivot = n[left];
		while (left <  right) {
			while (left < right && n[right] >= pivot) {
				right--;
			}
			if (left < right) {
				n[left++] = n[right]; 
			}
			while (left < right && n[left] <= pivot) {
				left++;
			}
			if (left < right) {
				n[right--] = n[left];
			} 
		}
		n[left] = pivot;
		return left;
	}
	public static void main(String[] args) {
		int[] n={ 2,45,23,75,8,71,34,90,0,-5};
		quickSort(n, 0, n.length - 1);
		for (int i : n) {
			System.out.println(i);
		}
	}
}