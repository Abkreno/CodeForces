package Div327;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		double n = Integer.parseInt(bf.readLine());
		double v1 = Integer.parseInt(bf.readLine());
		double v2 = Integer.parseInt(bf.readLine());
		boolean sw = false;
		if (v1 > v2) {
			double t = v1;
			v1 = v2;
			v2 = t;
			sw = true;
		}
		double x = (v1 * n) / (v1 + v2);
		if(sw){
			System.out.println(n-x);
		}else{
			System.out.println(x);
		}
	}

}
