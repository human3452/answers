import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static final int[] dx= {-1, 0, 1, 0};
	static final int[] dy= {0, 1, 0, -1};
	static int[][] board;
	static int R, C, cleaner;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		R=sc.nextInt();
		C=sc.nextInt();
		int T=sc.nextInt();
		board=new int[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				board[i][j]=sc.nextInt();
				if(board[i][j]<0) cleaner=i;
			}
		}
		for(int time=0; time<T; time++) {
			//확산
			diffusion();
			//순환
			uppercirculation();
			lowercirculation();
		}
		//계산
		int sum=2;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sum+=board[i][j];
			}
		}
		System.out.println(sum);
	}
	private static void lowercirculation() {
		int gear=6;
		int x=cleaner+1;
		int y=0;
		board[x][y]=0;
		while(gear>2) {
			int shift=gear%4;
			int nx=x+dx[shift];
			int ny=y+dy[shift];
			if(nx>=R || nx<cleaner || ny<0 || ny>=C || board[nx][ny]==-1) {
				gear--;
				continue;
			}
			board[x][y]=board[nx][ny];
			x=nx;
			y=ny;
		}
		board[x][y]=0;
	}
	private static void uppercirculation() {
		int gear=0;
		int x=cleaner-2;
		int y=0;
		board[x][y]=0;
		while(gear<4) {
			int nx=x+dx[gear];
			int ny=y+dy[gear];
			if(nx<0 || nx>=cleaner || ny<0 || ny>=C || board[nx][ny]==-1) {
				gear++;
				continue;
			}
			board[x][y]=board[nx][ny];
			x=nx;
			y=ny;
		}
		board[x][y]=0;
	}
	private static void diffusion() {
		LinkedList<int[]> dust=new LinkedList<>();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(board[i][j]>4) {
					int d=board[i][j]/5;
					for(int gear=0; gear<4; gear++) {
						int nx=i+dx[gear];
						int ny=j+dy[gear];
						if(nx>=0 && nx<R && ny>=0 && ny<C && board[nx][ny]>=0) {
							board[i][j]-=d;
							int temp[]={nx, ny, d};
							dust.add(temp);
						}
					}
				}
			}
		}
		while(!(dust.isEmpty())) {
			int temp[]=dust.poll();
			board[temp[0]][temp[1]]+=temp[2];
		}
	}
	
}