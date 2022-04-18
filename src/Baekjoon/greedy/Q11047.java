/*	
 * Baekjoon Algorithm
 * Category	: Greedy
 * Question	: 11047
 * Title	: 동전0
 */ 

package Baekjoon.greedy;

import java.util.Scanner;

public class Q11047 {

	public static void main(String[] agrc) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n]; 
		
		int cnt = 0; 
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = n-1; i >= 0; i--) {
			if(k == 0) {
				break;
			}
			
			if(arr[i] > k) {
				continue;
			}
			
			int m = k / arr[i]; // 최대 갯수
			k -= (arr[i]*m);
			
			cnt += m;
			
		}
		
		System.out.println(cnt);
	}
}


