package algorithm;

import java.util.Scanner;

public class Knapsack_DP {

	public static int knapsack_DP(int nums, int total_capacity, int[][] objects) {
		//가방의 용량은 1씩 늘려가면서 이익을 계산
		int capacity[][] = new int[nums + 1][total_capacity + 1]; 
		int answer = 0;
		for(int i=1; i<=nums; i++) { //물건을 1에서 n까지 하나씩 고려
			for(int j=1; j<=total_capacity; j++) { //임시 용량을 1에서 total_capacity까지 증가
				if(objects[i][1] > j) //물건의 무게가 임시 배낭 용량을 초과하면
					capacity[i][j] = capacity[i-1][j]; //물건 i의 가치는 물건 i-1까지 고려했을 때의 최대 가치가 된다. 
				else { //물건의 무게가 임시 배낭 용량을 초과하지 않는 경우
					if(objects[i][0] + capacity[i-1][j-objects[i][1]] > capacity[i-1][j]) //배낭에 담을 경우
						capacity[i][j] = objects[i][0] + capacity[i-1][j-objects[i][1]];
					else //배낭에 담지 않을 경우
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
		int[][] objects = new int[nums+1][2];	//물건의 가치와 무게를 담을 2차원 배열
		for(int i=1; i<=nums; i++) {			//물건의 가치와 무게 입력
			objects[i][0] = sc.nextInt();
			objects[i][1] = sc.nextInt();
		}
		System.out.println(knapsack_DP(nums, total_capacity, objects)); //정답 출력
	}
}
