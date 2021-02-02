package D3;

import java.util.Scanner;

public class flatten {
	
	static int max = 0;
	static int min = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			
			sb.append("#" + tc + " ");
			
			int dump = sc.nextInt();
			
			int[] arr = new int[100];
			int max_idx = 0;
			int min_idx = 0;
			
			for(int i = 0; i < 100 ; i++) {
				int tmp = sc.nextInt();
				arr[i] = tmp;
				if(tmp > arr[max_idx]) max_idx = i;
				if(tmp < arr[min_idx]) min_idx = i;
			}
			
			System.out.print(sb);
			flat(arr, dump, max_idx, min_idx);
			sb.setLength(0);
		}
	}
	
	public static void findMaxMin(int[] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			if ( arr[max] < arr[i]) max = i;
			if ( arr[min] > arr[i]) min = i;
		}
	}
	
	public static void flat(int[] arr, int d, int max_idx, int min_idx) {
		
		if (d == 0 || arr[max_idx] - arr[min_idx] <= 1) {
			System.out.println(arr[max_idx] - arr[min_idx]);
			return;
		}
		arr[max_idx] -= 1;
		arr[min_idx] += 1;
		findMaxMin(arr);
		flat(arr, --d, max, min);
	}
	
}
