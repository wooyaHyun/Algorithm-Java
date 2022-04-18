/*	
 * Baekjoon Algorithm
 * Category	: Back Traking
 * Question	: 15649~15652
 * Title	: N과 M(1~4)
 */ 
package Baekjoon.backtraking;

import java.util.Scanner;

public class Q15649_Q15652 {
	
	//순열_중복순열
	public static void per(int[] arr, boolean[] visited, int[] output, int depth, int n, int m) {
		if(depth == m) {
			print(output, m);
			return ;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) { // if문 주석시 중복 순열
				visited[i] = true;
				output[depth] = arr[i];
				per(arr, visited, output, depth+1, n, m);
				visited[i] = false;
			}
		}
		
		
	}
	
	public static void comb(int[] arr, boolean[] visited, int[] output, int depth, int start, int n, int m) {
		if(depth == m) {
			print(output, m);
			return ;
		}
		for(int i =start; i< n; i++) {
	
			output[depth] = arr[i];
			//조합
			comb(arr, visited, output, depth+1, i+1, n, m);
			//중복 조합
			//comb(arr, visited, output, depth+1, i, n, m);
		}
	}
	
	public static void print(int[] output,int m) {
		
		for(int i = 0; i < m; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println();	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		boolean[] visited = new boolean[n];
		int[] output = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		
		//per(arr, visited, output, 0, n, m);
		comb(arr, visited, output,0, 0, n, m);
	}
}
