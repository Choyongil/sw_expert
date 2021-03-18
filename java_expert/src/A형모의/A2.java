package A형모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int ans = 0;
			ArrayList<int[]> list = new ArrayList<int[]>();
			ArrayList<int[]> list2 = new ArrayList<int[]>();
			
			int max_x = 0;
			int max_y = 0;
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int r2 = Integer.parseInt(st.nextToken());
				int c2 = Integer.parseInt(st.nextToken());
				
				max_x = Math.max(r2, Math.max(r, max_x));
				max_y = Math.max(c2, Math.max(c, max_y));
				
				list.add(new int[] {r,c});
				list2.add(new int[] {r2,c2});
			}
			
			int max = Math.max(max_x, max_y);
			
			out :for(int k = 1 ; k <= max ; k++) {
				for(int x = 0 ; x < max + 1 - k ; x++) {
					for(int y = 0 ; y < max + 1 - k ; y++) {	
						int sum = 0;
						for(int i = 0 ; i < list.size() ; i++) {
							int nr = Math.min(list.get(i)[0], list2.get(i)[0]);
							int nc = Math.min(list.get(i)[1], list2.get(i)[1]);
							int nr2 = Math.max(list.get(i)[0], list2.get(i)[0]);
							int nc2 = Math.max(list.get(i)[1], list2.get(i)[1]);
							
							if (check(nr, nc, nr2, nc2, x, y, k)) {
								sum++;
							}
						}
						if(list.size() - sum <= m) {
							ans = k;
							break out;
						}
					}
				}				
			}
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	public static boolean check(int r, int c, int r2, int c2, int startR, int startC, int k) {
		if(startR <= r && startC <= c && startR + k >= r2 && startC + k >= c2) return true;
		return false;
	}
}
