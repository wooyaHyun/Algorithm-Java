/*	
 * Baekjoon Algorithm
 * Category	: Greedy
 * Question	: 1931
 * Title	: 회의실 배정
 */ 

package Baekjoon.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q1931 {
	
	public static void main(String[] agrc) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Time> list = new ArrayList<>();
		
		for(int i = 0; i < n ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list.add(new Time(a, b)); 
		}
		
		Collections.sort(list, (Time t1, Time t2) ->  {
			if(t1.lastTime == t2.lastTime) {
				return t1.startTime - t2.startTime;
			}
			return t1.lastTime - t2.lastTime;
		});
		
		
		
		Time cur = list.get(0);
		int cnt = 1;
		for(int i = 1; i < list.size(); i ++) {
			if(cur.lastTime <= list.get(i).startTime) {
				cnt++;
				cur = list.get(i);
			}
		}
		
		System.out.println(cnt);
	}
}

class Time{
	int startTime;
	int lastTime;
	
	public Time(int startTime, int lastTime) {
		this.startTime = startTime;
		this.lastTime = lastTime;
	}
	
}
