package Fibonacci_Chicken;

import java.util.Scanner;

public class Quick_Sorting_1k {
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void get_median(int[] arr, int left, int median, int right) {
		if(arr[left] > arr[median])
			swap(arr, left, median);
		if(arr[median] > arr[right - 1])
			swap(arr, median, right - 1);
		if(arr[left] > arr[median])
			swap(arr, left, median);
	}
	
	static void quick_sorting(int[] arr, int left, int right) {
		int median = (left + right) / 2;
		int L = left;
		int R = right;
		get_median(arr, left, median, right); //�Ǻ����� left�� right�� �߰� ������ �ʱ�ȭ
		int pivot = arr[median];
		while(L <= R) {  //L���� R���� �������� Ȯ��
			while (arr[L] < pivot) //�Ǻ����� ���� �����̸� L���� ���������� �̵�, ���� ���ų� ũ�� ����
				L++;
			while (arr[R] > pivot) //�Ǻ����� ū �����̸� R���� �������� �̵�, ���� ���ų� ������ ����
				R--;
			if (L <= R)			   //L���� R���� �������� Ȯ��
			{
				swap(arr, L, R); //������ ��ġ�� ���ڸ� ��ȯ ��, L���� R���� ��ġ�� ���� �̵�
				L++; R--;
			}
		}
		
		if (L < right)  //�Ǻ����� ū �׷��� arr[L] ~ arr[right]�� ��������� ȣ��, ���⼭ L�� pivot + 1�̴�
			quick_sorting(arr, L, right);
		if (left < R)   //�Ǻ����� ���� �׷��� arr[left] ~ arr[R]�� ��������� ȣ��, ���⼭ R�� pivot - 1�̴�
			quick_sorting(arr, left, R);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt(); //ó�� ���� ��ü ������ ����
		int[] arr = new int[size]; //�迭 ����
		for(int i=0; i < size; i++) { //�ݺ����� ���� n���� ���� �Է� �ޱ�
			arr[i] = sc.nextInt();
		}
		
		quick_sorting(arr, 0, size - 1); //�� ���� ����
		
		for(int i=0; i < size; i++) //���ĵ� �� ���
			System.out.println(arr[i]);
		sc.close();
	}
}
