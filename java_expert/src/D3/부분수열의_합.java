package D3;

import java.util.Scanner;

public class 부분수열의_합 {
    
    public static void main(String[] args){
 
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for (int tc = 1; tc <= T; tc++) {
             
            int n = sc.nextInt();
            int k = sc.nextInt();
             
            int[] arr = new int[n];
            for (int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
             
            int ans = 0;
            for(int num = 1; num < (int) Math.pow(2, n); num++) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if ((num & (1 << i)) > 0) {
                        sum += arr[i];
                        if (sum > k) break;
                    }
                }
                if (sum == k) {
                    ans += 1;
                }
            }
             
            System.out.println("#" + tc + " " + ans);
             
        }
    }       
}
