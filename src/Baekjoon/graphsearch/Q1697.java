/*	
 * Baekjoon Algorithm
 * Category	: Graph Search
 * Question	: 1697
 * Title	: ¼û¹Ù²ÀÁú
 */ 

package Baekjoon.graphsearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1697 {
	
	static int[] arr;
	static boolean[] visited;
	static int n, k;
	static int[] t = {1, -1, 2};

	public static void bfs(int a) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(a);
		visited[a] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i =0; i < 3; i++) {
				int tt;
				if(i != 2) {
					tt = tmp + t[i] ;
				}else {
					tt = tmp * t[i] ;
				}
				if(tt >=0 && tt < 100001) {
					if(!visited[tt]) {
						
						q.offer(tt);
						visited[tt] = true;
						arr[tt] = arr[tmp] +1;
						if(tt == k) {
							return ;
						}
					}
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[100001];
		visited = new boolean[100001];
		arr[n] =1;
		visited[n] = true;
		
		bfs(n);
		
		System.out.println(arr[k] - 1);
		
		
	}
}
