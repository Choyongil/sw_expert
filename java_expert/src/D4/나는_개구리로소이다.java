package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class 나는_개구리로소이다 {

	static class Flog{
		Stack<Character> stack;
		boolean flag;
		
		public Flog() {
			super();
			this.stack = new Stack<>();
			flag = false;
		}

		char peek() {
			return stack.peek();
		}
	}
	
	static int ans, end;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			ArrayList<Flog> flogList = new ArrayList<Flog>();
			
			ans = 0;
			end = 0;
			char[] arr = br.readLine().toCharArray();
			
			for(int i = 0 ; i < arr.length ; i++) {
				
				boolean flag = false;
				
				if(arr[i] == 'c') {
					
					if(end > 0) end--;
					else ans++;
					
					Flog f = new Flog();
					f.stack.add('c');
					flogList.add(f);
					
					flag = true;
				} else if(arr[i] == 'r') {
					for(int j = 0 ; j < flogList.size() ; j++) {
						if(flogList.get(j).peek() == 'c') {
							flogList.get(j).stack.add('r');
							flag = true;
							break;
						}
					}
				} else if(arr[i] == 'o') {
					for(int j = 0 ; j < flogList.size() ; j++) {
						if(flogList.get(j).peek() == 'r') {
							flogList.get(j).stack.add('o');
							flag = true;
							break;
						}
					}
				} else if(arr[i] == 'a') {
					for(int j = 0 ; j < flogList.size() ; j++) {
						if(flogList.get(j).peek() == 'o') {
							flogList.get(j).stack.add('a');
							flag = true;
							break;
						}
					}
				} else if(arr[i] == 'k') {
					for(int j = 0 ; j < flogList.size() ; j++) {
						if(flogList.get(j).peek() == 'a') {
							flogList.get(j).stack.add('k');
							end++;
							flogList.get(j).flag = true;
							flag = true;
							break;
						}
					}
				}
				if(!flag) {
					ans = -1;
					break;
				}
			}
			for(int i = 0 ; i < flogList.size() ; i++) {
				if(!flogList.get(i).flag) {
					ans = -1;
					break;
				}
			}
			sb.append(ans == -1? -1 : ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
