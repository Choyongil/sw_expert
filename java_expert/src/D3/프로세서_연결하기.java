package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class 프로세서_연결하기 {
     
    static int[][] arr;
    static int ans, n, total;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= T ; tc++) {
            sb.append("#" + tc + " ");
             
            n = Integer.parseInt(br.readLine());
            ans = 987654321;
            total = 0;
            arr = new int[n][n];
            for(int i = 0 ; i < n ; i++) {
                st = new StringTokenizer(br.readLine());                
                for(int j = 0 ; j < n ;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            back(0,0);
            sb.append(ans + "\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
     
    public static void back(int cnt, int sum) {
         
        int sr = -1, sc = -1;
         
        out:for(int i = 1 ; i < n - 1 ; i++) {
            for(int j = 1 ; j < n - 1; j++) {
                if(arr[i][j] == 1) {
                    sr = i; sc = j;
                    break out;
                }
            }
        }
         
        if(sr == -1 && sc == -1) {
            if(cnt >= total) {
                if(cnt == total) ans = Math.min(ans, sum);
                else {
                    ans = sum;
                    total = cnt;
                }
            }
            return;
        }
         
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for(int d = 0 ; d < 4 ; d++) {
            int nr = sr;
            int nc = sc;
            boolean check = true;
            while(true) {
                nr += dr[d];
                nc += dc[d];
                if(nr < 0 || nr > n-1 || nc < 0 || nc > n-1) break;
                if( arr[nr][nc] > 0) {
                    check = false;
                    break;
                }   
            }
             
            if(check) {
                cnt++;
                nr = sr;
                nc = sc;
                while(true) {
                    nr += dr[d];
                    nc += dc[d];
                    if(nr < 0 || nr > n-1 || nc < 0 || nc > n-1) break;
                    arr[nr][nc] = 2;
                    sum += 1;
                }
                arr[sr][sc] = 2;
                back(cnt, sum);
                arr[sr][sc] = 1;
                cnt--;
                nr = sr;
                nc = sc;
                while(true) {
                    nr += dr[d];
                    nc += dc[d];
                    if(nr < 0 || nr > n-1 || nc < 0 || nc > n-1) break;
                    arr[nr][nc] = 0;
                    sum -= 1;
                }
            }
        }
        arr[sr][sc] = 2;
        back(cnt,sum);
        arr[sr][sc] = 1;
    }
}