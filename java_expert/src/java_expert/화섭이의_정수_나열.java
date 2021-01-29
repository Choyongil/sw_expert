package java_expert;

import java.util.Scanner;
 
public class 화섭이의_정수_나열 {
      
    public static void main(String[] args){
 
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for (int tc = 1; tc <= T; tc++) {
             
            int n = sc.nextInt();
             
            String s = "";
             
            for(int i = 0 ; i < n ; i++) {
                s += sc.next();
            }
 
            int ans = 0;
            while(true) {
                if (!s.contains(Integer.toString(ans++))){
                    System.out.println("#" + tc + " " + --ans);
                    break;
                }
            }
        }
    }
}