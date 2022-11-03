package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SetCover {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int schoolNum = sc.nextInt();
		int roadNum = sc.nextInt();

		int[][] line = new int[roadNum][2];

		for (int i = 0; i < roadNum; i++) {
			line[i][0] = sc.nextInt();
			line[i][1] = sc.nextInt();
		}

		int set[][] = new int[schoolNum][roadNum];
		boolean[] check = new boolean[schoolNum];
		ArrayList<Integer> school = new ArrayList<>();
		for (int i = 1; i <= schoolNum; i++) {
			school.add(i);
			check[i-1] = true;
		}

		int idx;

		for (int i = 0; i < schoolNum; i++) {
			idx = 0;
			for (int j = 0; j < roadNum; j++) {
				if (line[j][0] == i + 1) {
					set[i][idx] = line[j][1];
					idx++;
				} else if (line[j][1] == i + 1) {
					set[i][idx] = line[j][0];
					idx++;
				}
			}
		}
		
		ArrayList<Integer> answer = new ArrayList<>();
		while (school.size() > 0) {
			int max = 0;
			int point = 0;
			for(int i = 0; i < schoolNum; i++) {
				int count = 0;
				if(check[i] == true) {
					for(int j = 0; j < roadNum; j++) {
						if(set[i][j] == 0)
							break;
						for(int m = 0; m < school.size(); m++) {
							if(set[i][j] == school.get(m)) {
								count++;
							}
						}
					}
					if(count+1 == school.size()) {
						max = count;
						point = i;
						break;
					}
					if (count > max) {
						max = count;
						point = i;
					}
				}
			}
			check[point] = false;
			answer.add(point + 1);
			int n = 0;
			while(set[point][n] != 0) {
				for(int j = 0; j<school.size(); j++) {
					if (set[point][n] == school.get(j) || school.get(j) == point + 1)
						school.remove(j--);
				}
				n++;
				if(school.size()==0)
					break;
			}
		}
		Collections.sort(answer);
		for(int i=0; i<answer.size(); i++)
			System.out.print(answer.get(i) + " ");
	}
}
