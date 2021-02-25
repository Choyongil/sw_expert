package acmicpc.Siver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		x += t;
		y += t;
		
		x %= (2 * w);
		y %= (2 * h);
		
		if(x > w) x = 2 * w - x;
		if(y > h) y = 2 * h - y;
		sb.append(x).append(" ").append(y);
		
		System.out.println(sb);
	}
}
