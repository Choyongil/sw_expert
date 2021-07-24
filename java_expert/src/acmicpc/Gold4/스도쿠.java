package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스도쿠 {

	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[9][9];
		for(int i = 0 ; i < 9 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 9 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go();
		
	}
	
	public static void go() {
		
		int zeroR = -1;
		int zeroC = -1;
		out : for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				if(map[i][j] == 0) {
					zeroR = i;
					zeroC = j;
					break out;
				}
			}
		}

		if(zeroR == -1) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i < 9 ; i ++) {
				for(int j = 0 ; j < 9 ; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.setLength(sb.length() - 1);
				sb.append("\n");
			}
			sb.setLength(sb.length() - 1);
			System.out.println(sb);
		
			System.exit(0);
		}
		
		for(int num = 1 ; num < 10 ; num++) {
			if(checkV(zeroC, num) && checkH(zeroR, num) && check3x3(zeroR, zeroC, num)) {
				map[zeroR][zeroC] = num;
				go();
			}
			map[zeroR][zeroC] = 0;
		}
		return;
	}

	// 세로 9 줄 검사
	public static boolean checkV(int j, int n) {

		for(int i = 0 ; i < 9 ; i++) {
			if(map[i][j] == n) return false;
		}
		return true;
	}

	// 가로 9 줄 검사
	public static boolean checkH(int i, int n) {
		
		for(int j = 0 ; j < 9 ; j++) {
			if(map[i][j] == n) return false;
		}
		return true;
		
	}

	// 세로 9 줄 검사
	public static boolean check3x3(int r, int c, int n) {

		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				if(map[r / 3 * 3 + i][c / 3 * 3 + j] == n) return false;
			}
		}
		
		return true;
	}
}
