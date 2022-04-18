/*	
 * Baekjoon Algorithm
 * Category	: Dynamic Programming
 * Question	: 1932
 * Title	: Á¤¼ö»ï°¢Çü
 */ 


package Baekjoon.dp;

import java.util.Scanner;

public class Q1932 {

	static Integer[][] dp;
	static Integer[][] cost;
	
	public static int isCheck(int i, int j) {
		
		
		if(dp[i][j] == null) {
			
			dp[i][j] = Math.max(isCheck(i+1,j), isCheck(i+1, j+1)) + cost[i][j];
			
		}
		
		return dp[i][j];
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		dp = new Integer[n][n];
		cost = new Integer[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i+1; j++) {
				cost[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			dp[n-1][i] = cost[n-1][i];
		}
		
		System.out.println(isCheck(0, 0));
		
	}
	
	
}
