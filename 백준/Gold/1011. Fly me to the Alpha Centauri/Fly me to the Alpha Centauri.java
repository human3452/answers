import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			int a=-(sc.nextInt()-sc.nextInt());
			int b=0;
			for(int i=1; i<Integer.MAX_VALUE; i++) {
				b+=i*2;
				if(a<=Math.pow(i, 2)) {
					System.out.println(2*i-1);
					break;
				}else if(a<=b) {
					System.out.println(2*i);
					break;
				}
			}
			
		}

	}

}