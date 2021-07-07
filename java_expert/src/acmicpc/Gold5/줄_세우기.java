package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 줄_세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		list.add(-1);
		
		for(int i = 0 ; i < n ; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(list.get(list.size() - 1) < x) list.add(x);
			else {
				int low = 0;
				int high = list.size() - 1;
				
				while(low < high) {
					int mid = (low + high) / 2;
					
					if(list.get(mid) > x) {
						high = mid;
					} else {
						low = mid + 1;
					}
				}
				list.set(low, x);
			}
		}
		System.out.println(n - list.size() + 1);
	}
}
