/*	
 * Baekjoon Algorithm
 * Category	: sort
 * Question	: 1181
 * Title	: �ܾ����� 
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
		//Set �� �̿��Ͽ� �ߺ� ����
		Set<String> set = new HashSet<String>(list);
		//set -> list �� ��ȯ
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
