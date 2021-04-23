package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 점심_식사시간 {

	static int n, arr[][], pCnt, ans, person[];
	static List<Person> totalT;
	static List<int[]> sList, pList;
	
	static class Person{
		int id, t1, t2;			// t1 : 계단 1까지의 거리

		public Person(int id, int t1, int t2){
			this.id = id;
			this.t1 = t1;
			this.t2 = t2;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			pCnt = 0;
			sList = new ArrayList<int[]>();
			pList = new ArrayList<int[]>();
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < n ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1) {
						pCnt++;
						pList.add(new int[] {i,j});
					}
					else if(arr[i][j] > 1) sList.add(new int[] {i,j,arr[i][j]});
				}
			}
			totalT = new ArrayList<Person>();
			int r = sList.get(0)[0];
			int c = sList.get(0)[1];
			int r2 = sList.get(1)[0];
			int c2 = sList.get(1)[1];
			for(int j = 0 ; j < pCnt ; j++) {
				totalT.add(new Person(j,Math.abs(r - pList.get(j)[0]) + Math.abs(c - pList.get(j)[1]),
						Math.abs(r2 - pList.get(j)[0]) + Math.abs(c2 - pList.get(j)[1]))); 
			}
			
			ans = 987654321;
			person = new int[pCnt];
			go(0);
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	private static void go(int idx) {

		if(idx == pCnt) {
			int[][] times = new int[2][10000];
			PriorityQueue<Person> st1 = new PriorityQueue<Person>(new Comparator<Person>() {
				@Override
				public int compare(Person o1, Person o2) {
					return o1.t1 - o2.t1;
				}
			});
			PriorityQueue<Person> st2 = new PriorityQueue<Person>(new Comparator<Person>() {
				@Override
				public int compare(Person o1, Person o2) {
					return o1.t2 - o2.t2;
				}
			});
			for(int i = 0 ; i < pCnt ; i++) {
				if(person[i] == 0) {
					st1.add(totalT.get(i));
				} else {
					st2.add(totalT.get(i));
				}
			}
			
			int resultT = 0;
			while(!st1.isEmpty()) {
				Person p = st1.poll();
				int s = p.t1;
				int e = s + sList.get(0)[2];
				for(int i = s ; i < e ; i++) {
					if(times[0][i] == 3) {
						e++;
						continue;
					}
					times[0][i]++;
				}
				resultT = Math.max(resultT, e);
			}
			while(!st2.isEmpty()) {
				Person p = st2.poll();
				int s = p.t2;
				int e = s + sList.get(1)[2];
				for(int i = s ; i < e ; i++) {
					if(times[1][i] == 3) {
						e++;
						continue;
					}
					times[1][i]++;
				}
				resultT = Math.max(resultT, e);
			}
			ans = Math.min(ans, resultT+1);
			return;
		}
		person[idx] = 0;
		go(idx + 1);
		person[idx] = 1;
		go(idx + 1);
	}
}
