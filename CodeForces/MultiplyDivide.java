/*
import java.util.Scanner;

public class MultiplyDivide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int t, n, i, count, len, j, sum;
		String s;
		
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();
		
		
		for(i=0; i<=t; i++) {
			s = sc.next();
			len = s.length();
			
			count = 0;
			sum = 0;
			
			for(j=0; j<len; j++) {
				sum = sum + s.charAt(j);
			}
			
			while(sum%3 == 0)
			if(sum%3 == 0) {
				sum = sum/3;
				count++;
			}
			
				while(n%3 == 0) {
					if(n%2 == 0) {
						count++;
						n = n/6;
					}
					else{
						count = count + 2;
						n = n/3;
					}
				}
			if(n==1) {
				System.out.println(count);
			}
			else {
				System.out.println(-1);
			}
		}
		
		sc.close();
		
	}

}
*/
