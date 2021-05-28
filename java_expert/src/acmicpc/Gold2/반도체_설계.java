package acmicpc.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 반도체_설계 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		list.add(-1);
		for(int i = 0 ; i < n ; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x > list.get(list.size()-1)) list.add(x);
			else {
				int low = 1;
				int high = list.size()-1;
				while(low < high) {
					int mid = (low + high) / 2;
					if(list.get(mid) < x) {
						low = mid + 1;
					} else {
						high = mid;
					}
				}
				list.set(low, x);
			}
		}
		System.out.println(list.size()-1);
	}
}
