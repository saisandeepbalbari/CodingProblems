import java.util.Scanner;

public class CookieForYou {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int t, i;
		long v, c, maj, min, least;
		
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();
		
		for(i=0;i<t;i++) {
			
			v = sc.nextLong();
			c = sc.nextLong();
			maj = sc.nextLong();
			min = sc.nextLong();
			
			if(maj+min > v+c) {
				System.out.println("No");
			}
			else {
				
				if(v<c)
					least = v;
				else
					least = c;
				
				if(min<=least)
					System.out.println("Yes");
				else
					System.out.println("No");
			}
			
		}

	}

}
