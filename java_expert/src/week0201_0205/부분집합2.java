package week0201_0205;

public class 부분집합2 {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		
		for(int i = 0 ; i < 8 ; i++) {
			
			for(int j = 0 ; j < 3 ; j++) {
				if((i & (1 << j)) > 0) {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println();
		}
	}
}
