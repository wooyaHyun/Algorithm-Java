/*	
 * Baekjoon Algorithm
 * Category	: Back Traking
 * Question	: 14888
 * Title	: 연산자 끼워넣기
 */ 
package Baekjoon.backtraking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q14888 {// 연산자 끼워넣기
	
	static int n ;
	static int[] arr;
	static String[] op ;
	static boolean[] visited;
	static String[] out;
	static ArrayList<Integer> list = new ArrayList<>();
	
	
	
	public static void per(int depth) {
		if(depth == n-1) {
			cal();
			return;
		}
		
		for(int i = 0; i < n-1; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				out[depth] = op[i];
				per(depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static void cal() {
		int result = arr[0];
		for(int i = 1; i < n; i++) {
			if(out[i-1].equals("+")) {
				result += arr[i];
			}else if(out[i-1].equals("-")) {
				result -= arr[i];
			}else if(out[i-1].equals("*")) {
				result *= arr[i];
			}else if(out[i-1].equals("/")) {
				result /= arr[i];
			}
		}
		list.add(result);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n];
		op = new String[n-1];
		visited = new boolean[n-1];
		out = new String[n-1];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt = 0;
		for(int i = 0; i < 4; i++) {
			int tmp = sc.nextInt();
			
			for(int j = 0; j < tmp; j++) {
				if( i == 0) {
					op[cnt++] = "+";
				}else if(i == 1) {
					op[cnt++] = "-";
				}else if(i == 2) {
					op[cnt++] = "*";
				}else if(i == 3) {
					op[cnt++] = "/";
				}
			}
		}
		
		per(0);
		
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
		
	}
}
