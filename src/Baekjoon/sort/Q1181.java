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
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(sc.next());
		}
		//Set 을 이용하여 중복 제거
		Set<String> set = new HashSet<String>(list);
		//set -> list 로 변환
		List<String> lst = new ArrayList<String>(set);
		
		Collections.sort(lst, (String s1, String s2) -> {
			if(s1.length() > s2.length()) {
				return 1;
			}
			else if(s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}
			return -1;
		});
		
		for(String s : lst) {
			System.out.println(s);
		}
	}
}
