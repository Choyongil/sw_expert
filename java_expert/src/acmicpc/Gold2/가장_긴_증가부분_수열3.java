package acmicpc.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장_긴_증가부분_수열3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Long> list = new ArrayList<Long>();
		list.add(Long.MIN_VALUE);

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			long x = Long.parseLong(st.nextToken());
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
