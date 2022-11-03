package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class MST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int list_size = sc.nextInt();
		int num_of_lines = sc.nextInt();
		ArrayList<Integer> start_points = new ArrayList<>();
		ArrayList<Integer> end_points = new ArrayList<>();
		ArrayList<Integer> distance = new ArrayList<>();
		for(int i=0; i<num_of_lines; i++) {
			start_points.add(sc.nextInt());
			end_points.add(sc.nextInt());
			distance.add(sc.nextInt());
		}

		int minValue = 0;
		int start_point = 1;

		int[][] d = new int[list_size][list_size];
		d[0][1] = 1;
		int count = 0;
		while (start_points.size() > 0) {
			for(int idx = 0; idx < start_points.size(); idx++) {
				if(start_point == start_points.get(idx)) {
					if((d[end_points.get(idx) - 1][0] == 0 || d[end_points.get(idx)-1][0] > distance.get(idx)) &&d[end_points.get(idx) - 1][1] != 1)
						d[end_points.get(idx)-1][0] = distance.get(idx);
				}
				else if(start_point == end_points.get(idx)) {
					if((d[start_points.get(idx) - 1][0] == 0 || d[start_points.get(idx)-1][0] > distance.get(idx))&&d[start_points.get(idx) - 1][1] != 1)
						d[start_points.get(idx)-1][0] = distance.get(idx);
				}
			}

			int idx = 0;
			while (idx < start_points.size()) {
				if (start_point == start_points.get(idx)) {
					start_points.remove(idx);
					end_points.remove(idx);
					distance.remove(idx);
				}
				else
					idx++;
			}
			if(count == list_size-1)
				break;
			minValue = 0;
			int i = 1;
			int j = 1;
			while (i < list_size) {
				if(d[i][1] == 0 && d[i][0] != 0) {
					minValue = d[i][0];
					j = i;
					break;
				}
				i++;
			}

			while (i < list_size) {
				if(d[i][1] == 0 && d[i][0] != 0 && minValue > d[i][0]) {
					minValue = d[i][0];
					j = i;
				}
				i++;
			}
			d[j][1] = 1;
			start_point = j + 1;
			count++;
		}
		int answer = 0;
		for(int i=0; i<list_size; i++) {
			answer += d[i][0];
		}
		System.out.println(answer);
	}
}
