package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 두_배열의_합 {

	static int t, n, arr[], m, arr2[];
	static long ans;
	static List<Integer> list, list2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		m = Integer.parseInt(br.readLine());
		arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m ; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>();
		list2 = new ArrayList<>();
		
		for(int i = 0 ; i < n ; i++) {
			int sum = 0;
			for(int j = i ; j < n ; j++) {
				sum += arr[j];
				list.add(sum);
			}
		}
		
		for(int i = 0 ; i < m ; i++) {
			int sum = 0;
			for(int j = i ; j < m ; j++) {
				sum += arr2[j];
				list2.add(sum);
			}
		}
		
		Collections.sort(list);
		Collections.sort(list2);
		
		ans = 0;
		
		search();
		
		System.out.println(ans);
		
	}
	
	public static void search() {
		
		int idx = 0;
		int idx2 = list2.size() - 1;
		
		while(idx < list.size() && idx2 >= 0) {

			long sum = list.get(idx) + list2.get(idx2);
			
			if(sum == t) {
				
				long cnt1 = 0;
				long cnt2 = 0;
				int a = list.get(idx);
				int b = list2.get(idx2);
				
				while(idx < list.size() && list.get(idx) == a) {
					cnt1++;
					idx++;
				}
				
				while(idx2 >= 0 && list2.get(idx2) == b) {
					cnt2++;
					idx2--;
				}
				
				ans += cnt1 * cnt2;
				
			} else if(sum < t) {
				idx++;
			} else {
				idx2--;
			}
			
			
			
			
		}
		
	}
}
