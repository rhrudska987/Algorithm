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
		get_median(arr, left, median, right); //피봇값을 left와 right의 중간 값으로 초기화
		int pivot = arr[median];
		while(L <= R) {  //L값과 R값의 교차여부 확인
			while (arr[L] < pivot) //피봇보다 작은 숫자이면 L값을 오른쪽으로 이동, 값이 같거나 크면 정지
				L++;
			while (arr[R] > pivot) //피봇보다 큰 숫자이면 R값을 왼쪽으로 이동, 값이 같거나 작으면 정지
				R--;
			if (L <= R)			   //L값과 R값의 교차여부 확인
			{
				swap(arr, L, R); //정지된 위치의 숫자를 교환 후, L값과 R값의 위치를 각각 이동
				L++; R--;
			}
		}
		
		if (L < right)  //피봇보다 큰 그룹인 arr[L] ~ arr[right]을 재귀적으로 호출, 여기서 L은 pivot + 1이다
			quick_sorting(arr, L, right);
		if (left < R)   //피봇보다 작은 그룹인 arr[left] ~ arr[R]을 재귀적으로 호출, 여기서 R은 pivot - 1이다
			quick_sorting(arr, left, R);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt(); //처음 줄은 전체 숫자의 개수
		int[] arr = new int[size]; //배열 생성
		for(int i=0; i < size; i++) { //반복문을 통해 n개의 숫자 입력 받기
			arr[i] = sc.nextInt();
		}
		
		quick_sorting(arr, 0, size - 1); //퀵 정렬 실행
		
		for(int i=0; i < size; i++) //정렬된 값 출력
			System.out.println(arr[i]);
		sc.close();
	}
}
