package week0201_0205;

public class 부분집합 {
	
	static boolean[] isSelected = new boolean[3];
	static int[] arr = {1,2,3};
	
	public static void main(String[] args) {
		
		func(0);
		
	}
	
	public static void func(int idx) {
		
		if(idx == 3) {
			for(int i = 0 ; i < 3 ; i++) {
				if(isSelected[i]) {
					System.out.print(arr[i]+ " ");
				}
			}
			System.out.println();
			return; 
		}
		
		isSelected[idx] = true;
		func(idx+1);
		isSelected[idx] = false;
		func(idx+1);
	}
}
