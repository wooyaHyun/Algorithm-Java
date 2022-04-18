/*	
 * Baekjoon Algorithm
 * Category	: Back Traking
 * Question	: 9663
 * Title	: N-Queen
 */ 
package Baekjoon.backtraking;

import java.util.Scanner;

public class Q9663 {
	static int n;
	static int[] arr;
	static int count = 0;
	
	public static void nQueen(int depth) {
		
		if(depth == n) {
			count++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			arr[depth] = i;
			if(possible(depth)) {
				
				nQueen(depth+1);
			}
			
		}
	}
	
	public static boolean possible(int tmp) {
		for(int i = 0; i < tmp; i ++) {
			if(arr[i] == arr[tmp]) {
				return false;
			}
			
			else if(Math.abs(tmp-i) == Math.abs(arr[tmp]-arr[i])) {
				return false;
			}
			
		}
		return true;
	}	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n];
		
		nQueen(0);
		System.out.println(count);
	}
}
