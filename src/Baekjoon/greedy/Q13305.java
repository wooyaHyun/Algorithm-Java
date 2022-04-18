/*	
 * Baekjoon Algorithm
 * Category	: Greedy
 * Question	: 13305
 * Title	: ¡÷¿Øº“
 */ 

package Baekjoon.greedy;

import java.util.Scanner;

public class Q13305 {

	public static void main(String[] agrc) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long[] len = new long[n-1];
		long[] price = new long[n];

		for(int i = 0; i < n-1; i++) {
			len[i] = sc.nextLong();
			
		}
		for(int i = 0; i < n; i++) {
			price[i] = sc.nextLong();
		}
		
		long  result= 0; 
		
		long min = price[0];
		for(int i = 0; i < n-1; i++) {

			if(min > price[i]) {
				min = price[i];
			}
			result += (min * len[i]);
			
		}
		System.out.println(result);
	}
}
