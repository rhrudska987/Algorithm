package Fibonacci_Chicken;

public class SelectionProblem {
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static int Selection(int[] arr, int left, int right, int k) {
		if (left==right)
			return (arr[left]);
		
		int pivot = (left + right) / 2;
		int high = left + 1;
		int low = right;
		
		swap(arr, pivot, left);
		while(high <= low) {
			while ((high <= right) && (arr[high] <= arr[left]))
				high++;
			while ((low >= left) && arr[low] >= arr[left])
				low--;
			if (high > low)
				break;
			swap(arr, high, low);
			high++; low--;
		}
		swap(arr, left, low);
		
		int small_group_size = low - left;
		if (k <= small_group_size)
			return Selection(arr, left, low-1, k);
		else if (k==small_group_size + 1)
			return (arr[low]);
		else
			return Selection(arr, low + 1, right, k - (small_group_size + 1));		
	}

	public static void main(String[] args) {
		int[] arr = {6,3,11,9,12,2,8,15};
		int k = 7;
		
		System.out.println(Selection(arr, 0, arr.length - 1, 7));
	}

}
