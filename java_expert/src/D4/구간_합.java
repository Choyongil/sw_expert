package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class 구간_합 {
     
    static HashMap<Long, Long> m=new HashMap<Long, Long>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1 ; tc <= T ; tc++) {
            sb.append("#").append(tc).append(" ");
             
            m.clear();
            for (int i = 1; i < 17; i++) { 
                long v=pow10(0L+i);
                m.put((v-1L), h(v-1L));
            }
             
            st = new StringTokenizer(br.readLine());
             
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            long ans = cal(e,s);
 
            sb.append(ans).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
     
    private static long f(long n) {
        if(m.containsKey(n)) return m.get(n);
        else if(n <= 9) return n*(n+1L)/2L;
        else {
            long v = pow10(len(n));
            m.put(n, f(n-1L-n%v) + g(n));
            return m.get(n); 
        }
    }
    public static long cal(long B,long A){
        if(A<=1){
            return f(B);
        }else{
            return f(B)-f(A-1);
        }
    }
    private static long g(long n) {
        if(n <= 9) return n*(n+1L)/2L;
        else {
            long v = pow10(len(n));
            return n / v * (n % v + 1L) + f(n % v);
        }
    }
     
    public static long h(long n) {
        long len=len(n)+1L;
        return ((45L)*(len)*(1L+n))/(10L);
    }
    public static long len(long n){
        return 0L+(n+"").length()-1;
    }
    public static long pow10(long n){
        return (long)Math.pow(10, n);
    }
}