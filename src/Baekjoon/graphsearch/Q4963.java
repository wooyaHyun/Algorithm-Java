/*	
 * Baekjoon Algorithm
 * Category	: Graph Search
 * Question	: 4963
 * Title	: ¼¶ÀÇ °³¼ö
 */ 
package Baekjoon.graphsearch;

import java.util.Scanner;

public class Q4963 {
	static int w;
	static int h;
	static int cnt;
	static int[][] mat;
	static boolean[][] visited;
	static int[] nx = {1, -1, 0, 0, -1, 1, -1, 1};
	static int[] ny = {0, 0, 1, -1, -1, 1, 1, -1};
	
	public static void search(int x, int y) {
		visited[x][y] = true;
	
		for(int i = 0; i < 8; i++) {
			int xx = x + nx[i];
			int yy = y + ny[i];
			
			if(xx < 0 || xx >= h || yy < 0 || yy >= w) continue;
			
			if(mat[xx][yy] == 1 && !visited[xx][yy]) {
				search(xx, yy);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			w = sc.nextInt(); 
			h = sc.nextInt();
		
			if(w == 0 && h == 0)break;
			
			mat = new int[h][w];
			visited = new boolean[h][w];
			cnt = 0;
			
			// ¼¶ ÃÊ±âÈ­
			for(int i = 0; i < h; i++) {
				for(int j =0; j < w; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			
			//Å½»ö
			for(int i = 0; i < h; i++) {
				for(int j =0; j < w; j++) {
					if(mat[i][j] == 1 && !visited[i][j]) {
						cnt++;
						search(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
		
	}
}
