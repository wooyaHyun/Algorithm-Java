/*	
 * Baekjoon Algorithm
 * Category	: Greedy
 * Question	: 1541
 * Title	: 잃어버린 괄호
 */ 

package Baekjoon.greedy;

import java.util.Scanner;

public class Q1541 {

	public static void main(String[] agrc) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		String[] arr = str.split("-");
		
		int result = 0; 
		
		for(int i = 0; i < arr.length; i ++) {
			int sum = 0; 
			
			//특수문자 split
			String[] plus = arr[i].split("\\+");
			
			for(String s : plus) {
				sum += Integer.parseInt(s);
			}
			
			if(i == 0) {
				result = sum;
			}else {
				result -= sum;
			}
			
			
		}
		
		System.out.println(result);
	}
}
