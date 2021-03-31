package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GCD {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		ArrayList<long[]> list = new ArrayList<>();
		long x = 2;
		long y = 1;
		long temp = y;
		list.add(new long[] {x,y});
		for(int k = 1 ; k < 91; k++) {
			temp = y;
			y = x;
			x += temp;
			list.add(new long[] {x,y});
		}
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int k = Integer.parseInt(br.readLine());
			
			sb.append(list.get(k-1)[0]).append(" ").append(list.get(k-1)[1]).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
}
