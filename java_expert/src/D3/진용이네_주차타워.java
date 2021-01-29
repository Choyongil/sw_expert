package D3;

import java.util.ArrayList;
import java.util.Scanner;
 
 
public class 진용이네_주차타워 {
      
    public static void main(String[] args){
 
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for (int tc = 1; tc <= T; tc++) {
             
            int n = sc.nextInt();
            int m = sc.nextInt();
             
            int ans = 0;
             
            int[] r_i = new int[n];
            int[] w_i = new int[m];
             
            for (int i = 0 ; i < n ; i++) {
                r_i[i] = sc.nextInt();
            }
            for (int i = 0 ; i < m ; i++) {
                w_i[i] = sc.nextInt();
            }
             
            int[] park = new int[n];
            ArrayList<Integer> wait = new ArrayList<Integer>();
             
            for(int i = 0 ; i < 2*m; i++) {
                 
                int num = sc.nextInt();
                 
                if (num > 0) {
                    int j = 0;
                    for (j = 0 ; j < n; j++) {
                        if (park[j] == 0) {
                            park[j] = num;
                            ans += w_i[num-1] * r_i[j];
                            break;
                        }
                    }
                    if (j == n) {
                        wait.add(num);
                    }
                } else {
                    for (int j = 0 ; j < n; j++) {
                        if (park[j] == Math.abs(num)) {
                            if (wait.size() == 0) park[j] = 0;
                            else {
                                park[j] = wait.get(0);
                                ans += w_i[wait.get(0)-1] * r_i[j];
                                wait.remove(0);
                            }
                            break;
                        }
                    }
                }
            }
             
            System.out.println("#" + tc + " " + ans);
             
        }
    }       
}