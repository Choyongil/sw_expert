package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 괄호_짝짖기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			
			sb.append("#" + tc + " ");
			
			Stack<String> a = new Stack<String>();
			Stack<String> b = new Stack<String>();
			Stack<String> c = new Stack<String>();
			Stack<String> d = new Stack<String>();
			
			Integer.parseInt(br.readLine());
			String[] input = br.readLine().split("");
			boolean flag = true;

			for( String s : input) {

				if(s.equals("(")) a.add(s);
				else if(s.equals("[")) b.add(s);
				else if(s.equals("{")) c.add(s);
				else if(s.equals("<")) d.add(s);
				else if(s.equals(")")) {
					try{
						a.pop();
					} catch(Exception e) {
						flag = false;
						break;
					}
				}
				else if(s.equals("]")) {
					try{
						b.pop();
					} catch(Exception e) {
						flag = false;
						break;
					}
				}
				else if(s.equals("}")) {
					try{
						c.pop();
					} catch(Exception e) {
						flag = false;
						break;
					}
				}
				else if(s.equals(">")) {
					try{
						d.pop();
					} catch(Exception e) {
						flag = false;
						break;
					}
				}
			}
			int ans = flag == true && a.size() + b.size() + c.size() + d.size() == 0 ? 1 : 0;
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
