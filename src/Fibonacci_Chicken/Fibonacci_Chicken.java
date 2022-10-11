package Fibonacci_Chicken;

import java.util.Scanner;

public class Fibonacci_Chicken {

	static int[] Fibonacci()
	{
		int fibonacci_nums[] = new int[44];
		fibonacci_nums[0] = 0;
		fibonacci_nums[1] = 1;
		
		for(int i=2; i<44; i++)
		{
			fibonacci_nums[i] = fibonacci_nums[i-2] + fibonacci_nums[i-1]; 
		}
		
		return fibonacci_nums;
	}
		
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n_people = Integer.parseInt(str);
		int n_chicken = 0;
		int fibo_num = 0;
		int answer = 0;
		int[] fibonacci_nums = Fibonacci();
		
		while (n_people > 0)
		{
			for (int i = 1; i<44; i++) {
				if(fibonacci_nums[i] <= n_people)
				{
					fibo_num = fibonacci_nums[i];
					n_chicken = fibonacci_nums[i-1];
				}
				else
					break;
			}
			n_people-=fibo_num;
			answer += n_chicken;
		}
		System.out.println(answer);
		sc.close();
	}
	
	
}
