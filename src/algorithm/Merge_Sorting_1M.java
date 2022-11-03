package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Merge_Sorting_1M {
	
	static void merge_split(int[] arr, int p, int q) {
		int r;
		if (p < q) {
			r = (p + q) / 2;
			merge_split(arr, p, r);
			merge_split(arr, r+1, q);
			merge_sorting(arr, p, r, q);
		}
	}
	
	static void merge_sorting(int[] arr, int p, int r, int q) {
		int i = p, j = r+1, k = p;
		int tmp[] = new int[arr.length];
		while(i <= r && j <= q) {
			if(arr[i] <= arr[j])
				tmp[k++] = arr[i++];
			else
				tmp[k++] = arr[j++];
		}
		if (i > r)
			while(j <= q) tmp[k++] = arr[j++];
		else
			while(i <= r) tmp[k++] = arr[i++];
		for(int l = p; l <= q; l++)
			arr[l] = tmp[l];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(bf.readLine()); //ó�� ���� ��ü ������ ����
		int[] arr = new int[size]; //�迭 ����
		for(int i=0; i < size; i++)  //�ݺ����� ���� n���� ���� �Է� �ޱ�
			arr[i] = Integer.parseInt(bf.readLine());
		merge_split(arr, 0, size - 1); //���� ���� ����
		
		for(int i=0; i < size; i++) { //���ĵ� �� ���
			String s2 = String.valueOf(arr[i]);
			bw.write(s2 + "\n");
		}
		bw.flush();
		bw.close();
	}
}
