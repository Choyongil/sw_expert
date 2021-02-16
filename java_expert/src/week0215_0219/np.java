package week0215_0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class np {
	
	static int[] input;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		input = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		
		for( int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
		do{
			System.out.println(Arrays.toString(input));
		} while(nextper());
		
	}
	
	public static boolean nextper() {
		
		int i = n - 1;
		while( i > 0 && input[i - 1] > input[i] ) i--;
		
		if( i == 0 ) return false;
		
		int j = n - 1;
		while( input[i - 1] > input[j]) j--;
		
		swap(i - 1,j);
		
		int k = n - 1;
		while(i < k) swap(i++, k--);
		
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
