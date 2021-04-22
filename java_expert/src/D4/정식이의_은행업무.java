package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 정식이의_은행업무 {

	static List<Long> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			String bin = br.readLine();
			String ter = br.readLine();
			
			long sum = 0;
			long num = 1;
			for(int i = bin.length() - 1 ; i >= 0 ; i--) {
				if(bin.charAt(i) == '1') {
					sum += num;
				}
				num *= 2;
			}
			
			list = new ArrayList<>();
			num = 1;
			for(int i = bin.length() - 1 ; i > 0 ; i--) {
				if(bin.charAt(i) == '1') {
					list.add(sum - num);
				} else {
					list.add(sum + num);
				}
				num *= 2;
			}
			
			// 3진법
			sum = 0;
			num = 1;
			for(int i = ter.length() - 1 ; i >= 0 ; i--) {
				if(ter.charAt(i) == '1') {
					sum += num;
				} else if(ter.charAt(i) == '2') {
					sum += num * 2;
				}
				
				num *= 3;
			}
			
			long ans = -1;
			num = 1;
			for(int i = ter.length() - 1 ; i >= 0 ; i--) {
				if(ter.charAt(i) == '1') {
					if(check(sum - num)) {
						ans = sum - num;
						break;
					}
					if(check(sum + num)) {
						ans = sum + num;
						break;
					}
					
				} else if(ter.charAt(i) == '2') {
					if(check(sum - 2*num)) {
						ans = sum - 2 * num;
						break;
					}
					if(check(sum - num)) {
						ans = sum - num;
						break;
					}
				} else {
					if(check(sum + 2*num)) {
						ans = sum + 2 * num;
						break;
					}
					if(check(sum + num)) {
						ans = sum + num;
						break;
					}
				}
				num *= 3;
			}
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	private static boolean check(long x) {
		for(int i = 0 ; i < list.size() ; i++) {
			if(x == list.get(i)) return true;
		}
		return false;
	}
}
