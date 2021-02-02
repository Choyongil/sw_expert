package D4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ladder1 {
	static int[][] arr;
	static ArrayList<Integer> start;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			
			int T = sc.nextInt();
			
			sb.append("#" + T + " ");
			
			arr = new int[100][100];
			start = new ArrayList<Integer>();
			
			for(int i = 0 ; i < 100 ; i++) {
				for (int j = 0 ; j < 100 ; j++) {
					arr[i][j] = sc.nextInt();
					if (i == 0 && arr[i][j] == 1) start.add(j);
				}
			}
			
			for( int i = 0 ; i < start.size(); i++) {
				if(func(0, start.get(i), i)) {
					sb.append(start.get(i));
					break;
				}
			}

			System.out.println(sb);
			sb.setLength(0);
			
		}
	}

	public static boolean func(int r, int c, int idx) {
		if (r == 99) {
			if(arr[r][c] == 2) { 
				return true;
			}
			return false;
		}
		else if(c > 0 && arr[r][c - 1] == 1) {
			return func(r + 1, start.get(idx - 1), idx - 1);
		} else if(c < 99 && arr[r][c + 1] == 1) {
			return func(r + 1, start.get(idx + 1), idx + 1);
		} else {
			return func(r + 1, c, idx);
		}
	}
}
