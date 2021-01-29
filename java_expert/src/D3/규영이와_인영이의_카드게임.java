package D3;

import java.util.Scanner;

public class 규영이와_인영이의_카드게임 {
     
    static int MAX_SCORE = 19 * 9;
    static int ans;
    static int[] arr;
    static int[] brr;
     
    public static void main(String[] args){
 
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder("");
         
        for (int tc = 1; tc <= T; tc++) {
             
            ans = 0;
            sb.append("#" + tc + " ");
             
            boolean[] b = new boolean[18];
            arr = new int[9];
            brr = new int[9];
            boolean[] visit = new boolean[9];
             
            for(int i = 0 ; i < 9 ; i++) {
                arr[i] = sc.nextInt();
                b[arr[i]-1] = true;
            }
 
            int idx = 0;
            for(int i = 1 ; i < 19 ; i++) {
                if(!b[i-1]) {
                    brr[idx++] = i;
                }
            }
             
            func(visit,0,0,0);
             
            sb.append(ans + " " + (9*8*7*6*5*4*3*2 - ans));
            System.out.println(sb);
            sb.setLength(0);
        }
         
        sc.close();
         
    }
    public static void func(boolean[] f, int arr_idx, int win, int lose) {
        if (MAX_SCORE / 2 < win) {
            int a = 1;
            for(int i = 9 - arr_idx ; i >= 1 ; i--) {
                a *= i;
            }
            ans += a;
            return;
        }
        if (MAX_SCORE / 2 < lose) return;
         
        for (int i = 0 ; i < 9 ; i++) {
            if (!f[i]) {
                f[i] = true;
                if( arr[arr_idx] > brr[i]) func(f, arr_idx + 1, win + arr[arr_idx] + brr[i], lose);
                else func(f, arr_idx + 1, win, lose + arr[arr_idx] + brr[i]);
                f[i] = false;
            }
        }
         
    }
}
