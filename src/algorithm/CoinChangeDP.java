package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChangeDP {
	//W : ������ i������ �ּ� ������ ������ ������ �迭, money : ���� �迭, M : �Ž����� 
	public static int coin_change_making_DP(int[] W, int[] money, int M) {
		int j;
		for(int i = 1; i <= M; i++) {        //1���� M���� ���������� ����
			for(j = 0; j < money.length;) {  //i������ ���� �Ž����� �׼� �߿� ���� ū �׼��� ã��
				if(money[j] <= i) j++;  
				else break;
			}
			j--;
			int min = 100000;   //�־��� ���ǿ��� M�� ���� 100,000���� �۱� ������ �ʱⰪ�� 100,000���� ����
			while(j >= 0) {		//(�Ž����� - ������ �׼�)�� ���� ���ؼ� ���� �ּ� ���� ã��
				if(W[i - money[j]] < min) {
					min = W[i - money[j]];
				}
				j--;
			}
			W[i] = min + 1;     //���� �ּ� ������ ���� + 1�� ���� W[i]�� ����
		}
		return W[M];			//W[M]�� ��ȯ
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(", ");  //ù��° ������ �Է� �޾� ", "�� �������� ���� �迭�� ������
		int[] money = Arrays.stream(str).mapToInt(Integer::parseInt).toArray(); //string�迭�� int�迭�� �ٲ�
		int M = Integer.parseInt(sc.nextLine());   //�ι�° ������ �Է� �޾� int���·� M�� ����
		Arrays.sort(money);						   //money�׼� �迭�� ������������ ����
		int[] W = new int[M + 1];				   //0���� M������ �Ž��� ���� ������ ���� �迭 ����
		for(int j = 0; j <= M; j++)				   //W�迭�� ���� 0���� �ʱ�ȭ
			W[j] = 0;
		int answer = coin_change_making_DP(W, money, M); //�Լ� ����
		System.out.println(answer);						 //���� ���
	}
}
