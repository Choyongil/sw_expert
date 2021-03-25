package D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class 사람_네트워크2 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1 ; tc <= T ; tc++) {
            sb.append("#").append(tc).append(" ");
             
            st = new StringTokenizer(br.readLine());
             
            int n = Integer.parseInt(st.nextToken());
             
            int[][] arr = new int[n][n];
             
            for(int i = 0 ; i < n ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    int x = Integer.parseInt(st.nextToken());
                    arr[i][j] = x;
                    arr[i][j] = arr[i][j] == 0? 987654321 : arr[i][j];
                }
            }
             
            for(int k = 0 ; k < n ; k++) {
                for(int i = 0 ; i < n ; i++) {
                    for(int j = 0 ; j < n ; j++) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
 
            int ans = Integer.MAX_VALUE;
            for(int i = 0 ; i < n ; i++) {
                int sum = 0;
                boolean flag = true;
                for(int j = 0 ; j < n ; j++) {
                    sum += arr[i][j];
                    if(ans < sum) {
                    	flag = false;
                    	break;
                    }
                }
                if(flag) ans = Math.min(ans, sum);
            }
            sb.append(ans).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}