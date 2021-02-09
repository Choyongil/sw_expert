package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			sb.append("#" + tc + " ");
			
			LinkedList<String> list = new LinkedList<String>();
			
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0 ; i < n ; i++) {
				list.offer(st.nextToken());
			}
			
			br.readLine();
			String[] str = br.readLine().split("I");
			
			for(int i = 1 ; i < str.length ; i++) {
				int x = Integer.parseInt(str[i].split(" ")[1]);
				int y = Integer.parseInt(str[i].split(" ")[2]);
				for(int j = 0 ; j < y ; j++) {
					list.add(x + j, str[i].split(" ")[3+j]);
				}
			}
			
			for(int i = 0 ; i < 10 ; i++) {
				sb.append(list.get(i) + " ");
			}
			System.out.println(sb);
			sb.setLength(0);
			
		}
	}
}
