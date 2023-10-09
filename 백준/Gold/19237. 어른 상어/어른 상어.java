import java.util.Scanner;

public class Main {
	static final int[] dx= {0, -1, 1, 0, 0};
	static final int[] dy= {0, 0, 0, -1, 1};
	static int N, M, K;
	static int[][][] board; //scent, duration
	static byte[] direction;
	static int[][] pointer;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		K=sc.nextInt();
		direction=new byte[M+1];
		pointer=new int[M+1][2];
		byte[][][] movemap=new byte[M+1][5][5];
		board=new int[N+1][N+1][2];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int a=sc.nextInt();
				if(a!=0) {
					board[i][j][0]=a;
					board[i][j][1]=K;
					pointer[a][0]=i;
					pointer[a][1]=j;
				}
			}
		}
		for(int i=1; i<=M; i++) {
			direction[i]=sc.nextByte();
		}
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=4; j++) {
				for(int a=1; a<=4; a++) {
					movemap[i][j][a]=sc.nextByte();
				}
			}
		}
		int time=0;
		int kill=0;
		while(time<1000) {
			time++;
			//이동
			outer:for(int i=1; i<=M; i++) {
				if(direction[i]!=0) {
					for(int j=1; j<=4; j++) {
						int nx=pointer[i][0]+dx[movemap[i][direction[i]][j]];
						int ny=pointer[i][1]+dy[movemap[i][direction[i]][j]];
						if(nx>=1 && nx<=N && ny>=1 && ny<=N) {
							if(board[nx][ny][0]==0) {
								pointer[i][0]=nx;
								pointer[i][1]=ny;
								direction[i]=(byte)movemap[i][direction[i]][j];
								continue outer;
							}
						}
					}
					for(int j=1; j<=4; j++) {
						int nx=pointer[i][0]+dx[movemap[i][direction[i]][j]];
						int ny=pointer[i][1]+dy[movemap[i][direction[i]][j]];
						if(nx>=1 && nx<=N && ny>=1 && ny<=N) {
							if(board[nx][ny][0]==i) {
								pointer[i][0]=nx;
								pointer[i][1]=ny;
								direction[i]=(byte)movemap[i][direction[i]][j];
								continue outer;
							}
						}
					}
				}
			}
			//겹치는가?
			boolean temp[][]=new boolean[N+1][N+1];
			for(int i=1; i<=M; i++) {
				if(direction[i]==0) continue;
				if(temp[pointer[i][0]][pointer[i][1]]) {
					kill++;
					direction[i]=0;
				}else {
					temp[pointer[i][0]][pointer[i][1]]=true;
				}
			}
			//혼자 남았는가?
			if(kill==M-1) {
				System.out.println(time);
				System.exit(0);
			}
			//냄새 지우기
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(board[i][j][1]<=1) {
						board[i][j][0]=0;
						board[i][j][1]=0;
					}else {
						board[i][j][1]--;
					}
				}
			}
			//냄새 뿌리기
			for(int i=1; i<=M; i++) {
				if(direction[i]!=0) {
					board[pointer[i][0]][pointer[i][1]][0]=i;
					board[pointer[i][0]][pointer[i][1]][1]=K;
				}
			}
		}
		System.out.println(-1);
	}

}