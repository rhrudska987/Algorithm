package algorithm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class clock {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		try { 																 //������ �о�� �� ���� ��� ����ó��
			File file = new File("C:\\Users\\KoKyungNam\\Desktop\\1.in");    //�־��� ���� �о��
			Scanner sc = new Scanner(file); 							     //���� ��ü ���� �� �־���
			while(sc.hasNextLine()) { 									     //���� ���� �ִ��� Ȯ��
				int temp  = sc.nextInt();								     //�ش� ���� ���� ������ ������
				list.add(temp);											     //�о�� ���� ����Ʈ�� ����
			}
		} catch (Exception e) {											     //����ó��
			e.printStackTrace();										     //������ �߻��ٿ����� ã�Ƽ� �ܰ躰�� ������ ���
		}
		
		Integer[] arr = list.toArray(Integer[] :: new);					     //����Ʈ�� �迭�� �ٲ�
		
		double start = System.currentTimeMillis();						     //�ڵ� ���۽ð�
		for(int i=0; i<arr.length; i++) {
			if (arr[i] == 2839004)										     //i��° �迭�� ���� ã�����ϴ� ���� ��ġ�ϸ� �ݺ��� ����
				break;
		}
		
		double stop = System.currentTimeMillis();						     //�ڵ� ����ð�
		String result = String.format("%.6f", (double)(stop - start) / 1000);//�ڵ� ���࿡ �ҿ�� �ð��� �Ҽ��� 6�ڸ����� ���
		System.out.println("�ɸ� �ð��� " + result + "���Դϴ�.");			     //�ڵ� ���࿡ �ҿ�� �ð� ���
	}
}