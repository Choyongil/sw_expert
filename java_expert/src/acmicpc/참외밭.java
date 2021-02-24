package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 참외밭 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int d = 0, w = 0, h = 0;
		int[] arr = new int[6];
		for(int i = 0 ; i < 6 ; i++) {
			st = new StringTokenizer(br.readLine());
			
			d = Integer.parseInt(st.nextToken());
			arr[i] = Integer.parseInt(st.nextToken());
			
			if (d >= 3) {
				h = Math.max(h, arr[i]);
			} else {
				w = Math.max(w, arr[i]);
			}
		}
		
		int del = 0;
		for(int i = 0 ; i < 6 ; i++) {
			if(arr[i] == w || arr[i] == h) {
				if(i == 0 ) {
					if(arr[1] == w || arr[1] == h) del = arr[3] * arr[4];
					else del = arr[2] * arr[3];
				}
				else if(i == 1) del = arr[4] * arr[5];
				else if(i == 2) del = arr[0] * arr[5];
				else if(i == 3) del = arr[0] * arr[1];
				else del = arr[1] * arr[2];
				break;
			}
		}
		System.out.println((w*h - del)*n);
	}
}
