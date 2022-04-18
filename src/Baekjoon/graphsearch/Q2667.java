/*	
 * Baekjoon Algorithm
 * Category	: Graph Search
 * Question	: 2667
 * Title	: 단지번호붙이기
 */ 

package Baekjoon.graphsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q2667 {
	
	static int[][] mat;
	static boolean[][] visited;
	static int n;
	static int[] nx = {1, -1, 0, 0 };
	static int[] ny = {0, 0, 1, -1 };
	static ArrayList<Integer> list = new ArrayList<>();
	static int count;

	public static void danji(int x, int y) {
		visited[x][y] = true;
		count++;
		
		for(int i = 0; i < 4; i++) {
			int xx = nx[i] + x;
			int yy = ny[i] + y;
			if(xx >= 0 && yy >= 0 && xx < n && yy < n) {
				if(mat[xx][yy] == 1 && !visited[xx][yy]) {
					danji(xx, yy);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		mat = new int[n][n];
		visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			for(int j = 0; j < n; j++) {
				mat[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(mat[i][j] == 1 && !visited[i][j]) {
					count = 0;
					danji(i, j);
					list.add(count);
				}
			}
		}
		
		System.out.println(list.size());
		
		Collections.sort(list);
		for(Integer tmp : list) {
			System.out.println(tmp);
		}
	}
}
