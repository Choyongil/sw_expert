package acmicpc.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 잃어버린_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		List<String> list = new ArrayList<String>();
		
		int i = 0;
		while(true) {
			String s = "";
			while(i < str.length() && str.charAt(i) != '+' && str.charAt(i) != '-') {
				s += str.substring(i, i+1);
				i++;
			}
			list.add(s);
			if(i == str.length()) break;
			list.add(str.substring(i, ++i));
		}
		
		int ans = 0;
		int sum = 0;
		for(i = list.size() - 1; i >= 0 ; i--) {
			if(!list.get(i).equals("+") &&!list.get(i).equals("-")) {
				sum += Integer.parseInt(list.get(i));				
			}
			else if (list.get(i).equals("-")) {
				ans -= sum;
				sum = 0;
			}
		}
		ans += sum;
		System.out.println(ans);
	}
}
