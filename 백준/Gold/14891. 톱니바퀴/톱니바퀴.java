import java.util.Scanner;

public class Main {
	static int[] pointer= {2, 6, 2, 6, 2, 6};
	static int[][] cog;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		cog=new int[4][8];
		
		for(int i=0; i<4; i++) {
			String input=sc.nextLine();
			for(int j=0; j<8; j++) {
				cog[i][j]=input.charAt(j)-'0';
			}
		}
		int N=sc.nextInt();
		for(int i=0; i<N; i++) {
			int[] flag= {0, 0, 0};
			if((cog[0][pointer[0]]^cog[1][pointer[1]])==1) flag[0]=1;
			if((cog[1][pointer[2]]^cog[2][pointer[3]])==1) flag[1]=1;
			if((cog[2][pointer[4]]^cog[3][pointer[5]])==1) flag[2]=1;
			int A=sc.nextInt()-1;
			int B=sc.nextInt();
			move(A,B);
			switch(A) {
			case 0:
				if(flag[0]==1) {
					move(1,-B);
					if(flag[1]==1) {
						move(2,B);
						if(flag[2]==1) {
							move(3,-B);
						}
					}
				}
				break;
			case 1:
				if(flag[0]==1) {
					move(0,-B);
				}
				if(flag[1]==1) {
					move(2,-B);
					if(flag[2]==1) {
						move(3,B);
					}
				}
				break;
			case 2:
				if(flag[2]==1) {
					move(3,-B);
				}
				if(flag[1]==1) {
					move(1,-B);
					if(flag[0]==1) {
						move(0,B);
					}
				}
				break;
			case 3:
				if(flag[2]==1) {
					move(2,-B);
					if(flag[1]==1) {
						move(1,B);
						if(flag[0]==1) {
						move(0,-B);
						}
					}
				}
				break;
			}
		}
		int ans=0;
		for(int i=0; i<6; i+=2) {
			if(cog[i/2][(pointer[i]+6)%8]==1) ans+=(int)Math.pow(2, i/2);
		}
		if(cog[3][(pointer[5]+2)%8]==1) ans+=8;
		System.out.println(ans);

	}
	static void move(int A, int B) {
		switch(A) {
		case 0:
			if(B==1) pointer[0]--;
			else pointer[0]++;
			break;
		case 1:
			if(B==1) {
				pointer[1]--;
				pointer[2]--;
			}
			else {
				pointer[1]++;
				pointer[2]++;
			}
			break;
		case 2:
			if(B==1) {
				pointer[3]--;
				pointer[4]--;
			}
			else {
				pointer[3]++;
				pointer[4]++;
			}
			break;
		case 3:
			if(B==1) pointer[5]--;
			else pointer[5]++;
			break;
		}
		for(int i=0; i<6; i++) {
			if(pointer[i]==-1) pointer[i]=7;
			if(pointer[i]==8) pointer[i]=0;
		}
	}
}