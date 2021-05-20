package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 톱니바퀴 {

	static char[][] gear;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		gear = new char[4][8];
		for(int i = 0 ; i < 4; i++) {
			gear[i] = br.readLine().toCharArray();
		}
		
		char[][] touch = new char[3][2];
		
		// 닿아 있는 부분들의 상태(N or S) 값
		for(int i = 0 ; i < 3 ; i++) {
			touch[i][0] = gear[i][2];
			touch[i][1] = gear[i+1][6];
		}
		
		int k = Integer.parseInt(br.readLine());
		for(int _ = 0 ; _ < k ; _++) {
			for(char[] c : gear) System.out.println(Arrays.toString(c));
			System.out.println();
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			if(n == 1) {
				if(touch[0][0] != touch[0][1])  {
					if(touch[1][0] != touch[1][1]) {
						if(touch[2][0] != touch[2][1]) {
							spin(3, d*(-1));
						}
						spin(2,d);
					}
					spin(1,d*(-1));
				}
				spin(0,d);
			} else if( n == 2 ) {
				if(touch[0][0] != touch[0][1])  {
					spin(0, d * (-1));
				}
				if(touch[1][0] != touch[1][1]) {
					if(touch[2][0] != touch[2][1]) {
						spin(3, d);
					}
					spin(2,d*(-1));
				}
				spin(1, d);
			} else if(n == 3) {
				if(touch[2][0] != touch[2][1])  {
					spin(3, d * (-1));
				}
				if(touch[1][0] != touch[1][1]) {
					if(touch[0][0] != touch[0][1]) {
						spin(0, d);
					}
					spin(1,d*(-1));
				}
				spin(2, d);
			} else if(n == 4) {
				if(touch[2][0] != touch[2][1])  {
					if(touch[1][0] != touch[1][1]) {
						if(touch[0][0] != touch[0][1]) {
							spin(0, d*(-1));
						}
						spin(1,d);
					}
					spin(2,d*(-1));
				}
				spin(3,d);
			}
			
			for(int i = 0 ; i < 3 ; i++) {
				touch[i][0] = gear[i][2];
				touch[i][1] = gear[i+1][6];
			}
		}
		int n = 1;
		int ans = 0;
		for(int i = 0 ; i < 4; i++) {
			if(gear[i][0] == '1') {
				ans += n;
			}
			n *= 2;
		}
		System.out.println(ans);
	}

	private static void spin(int r, int d) {
		// TODO Auto-generated method stub
		if(d == 1) {
			char tmp = gear[r][7];
			for(int i = 7 ; i > 0 ; i--) {
				gear[r][i] = gear[r][i-1];
			}
			gear[r][0] = tmp;
		} else {
			char tmp = gear[r][0];
			for(int i = 0 ; i < 7 ; i++) {
				gear[r][i] = gear[r][i+1];
			}
			gear[r][7] = tmp;
		}
	}
}
