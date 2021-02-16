package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 전쟁_땅_따먹기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc < n ; tc ++) {

			String ans = "";
			Map<String,Integer> map = new HashMap<String,Integer>();
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			
			for(int i = 0 ; i < k ; i++) {
				String s = st.nextToken();
				if(map.get(s) == null) {
					map.put(s,1);
				}
				else {
					int num = map.get(s);
					map.put(s, num + 1);
					if (num + 1 > k / 2) {
						ans = s;
						break;
					}
				}
			}

			System.out.println(ans == "" ? "SYJKGW" : ans);
		}
	}
}
