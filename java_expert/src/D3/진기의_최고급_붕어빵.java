package D3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 진기의_최고급_붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
			

		StringBuilder sb = new StringBuilder();
		
		for( int tc = 1 ; tc <= T ; tc++) {
			sb.append("#" + tc+ " ");
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			List<Integer> arr = new ArrayList<Integer>();
			int max_t = -1;
			
			for(int i = 0 ; i < n ; i++) {
				arr.add(sc.nextInt());
				if (arr.get(i) > max_t) max_t = arr.get(i);
			}
			
			Collections.sort(arr, new Comparator<Integer>(){

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o1 - o2;
				}
			});
			
			int total = 0;		// 만들어진 붕어빵 갯수
			boolean flag = true;
			for(int i = 0 ; i <= max_t ; i++) {
				
				if (i != 0 && i % m == 0) {
					total += k;
				}
				if (arr.get(0) == i) {
					arr.remove(0);
					total--;
				}
				if (total < 0) {
					flag = false;
					break;
				}
				if (arr.size() == 0) {
					break;
				}
			}
			
			if (flag == true)
				sb.append("Possible");
			else sb.append("Impossible");
			
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
