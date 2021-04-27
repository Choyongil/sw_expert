package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 창용_마을_무리의_개수 {

	static int n, m, arr[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n+1];
			
			make();
			int ans = n;
			for(int i = 0 ; i < m ; i++) {
				st = new StringTokenizer(br.readLine());
				int f = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				if(union(f, t)) {
					ans--;
				}
			}
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	public static void make() {
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(arr[a] == a) {
			return a;
		}
		return arr[a] = findSet(arr[a]);
	}
	
	public static boolean union(int a, int b) {
		int aSet = findSet(a);
		int bSet = findSet(b);
		
		if(aSet == bSet) return false;
		
		arr[bSet] = aSet;
		return true;
	}
	
}
