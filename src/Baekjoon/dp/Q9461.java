/*	
 * Baekjoon Algorithm
 * Category	: Dynamic Programming
 * Question	: 9461
 * Title	: 파도반 수열
 */ 

package Baekjoon.dp;

import java.util.Scanner;

public class Q9461 {

	static long[] dp = new long[1000001];
	
	public static long dynamic(int n) {
		if(dp[n] == -1) {
			dp[n] = dynamic(n-3) + dynamic(n-2);
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i = 3; i < dp.length; i++) {
			dp[i] = -1;
		}
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			System.out.println(dynamic(n)); 
		}
	}
	
	
}
