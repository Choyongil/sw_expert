package D4;

import java.util.Scanner;

public class 쇠막대기_자르기 {
    
    public static void main(String[] args){
 
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for (int tc = 1; tc <= T; tc++) {
             
            int ans = 0;
 
            char[] str = sc.next().toCharArray();
             
            int sum = 0;
            for(int i = 0 ; i < str.length ; i++) {
                if (str[i] == '(') {
                    sum++;
                } else {
                    sum--;
                    if (str[i-1] == '(') {
                        ans += sum;
                    }  else {
                        ans += 1;
                    }
                }
            }
             
            System.out.println("#" + tc + " " + ans);
             
        }
    }       
}