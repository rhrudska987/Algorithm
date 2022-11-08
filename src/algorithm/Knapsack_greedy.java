package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Knapsack_greedy {
	public static int knapsack_greedy(int nums, int total_capacity, int[][] objects) {
		int answer = 0;
		double[][] objects_per_weight = new double[nums][2]; //������ ���� ���Դ� ��ġ�� ���Ը� ���� 2���� �迭
		for(int i=0; i<nums; i++) {							 //������ ���� ���� ����� �迭�� �Է�
			objects_per_weight[i][0] = (double)objects[i][0] / objects[i][1];
			objects_per_weight[i][1] = objects[i][1];
		}
		Arrays.sort(objects_per_weight, new Comparator<double[]>() {//���� ���Ը� �������� 2���� �迭 ����
			public int compare(double[] o1, double[] o2) {
				return (int) (o2[0]-o1[0]);
			}
		});
		for(int i=0; i<nums; i++) {
			if(objects_per_weight[i][1] > total_capacity) break;    //���濡 ������ �߰� �Ǿ��� ��, �뷮�� �ʰ��ϴ��� ���� Ȯ��
			total_capacity-=objects_per_weight[i][1];				//���濡 ���� �߰�
			for(int j=0; j<nums; j++) {
				if(objects_per_weight[i][1] == objects[j][1])		//������ ��ġ�� ã�Ƽ� answer�� ���ϱ�
					answer += objects[j][0];
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums = sc.nextInt();
		int total_capacity = sc.nextInt();
		int[][] objects = new int[nums][2];  //������ ��ġ�� ���Ը� ���� 2���� �迭
		for(int i=0; i<nums; i++) {			 //������ ��ġ�� ���� �Է�
			objects[i][0] = sc.nextInt();
			objects[i][1] = sc.nextInt();
		}
		System.out.println(knapsack_greedy(nums, total_capacity, objects)); //���� ���
	}
}
