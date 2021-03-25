package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 최장_증가_부분_수열 {

	static int[][] arr;
	static ArrayList<Integer> update;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			arr = new int[2][n+1];
			update = new ArrayList<Integer>();
			update.add(0);
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i <= n ; i++) {
				arr[0][i] = Integer.parseInt(st.nextToken());
				
				if(arr[0][i] > update.get(update.size()-1)) {
					update.add(arr[0][i]); 
				} else {
					int idx = BinaryCheck(0, update.size(), arr[0][i]);
					update.set(idx, arr[0][i]);
				}
			}
			sb.append(update.size() - 1).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static int BinaryCheck(int l, int r, int x) {
		
		int mid = (l + r) / 2;
		
		while(l < r) {
			
			if( update.get(mid) < x) {
				l = mid + 1;
			} else {
				r = mid;
			}
			mid = (l + r) / 2;
		}
		
		return mid;
	}
}
//1
//8
//3 5 7 9 2 1 4 8
//4
//5
//1 3 2 5 4 
//6
//4 2 3 1 5 6
//5
//1 3 2 5 4 
//6
//4 2 3 1 5 6