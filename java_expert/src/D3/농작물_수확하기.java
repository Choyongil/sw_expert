package D3;

import java.util.Scanner;

public class 농작물_수확하기 {
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for (int tc = 1 ; tc <= T ; tc++) {
             
            int n = sc.nextInt();
             
            int[][] arr = new int[n][n];
             
            for (int i = 0 ; i < n; i++) {
                String str = sc.next();
                for (int j = 0 ; j < str.length(); j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }
             
            int[] ig = new int[(n - 1) / 2];
            int[] ad = new int[(n - 1) / 2];
             
            for (int i = 0; i < (n-1) / 2; i++) {
                ig[i] = n / 2 - i;
            }
             
            for (int i = 0; i < (n-1) / 2; i++) {
                ad[i] = 2*(i+1) - 1;
            }
 
            int sum = 0;
            for (int i = 0; i < ig.length; i++) {
                for (int j = 0; j < ad[i]; j++) {
                    sum += arr[i][ig[i]+j] + arr[arr.length - i - 1][ig[i]+j];
                }
            }
            for (int i = 0; i < arr.length; i++) {
                sum += arr[arr.length / 2][i];
            }
 
            System.out.format("#%d %d\n", tc, sum);
        }
    }
}