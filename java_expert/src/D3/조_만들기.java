package D3;
import java.util.Scanner;
 
public class 조_만들기 {
      
    public static void main(String[] args){
 
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        StringBuilder sb = new StringBuilder("");
         
        for (int tc = 1; tc <= T; tc++) {
             
            sb.append("#" + tc + " ");
             
            int n = sc.nextInt();
            int k = sc.nextInt();
             
            int[][] stu = new int[n][k];
            int num = 1;
             
            for(int i = 0 ; i < n ; i++) {
                 
                if (i % 2 == 0) {
                    for(int j = 0 ; j < k ; j++) {
                        stu[i][j] = num++;
                    }
                } else {
                    for(int j = k-1; j >= 0 ;j--) {
                        stu[i][j] = num++;
                    }
                }
            }
             
            for(int i = 0 ; i < k ; i++) {
                int sum = 0;
                for(int j = 0 ; j < n ; j++) {
                    sum += stu[j][i];
                }
                sb.append(sum + " ");
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}