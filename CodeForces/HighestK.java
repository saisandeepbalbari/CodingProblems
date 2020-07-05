
import java.util.Scanner;

public class HighestK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int t, x, y, n, i, remainder;
		
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();
		
		
		for(i=0; i<t; i++) {
			
			x = sc.nextInt();
			y = sc.nextInt();
			n = sc.nextInt();
			
			remainder = n%x;
			
			if(y == remainder) {
				System.out.println(n);
			}
			else if (y < remainder) {
				System.out.println(n-remainder+y);
			}
			else {
				System.out.println(n-x+y-remainder);
			}
		}
		sc.close();
	}

}
