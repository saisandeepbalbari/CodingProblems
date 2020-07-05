
import java.util.Scanner;

public class MaxEqualLengthSticks {

	public static void main(String[] args) {
		
		int t, i, n, result=0;
		
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();
		
		if(t>1000)
			return;
		
		for(i=0; i<t; i++) {
			
			n = sc.nextInt();
			
			if(n>1000000000)
				return;
			
			else if(n%2 == 0)
				result = n/2;
			else if(n%2 == 1)
				result = ((n+1)/2);
			
			System.out.println(result);
			
		}
		
		sc.close();
	}
}
