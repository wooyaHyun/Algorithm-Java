/*	
 * Baekjoon Algorithm
 * Category	: sort
 * Question	: 1181
 * Title	: 단어정렬 
 */ 
package Baekjoon.sort;

import java.util.*;


public class Q1181 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] str = new String[n];
		
		for(int i =0; i < n; i++) {
			str[i] = sc.next();
		}
		
		/* 기본 Array 정렬 방식
		Arrays.sort(str, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() > s2.length()) return 1;
				else if (s1.length() ==  s2.length()) return s1.compareTo(s2);
				return -1;
			}
			
		});
		*/
		
		//람다식
		Arrays.sort(str, (s1, s2)->{
			if(s1.length() > s2.length()) return 1;
			else if (s1.length() ==  s2.length()) return s1.compareTo(s2);
			return -1;
		});
		
		for(int i =0; i < n; i++) {
			if(i == 0) {
				System.out.println(str[i]);
				continue;
			}
			if(str[i-1].equals(str[i])) {
				continue;
			}
			System.out.println(str[i]);
		}
	}
}
