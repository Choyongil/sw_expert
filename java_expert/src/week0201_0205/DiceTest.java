package week0201_0205;

import java.io.IOException;
import java.util.Scanner;

/**
주사위를 던진 횟수 N과 출력형식 M을 입력 받아서 M의 값에 따라 각각 아래와 같이 출력하는 프로그램을 작성하시오.

M = 1 : 주사위를 N번 던져서 나올 수 있는 모든 경우 : 중복순열 
M = 2 : 주사위를 N번 던져서 모두 다른 수가 나올 수 있는 모든 경우(순서의미) : 순열 
M = 3 : 주사위를 N번 던져서 중복이 되는 경우를 제외하고 나올 수 있는 모든 경우 : 중복 조합 
M = 4 : 주사위를 N번 던져서 나온 수들의 조합(순서 무관)이 모두 다른 수가 나올 수 있는 모든 경우 : 조합 

 */
/**
 * @author THKim
 */
public class DiceTest {

    static int N, numbers[],totalCnt;
    static boolean isSelected[];
    public static void main(String[] args) throws IOException {
 
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
        numbers = new int[N];
        isSelected = new boolean[7];
         
        int M = sc.nextInt();
        totalCnt = 0;
        switch (M) {
        case 1:
            dice1(0); // 중복순열
            break;
        case 2:
            dice2(0); // 순열
            break;          
        case 3:
            dice3(0,1); // 중복조합
            break;
        case 4:
        	dice4(0,1); // 조합
        	break;

        }
      System.out.println("총 경우의 수 : "+totalCnt);
    }
 
    public static void print() {
        for (int i : numbers) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    //M = 1 : 주사위를 N번 던져서 나올 수 있는 모든 경우 : 중복순열 
    // nㅠr
    // 6ㅠ3= 6^3=216 
    public static void dice1(int cnt) {
        if(cnt == N) {
        	++totalCnt;
            print();
            return;
        }
        for(int i=1; i<=6; ++i) {
            numbers[cnt] = i;
            dice1(cnt+1);
        }
    }
    //M = 2 : 주사위를 N번 던져서 모두 다른 수가 나올 수 있는 모든 경우 : 순열 
    // nPr
    // 6P3 = 6*5*4 = 120
    private static void dice2(int cnt) {
    	if (cnt == N) {
    		++totalCnt;
    		print();
    		return;
    	}
    	for (int i = 1; i <= 6; i++) {
    		if (isSelected[i]) continue;
    		numbers[cnt] = i;
    		isSelected[i] = true;
    		dice2(cnt + 1);
    		isSelected[i] = false;
    	}
    }//end dice2 :주사위를 N번 던져서 모두 다른 수가 나올 수 있는 모든 경우
    
    
    //M = 3 : 주사위를 N번 던져서 중복이 되는 경우를 제외하고 나올 수 있는 모든 경우 : 중복 조합
    // nHr = n+r-1Cr
    // 6H3 = 6+3-1C3=8C3=56
    public static void dice3(int cnt,int start) {
        if(cnt == N) {
        	++totalCnt;
            print();
            return;
        }
        
        for(int i=start; i<=6; ++i) { // 112  -->중복 121 211
            numbers[cnt] = i;
            dice3(cnt+1,i);//현재수와 같은 수부터 처리하도록 전달
        }
    }   
 
    //M = 4 : 주사위를 N번 던져서 나온 수들의 조합(순서 무관)이 모두 다른 수가 나올 수 있는 모든 경우 : 조합 
    // nCr
    // 6C3=6!/3!3!=20
    public static void dice4(int cnt,int start) {
		
    	if(cnt==N) {
    		++totalCnt;
    		print();
    		return;
    	}
    	for (int i = start; i <= 6; i++) {
			numbers[cnt]=i;
			dice4(cnt+1,i+1);//현재수 다음 수부터 처리하도록 전달
		}
	}

}