package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Knapsack_greedy {
	public static int knapsack_greedy(int nums, int total_capacity, int[][] objects) {
		int answer = 0;
		double[][] objects_per_weight = new double[nums][2]; //물건의 단위 무게당 가치와 무게를 담을 2차원 배열
		for(int i=0; i<nums; i++) {							 //물건의 단위 무게 계산후 배열에 입력
			objects_per_weight[i][0] = (double)objects[i][0] / objects[i][1];
			objects_per_weight[i][1] = objects[i][1];
		}
		Arrays.sort(objects_per_weight, new Comparator<double[]>() {//단위 무게를 기준으로 2차원 배열 정렬
			public int compare(double[] o1, double[] o2) {
				return (int) (o2[0]-o1[0]);
			}
		});
		for(int i=0; i<nums; i++) {
			if(objects_per_weight[i][1] > total_capacity) break;    //가방에 물건이 추가 되었을 때, 용량을 초과하는지 여부 확인
			total_capacity-=objects_per_weight[i][1];				//가방에 물건 추가
			for(int j=0; j<nums; j++) {
				if(objects_per_weight[i][1] == objects[j][1])		//물건의 가치를 찾아서 answer에 더하기
					answer += objects[j][0];
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums = sc.nextInt();
		int total_capacity = sc.nextInt();
		int[][] objects = new int[nums][2];  //물건의 가치와 무게를 담을 2차원 배열
		for(int i=0; i<nums; i++) {			 //물건의 가치와 무게 입력
			objects[i][0] = sc.nextInt();
			objects[i][1] = sc.nextInt();
		}
		System.out.println(knapsack_greedy(nums, total_capacity, objects)); //정답 출력
	}
}
