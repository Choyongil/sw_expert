package acmicpc.Gold2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 가장_긴_증가부분_수열2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		
		int n = sc.nextInt();
		
		for(int i = 0 ; i < n ; i++) {
			int x = sc.nextInt();
			if (x > list.get(list.size() - 1)) list.add(x);
			else {
				int low = 0;
				int high = list.size() - 1;
				while( low < high ) {
					int mid = (high + low) / 2;
					if(list.get(mid) >= x) {
						high = mid;
					} else {
						low = mid + 1;
					}
				}
				list.set(high, x);
			}
		}
		System.out.println(list.size()-1);
	}
}
