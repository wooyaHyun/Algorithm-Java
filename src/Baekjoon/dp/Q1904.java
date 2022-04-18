/*	
 * Baekjoon Algorithm
 * Category	: Dynamic Programming
 * Question	: 1904
 * Title	: 01≈∏¿œ
 */ 

package Baekjoon.dp;

import java.util.Scanner;

public class Q1904 {
	static int[] dp = new int[1000001];
	
	public static int tileNum(int n) {
		if(dp[n] == -1) {
			dp[n] = (tileNum(n-1) + tileNum(n-2))%15746;
		}
		
		return dp[n];
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i < dp.length; i++) {
			dp[i] = -1;
		}
		int ans = tileNum(n);
		
		System.out.println(ans);
	}
}
