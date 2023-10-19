import java.util.Scanner;

public class Main {
	static Scanner sc= new Scanner(System.in);
	static int gear=0;
	static int[] endpoint= {0,0};
	static int[] startpoint= {0,0};
	static int ans=0;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static int nx;
	static int ny;
	static int cx;
	static int cy;
	public static void main(String[] args) {
		int N=sc.nextInt();
		int[][] board= new int[N][N];
		int A=sc.nextInt();
		board[0][0]=1;
		for(int i=0; i<A; i++) {
			board[sc.nextInt()-1][sc.nextInt()-1]=-1;
		}
		int C=sc.nextInt();
		board=move(board, startpoint, endpoint, C);
		
	}
	static int[][] move(int[][] a, int[] b, int[] c, int d){
		int cnt=1;
		int cnt2=1;
		int D=0;
		char e=0;
		for(int j=0; j<=d; j++) {
			if(j<d) {
			D=sc.nextInt();
			e=sc.next().charAt(0);
			}else {
				D=999999;
			}
			for(int i=cnt; i<=D; i++) {
			try{
				nx=b[0]+dx[gear];
				ny=b[1]+dy[gear];
				cnt2++;
				switch(a[nx][ny]) {
				case 0:
					b[0]=nx;
					b[1]=ny;
					a[nx][ny]=cnt2;
					int pointer=a[c[0]][c[1]]+1;
					for(int sf=0; sf<4; sf++) {
						if(c[0]+dx[sf]>=a.length || c[0]+dx[sf]<0 || c[1]+dy[sf]>=a.length || c[1]+dy[sf]<0) continue;
						if(a[c[0]+dx[sf]][c[1]+dy[sf]]==pointer) {
							a[c[0]][c[1]]=0;
							c[0]+=dx[sf];
							c[1]+=dy[sf];
							break;
						}	
					}
					break;
				case -1:
					b[0]=nx;
					b[1]=ny;
					a[nx][ny]=cnt2;
					break;
				default :
					throw new ArrayIndexOutOfBoundsException();
				}
			}catch(ArrayIndexOutOfBoundsException err) {
				ans=cnt;
				System.out.println(ans);
				System.exit(0);
			}
			cnt++;
			}
			if(j<d) {
			if(e=='D') {
				if(gear==3) gear=0;
				else gear++;
			}else {
				if(gear==0) gear=3;
				else gear--;
			}
			
			}
		}
		return null;

	}
	
}