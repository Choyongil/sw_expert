package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 하나로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int n = Integer.parseInt(br.readLine());			
			double[] xArr = new double[n];
			double[] yArr = new double[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				xArr[i] = Double.parseDouble(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				yArr[i] = Double.parseDouble(st.nextToken());
			}

			double[][] arr = new double[n][n];
			for(int i = 0 ; i < n ; i++) {
				for(int j = i + 1 ; j < n ; j++) {
					if(i == j) continue;
					arr[i][j] = Math.sqrt(
							(xArr[i] - xArr[j])*(xArr[i] - xArr[j]) + 
							(yArr[i] - yArr[j])*(yArr[i] - yArr[j]));
					arr[j][i] = arr[i][j];
				}
			}
			
			double e = Double.parseDouble(br.readLine());
			
			boolean[] visited = new boolean[n];
			double[] minEdge = new double[n];
			Arrays.fill(minEdge, Double.MAX_VALUE);
			minEdge[0] = 0;
			
			double sum = 0;
			for(int i = 0 ; i < n ; i++) {
				
				double min = Double.MAX_VALUE;
				int minVertex = 0;
				
				for(int j = 0 ; j < n ; j++) {
					if(!visited[j] && min > minEdge[j]) {
						min = minEdge[j];
						minVertex = j;
					}
				}
				
				sum += e * Math.pow(min, 2);
				visited[minVertex] = true;
				
				for(int j = 0 ; j < n ; j++) {
					if(!visited[j] && minEdge[j] > arr[minVertex][j]) {
						minEdge[j] = arr[minVertex][j];
					}
				}
			}
			
			sb.append(Math.round(sum)).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
