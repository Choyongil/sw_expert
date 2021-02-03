package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 항구에_들어오는_배 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			sb.append("#" + tc + " ");
			
			int num = Integer.parseInt(br.readLine());
			int[] arr = new int[num];
			
			for(int n = 0 ; n < num ; n++) {
				arr[n] = Integer.parseInt(br.readLine());
			}
			
			int ans = 0;
			for(int i = 1 ; i < num ; i++) {
				if (arr[i] == 0) continue;
				int day = arr[i] - 1;
				ans += 1;
				for(int j = i + 1 ; j < num ; j++) {
					if((arr[j] - 1 ) % day == 0) {
						arr[j] = 0;
					}
				}
			}
			sb.append(ans);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
