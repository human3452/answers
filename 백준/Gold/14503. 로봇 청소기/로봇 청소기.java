import java.util.Scanner;


public class Main {
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int[][] board;
	static int x;
	static int y;
	static int N;
	static int M;
	static int gear;
	static int ans=0;
 	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		x=sc.nextInt();
		y=sc.nextInt();
		gear=sc.nextInt()+1000;
		board=new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				board[i][j]=sc.nextInt();
			}
		}
		move();
 	}
 	static void move() {
 		inner:while(true) {
 			if(board[x][y]==0) {
 				board[x][y]=2;
 				ans++;
 			}
 			//2
 			for(int i=1; i<=4; i++) {
 				int abs=gear-i;
 				if(abs<=-1) {
 					gear+=4;
 					abs+=4;
 				}
 				int nx=x+dx[abs%4];
 				int ny=y+dy[abs%4];
 				if(nx>=0 && nx<N && ny>=0 && ny<M) {
 					if(board[nx][ny]==0) {
 						x=nx;
 						y=ny;
 						gear=(gear-i)%4;
 						continue inner;
 					}
 				}
 			}
 			if(board[x-dx[gear%4]][y-dy[gear%4]]!=1) {
 				x=x-dx[gear%4];
 				y=y-dy[gear%4];
 				continue inner;
 			}else {
 				System.out.println(ans);
 				System.exit(0);
 			}
 		}
 		
 	}
}