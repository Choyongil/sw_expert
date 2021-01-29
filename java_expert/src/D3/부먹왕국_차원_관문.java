package D3;

import java.util.Scanner;


public class 부먹왕국_차원_관문 {
      
    public static void main(String[] args){
 
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for (int tc = 1; tc <= T; tc++) {
             
            int N = sc.nextInt();
            int D = sc.nextInt();
             
            int ans = 0;
             
            int idx = -1;
             
            int[] map = new int[N];
             
            for(int i = 0 ; i < N ; i++) {
                map[i] = sc.nextInt();
            }
             
            int d = D;
            boolean flag = false;
            while (true) {
                 
                flag = false;
                d = D;
                 
                for (int i = d; i > 0; i--) {
                    if (map[idx+i] == 1) {
                        idx += i;
                        flag = true;
                        break;
                    }
                }
                 
                if (!flag) {
                    ans += 1;
                    idx += D;
                    map[idx] = 1;
                }
                 
                if (idx + D >= N) break;
            }
             
            System.out.println("#" + tc + " " + ans);
             
        }
    }       
}