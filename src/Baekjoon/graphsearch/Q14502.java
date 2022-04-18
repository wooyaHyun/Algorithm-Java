/*	
 * Baekjoon Algorithm
 * Category	: Graph Search
 * Question	: 14502
 * Title	: 연구소
 */ 

package Baekjoon.graphsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Q14502 {
	static int[][] arr;
	static int[][] copyArr;
	static ArrayList<Virus> virusList;
	static int[] nx = {1, -1, 0, 0};
	static int[] ny = {0, 0, 1, -1};
	static int n;
	static int m;
	static int max = Integer.MIN_VALUE;
	
	public static int[][] copyMap(int[][] arr) {
		int[][] copyMap = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				copyMap[i][j] = arr[i][j];
			}
		}
		return copyMap;
	}
	
	//벽세우기 method
	public static void makeWall(int depth) {
		if(depth == 3) {
			spreadVirus();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(copyArr[i][j] == 0) {
					copyArr[i][j] = 1;
					makeWall(depth+1);
					copyArr[i][j] = 0;
				}
			}
		}
		
	}
	
	//바이러스 확장 method
	public static void spreadVirus() {
		int[][] virusMap = copyMap(copyArr); // 바이러스를 확장 시킬 복사 맵
		
		Queue<Virus> q = new LinkedList<>();
		for(int i = 0; i < virusList.size(); i++) {
			q.offer(new Virus(virusList.get(i).x, virusList.get(i).y));
		}
		
		while(!q.isEmpty()) {
			Virus v = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int lx = v.x + nx[i];
				int ly = v.y + ny[i];
				if(lx >=0 && lx < n && ly >=0 && ly < m) {
					if(virusMap[lx][ly] == 0) {
						virusMap[lx][ly] = 2;
						q.offer(new Virus(lx, ly));
					}
				}
			}
		}
		int cnt = countSafe(virusMap);
		
		max = Math.max(max, cnt);
		
	}
	
	public static int countSafe(int[][] map) {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					cnt ++;
				}
			}
		}
		return cnt;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/** 0은 빈칸 / 1은 벽 / 2는 바이러스
		 *  
		 *  벽(1)을 3개 세워서 안전한 방의 최대 값 구하기
		 *   
		 */
		
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		virusList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 2) {
					virusList.add(new Virus(i, j));
				}
			}
		}
		copyArr = copyMap(arr);
		
		makeWall(0);
		System.out.println(max);
		
	}
}

class Virus{
	int x,y;
	public Virus(int x, int y) {
		this.x = x;
		this.y= y;
	}
}

