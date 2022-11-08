package algorithm;

import java.util.Scanner;

public class Knapsack_DP {

	public static int knapsack_DP(int nums, int total_capacity, int[][] objects) {
		//������ �뷮�� 1�� �÷����鼭 ������ ���
		int capacity[][] = new int[nums + 1][total_capacity + 1]; 
		int answer = 0;
		for(int i=1; i<=nums; i++) { //������ 1���� n���� �ϳ��� ���
			for(int j=1; j<=total_capacity; j++) { //�ӽ� �뷮�� 1���� total_capacity���� ����
				if(objects[i][1] > j) //������ ���԰� �ӽ� �賶 �뷮�� �ʰ��ϸ�
					capacity[i][j] = capacity[i-1][j]; //���� i�� ��ġ�� ���� i-1���� ������� ���� �ִ� ��ġ�� �ȴ�. 
				else { //������ ���԰� �ӽ� �賶 �뷮�� �ʰ����� �ʴ� ���
					if(objects[i][0] + capacity[i-1][j-objects[i][1]] > capacity[i-1][j]) //�賶�� ���� ���
						capacity[i][j] = objects[i][0] + capacity[i-1][j-objects[i][1]];
					else //�賶�� ���� ���� ���
						capacity[i][j] = capacity[i-1][j];
				}
			}
		}
		answer = capacity[nums][total_capacity];
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums = sc.nextInt();
		int total_capacity = sc.nextInt();
		int[][] objects = new int[nums+1][2];	//������ ��ġ�� ���Ը� ���� 2���� �迭
		for(int i=1; i<=nums; i++) {			//������ ��ġ�� ���� �Է�
			objects[i][0] = sc.nextInt();
			objects[i][1] = sc.nextInt();
		}
		System.out.println(knapsack_DP(nums, total_capacity, objects)); //���� ���
	}
}
