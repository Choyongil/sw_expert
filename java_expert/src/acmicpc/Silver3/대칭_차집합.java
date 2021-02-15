package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 대칭_차집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashSet<String> arr = new HashSet<String>();
		HashSet<String> retain = new HashSet<String>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n ; i++) {
			String s = st.nextToken();
			arr.add(s);
			retain.add(s);
		}
		HashSet<String> arr2 = new HashSet<String>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < m ; i++) {
			arr2.add(st.nextToken());
		}
		retain.retainAll(arr2);
		int x = retain.size();
		System.out.println(arr.size() - x + arr2.size() - x);
	}
}
