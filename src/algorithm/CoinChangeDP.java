package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChangeDP {
	//W : 각각의 i값에서 최소 동전의 갯수를 저장할 배열, money : 동전 배열, M : 거스름돈 
	public static int coin_change_making_DP(int[] W, int[] money, int M) {
		int j;
		for(int i = 1; i <= M; i++) {        //1부터 M까지 순차적으로 실행
			for(j = 0; j < money.length;) {  //i값보다 작은 거스름돈 액수 중에 가장 큰 액수를 찾음
				if(money[j] <= i) j++;  
				else break;
			}
			j--;
			int min = 100000;   //주어진 조건에서 M의 값은 100,000보다 작기 때문에 초기값을 100,000으로 설정
			while(j >= 0) {		//(거스름돈 - 동전의 액수)의 값을 비교해서 가장 최소 값을 찾음
				if(W[i - money[j]] < min) {
					min = W[i - money[j]];
				}
				j--;
			}
			W[i] = min + 1;     //가장 최소 동전의 갯수 + 1의 값을 W[i]에 저장
		}
		return W[M];			//W[M]값 반환
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(", ");  //첫번째 라인을 입력 받아 ", "을 기준으로 나눠 배열을 생성함
		int[] money = Arrays.stream(str).mapToInt(Integer::parseInt).toArray(); //string배열을 int배열로 바꿈
		int M = Integer.parseInt(sc.nextLine());   //두번째 라인을 입력 받아 int형태로 M에 저장
		Arrays.sort(money);						   //money액수 배열을 오름차순으로 정렬
		int[] W = new int[M + 1];				   //0부터 M까지의 거스름 돈의 갯수를 넣을 배열 생성
		for(int j = 0; j <= M; j++)				   //W배열을 전부 0으로 초기화
			W[j] = 0;
		int answer = coin_change_making_DP(W, money, M); //함수 실행
		System.out.println(answer);						 //정답 출력
	}
}
