package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 사랑의_카운셀러 {
	
	static ArrayList<long[]> arr;
	static int[] list;
	static int n;
	static boolean[] isSelected;
	static long ans;
	static long X;
	static long Y;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#" + tc + " ");
			
			n = Integer.parseInt(br.readLine());
			arr = new ArrayList<long[]>();
			isSelected = new boolean[n];
			
			for(int i = 0 ; i < n ; i++) {
				long[] tmp = new long[2];
				st = new StringTokenizer(br.readLine());
				tmp[0] = Integer.parseInt(st.nextToken());
				tmp[1] = Integer.parseInt(st.nextToken());
				X += tmp[0];
				Y += tmp[1];
				arr.add(tmp);		
			}
			list = new int[n / 2];
			ans = Long.MAX_VALUE;
			
			if(list.length == 1) {
				long sumx = arr.get(0)[0] - arr.get(1)[0];
				long sumy = arr.get(0)[1] - arr.get(1)[1];

				ans = Math.min(ans, sumx*sumx + sumy*sumy);
			}
			else powerset(0, 0);
			sb.append(ans);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
	
	public static void powerset(int cnt, int idx) {
		
		if( cnt == n / 2) {
			System.out.println(Arrays.toString(list));
			long sumx = 0;
			long sumy = 0;
			
			for(int i : list) {
				sumx += arr.get(i)[0];
				sumy += arr.get(i)[1];
			}
			
			long x = sumx - (X - sumx);
			long y = sumy - (Y - sumy);

			ans = Math.min(ans, x*x + y*y);
			
			return;
		}
		
		for(int i = 0 ; i < 1; i++) {
			if (isSelected[i] == true) continue;
			
			isSelected[i] = true;
			list[cnt++] = i;
			
			int j = -1;
			for(j = i + 1 ; j < n ; j++) {
				if( isSelected[j] == true) continue;
				
				isSelected[j] = true;
				list[cnt] = j;
				cnt += 1;
				powerset(cnt, j);
				isSelected[j] = false;
				cnt--;
			}
			cnt--;
			isSelected[i] = false;
		}
		
		
	}
}
