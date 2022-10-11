package Fibonacci_Chicken;

import java.util.Scanner;

public class tromino {
	
	static int num = 0;
	
	static boolean check(int[][] tromino, int x, int y, int size) {
		for(int i=x; i<x + size; i++) {
			for(int j = y; j<y + size; j++) {
				if(tromino[i][j] != 0) return false;
			}
		}
		return true;
	}
	
	static void sol(int[][] tromino, int x, int y, int size) {
		num++;
		int s = size / 2;
		if(check(tromino, x, y, s)) tromino[x + s - 1][y + s - 1] = num;
		if(check(tromino, x, y + s, s)) tromino[x + s - 1][y + s] = num;
		if(check(tromino, x + s, y, s)) tromino[x + s][y + s - 1] = num;
		if(check(tromino, x + s, y + s, s)) tromino[x + s][y + s] = num;
		
		if(s == 1)
			return;
		
		sol(tromino, x, y, s);
		sol(tromino, x + s, y, s);
		sol(tromino, x, y + s, s);
		sol(tromino, x + s, y + s, s);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first_input = sc.nextInt();
		int size = 1;
		for(int i=0; i<first_input; i++)
			size *= 2;
		int[][] tromino = new int[size][size];
		int i = sc.nextInt();
		int j = sc.nextInt();
		tromino[j - 1][i - 1] = -1;
		sol(tromino, 0, 0, size);
		
		
		for(int k=0; k < size; k++) {
			for(int l = 0; l < size; l++) {
				System.out.print(tromino[k][l] + " ");
			}
			System.out.println();
		}
	}
}
