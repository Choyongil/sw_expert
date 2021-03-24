package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dpMax = new int[2][3];
		int[][] dpMin = new int[2][3];
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		dpMax[0] = new int[] {a,b,c};
		dpMin[0] = new int[] {a,b,c};
		
		for(int i = 1 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			dpMax[1][0] = Math.max(dpMax[0][0],dpMax[0][1]) + a;
			dpMax[1][1] = Math.max(dpMax[0][2], Math.max(dpMax[0][0], dpMax[0][1])) + b;
			dpMax[1][2] = Math.max(dpMax[0][2],dpMax[0][1]) + c;
			
			dpMin[1][0] = Math.min(dpMin[0][0],dpMin[0][1]) + a;
			dpMin[1][1] = Math.min(dpMin[0][2], Math.min(dpMin[0][0], dpMin[0][1])) + b;
			dpMin[1][2] = Math.min(dpMin[0][2],dpMin[0][1]) + c;
			
			for(int x = 0 ; x < 3 ; x++) {
				dpMax[0][x] = dpMax[1][x];
				dpMin[0][x] = dpMin[1][x];
			}
		}
		System.out.println(Math.max(dpMax[0][0],Math.max(dpMax[0][1],dpMax[0][2]))
				+ " " + Math.min(dpMin[0][0],Math.min(dpMin[0][1],dpMin[0][2])));
	}
}
