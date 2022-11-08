package algorithm;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int n, int[] student, int[] point) {
    	int answer = 0;
    	int student_idx[] = new int[n];
    	ArrayList<Integer> good = new ArrayList<>();
    	ArrayList<Integer> bad = new ArrayList<>();
    	for(int i=0; i<n; i++) { 
    		student_idx[i] = 0;
    		if(i < n/2)
    			good.add(i+1);
    		else
    			bad.add(i+1);
    	}
    	int minStudent = n/2;
    	for(int i=0; i<student.length; i++) {
    		student_idx[student[i]-1] += point[i]; 
    		boolean in_good = false;
    		for(int j=0; j<good.size(); j++) {
    			if(good.get(j) == student[i])
    				in_good = true;
    		}
    		System.out.println("min : " + minStudent);
    		if(!in_good) {
    			System.out.println("change");
    			if(student_idx[student[i] - 1] > student_idx[minStudent - 1]) {
    				answer++;
    				good.add(student[i]);
    				for(int k=0; k<good.size(); k++) {
    					if(good.get(k) == minStudent)
    						good.remove(k);
    				}
    				bad.add(minStudent);
    				for(int k=0; k<bad.size(); k++) {
    					if(bad.get(k) == student[i])
    						bad.remove(k);
    				}
    				minStudent = student[i];
    				Collections.sort(good);
    				for(int k=0; k<good.size(); k++) {
    					if(student_idx[good.get(k) - 1] < student_idx[minStudent-1]) {
    						minStudent = good.get(k);
    					}
    					else if(student_idx[good.get(k) - 1] == student_idx[minStudent-1]) {
    						minStudent = good.get(k);
    					}
    				}
    			}
    			else if(student_idx[student[i] - 1] == student_idx[minStudent - 1] && student[i] < minStudent) {
    				answer++;
    				good.add(student[i]);
    				for(int k=0; k<good.size(); k++) {
    					if(good.get(k) == minStudent)
    						good.remove(k);
    				}
    				bad.add(minStudent);
    				for(int k=0; k<bad.size(); k++) {
    					if(bad.get(k) == student[i])
    						bad.remove(k);
    				}
    				minStudent = student[i];
    				Collections.sort(good);
    				for(int k=0; k<good.size(); k++) {
    					if(student_idx[good.get(k) - 1] < student_idx[minStudent-1]) {
    						minStudent = good.get(k);
    					}
    					else if(student_idx[good.get(k) - 1] == student_idx[minStudent-1]) {
    						minStudent = good.get(k);
    					}
    				}
    			}
    		}
    		else {
    			for(int k=0; k<good.size(); k++) {
					if(student_idx[good.get(k) - 1] < student_idx[minStudent-1]) {
						minStudent = good.get(k);
					}
					else if(student_idx[good.get(k) - 1] == student_idx[minStudent-1]) {
						minStudent = good.get(k);
					}
				}
    		}
    			
    		System.out.println("good : ");
    		for(int k=0; k<good.size(); k++) {
    			System.out.print(good.get(k) + ", ");
    		}
    		System.out.println("bad : ");
    		for(int k=0; k<bad.size(); k++) {
    			System.out.print(bad.get(k) + ", ");
    		}
    		System.out.println();
    		System.out.print("[");
    		for(int k=0; k<n; k++) {
    			System.out.print(student_idx[k] + ", ");
    		}
    		System.out.println("]");
    	}
        return answer;
    }
}

public class Main {	
	
	public static void main(String[] args) {
		Solution so = new Solution();
		int student[] = {3,2,10,2,8,3,9,6,1,2};
		int point[] = {3,2,2,5,4,1,2,1,3,3};
		System.out.println(so.solution(10, student, point));
	}

}
