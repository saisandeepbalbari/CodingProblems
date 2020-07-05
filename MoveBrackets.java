import java.util.Scanner;

public class MoveBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int t, i, balance, count, j, stringLen;
		String s;
		
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();
		
		for(i=0;i<t;i++) {
			
			stringLen = sc.nextInt();
			s = sc.next();
			
			balance = 0;
			count = 0;
			
			for(j=0;j<stringLen;j++) {
				if(s.charAt(j) == '(')
					balance++;
				else if(s.charAt(j) == ')')
					balance--;
				if(balance < 0) {
					count++;
					balance = 0;
				}
			}
			System.out.println(count);
		}
		sc.close();
	}

}
