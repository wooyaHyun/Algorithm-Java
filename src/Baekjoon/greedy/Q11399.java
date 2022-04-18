/*	
 * Baekjoon Algorithm
 * Category	: Greedy
 * Question	: 11399
 * Title	: ATM
 */ 

package Baekjoon.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q11399 {

	public static void main(String[] agrc) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Line> list = new ArrayList<>(); 
		
		for(int i = 0; i < n; i++) {
			int m = sc.nextInt();
			list.add(new Line(i, m));
		}
		
		Collections.sort(list, (Line l1, Line l2) -> {
			if(l1.m == l2.m) {
				return l1.i - l2.i;
			}
			return l1.m - l2.m;
		});
		
		int sum = 0;
		int result = 0; 
		for(Line l : list) {
			sum += l.m;
			result += sum;
		}
		System.out.println(result);
	}
}

class Line{
	int i;
	int m;
	
	public Line(int i, int m) {
		this.i = i;
		this.m = m;
	}
	
}
