import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int[] dx= {0, 0, 0, -1, 1};
	static int[] dy= {0, 1, -1, 0, 0};
	static ArrayList<int[]> checkp=new ArrayList<>();
	static int R, C, K;
	static int[][] board, wall;
	static boolean chk[][];
	static ArrayList<int[]> fan=new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		R=sc.nextInt();
		C=sc.nextInt();
		K=sc.nextInt();
		board=new int[R+1][C+1];
		wall=new int[R+1][C+1];
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				int a=sc.nextInt();
				switch(a) {
				case 5:
					checkp.add(new int[] {i,j});
					break;
				case 0: break;
				default:
					fan.add(new int[] {i,j,a});
					break;
				}
			}
		}
		int W=sc.nextInt();
		//wall==1-> 위쪽에 벽 wall==2-> 오른쪽 벽
		for(int i=0; i<W; i++) {
			wall[sc.nextInt()][sc.nextInt()]+=(sc.nextInt()+1);
		}
		int cnt=0;
		outer:while(cnt<=100) {
			turnfanon();
			tempcontrol();
			tempdown();
			cnt++;
			for(int i=0; i<checkp.size(); i++) {
				int[] temp=checkp.get(i);
				if(board[temp[0]][temp[1]]<K) continue outer;
			}
			break;
		}
		System.out.println(cnt);
	}
	private static void tempdown() {
		for(int i=1; i<=R; i++) {
			board[i][1]=Math.max(0, board[i][1]-1);
			board[i][C]=Math.max(0, board[i][C]-1);
		}
		for(int i=2; i<=C-1; i++) {
			board[1][i]=Math.max(0, board[1][i]-1);
			board[R][i]=Math.max(0, board[R][i]-1);
		}
		
	}
	private static void tempcontrol() {
		int[][] addboard=new int[R+1][C+1];
		for(int i=R; i>=1; i--) {
			for(int j=1; j<=C; j++) {
				if(wall[i][j]==3) continue;
				if(wall[i][j]%2==0 && i>1) {
					int dif=(board[i][j]-board[i-1][j])/4;
					addboard[i][j]-=dif;
					addboard[i-1][j]+=dif;
				}
				if(wall[i][j]<2 && j<C) {
					int dif=(board[i][j]-board[i][j+1])/4;
					addboard[i][j]-=dif;
					addboard[i][j+1]+=dif;
				}
			}
		}
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				board[i][j]+=addboard[i][j];
			}
		}
		
	}
	private static void turnfanon() {
		for(int i=0; i<fan.size(); i++) {
			chk=new boolean[R+1][C+1];
			int[] f=fan.get(i);
			int nx=f[0]+dx[f[2]];
			int ny=f[1]+dy[f[2]];
			warm(nx, ny, f[2], 5); // r, c, direc, depth
		}
	}
	private static void warm(int r, int c, int direc, int depth) {
		if(depth==0 || chk[r][c]) return;
		board[r][c]+=depth;
		chk[r][c]=true;
		switch(direc) {
		case 1:
			if(c+1>C) return;
			if(r>=2 && wall[r][c]%2==0 && wall[r-1][c]<2) {
				warm(r-1, c+1, direc, depth-1);
			}
			if(wall[r][c]<2) {
				warm(r, c+1, direc, depth-1);
			}
			if(r+1<=R && wall[r+1][c]==0) {
				warm(r+1, c+1, direc, depth-1);
			}
			break;
		case 2:
			if(c<2) return; 
			if(wall[r][c-1]<2) {
				warm(r, c-1, direc, depth-1);
			}
			if(wall[r][c]%2==0 && r>=2 && wall[r-1][c-1]<2) {
				warm(r-1, c-1, direc, depth-1);
			}
			if(r+1<=R && wall[r+1][c]%2==0 && wall[r+1][c-1]<2) {
				warm(r+1, c-1, direc, depth-1);
			}
			break;
		case 3:
			if(r<2) return;
			if(wall[r][c]%2==0) {
				warm(r-1, c, direc, depth-1);
			}
			if(c>=2 && wall[r][c-1]==0) {
				warm(r-1, c-1, direc, depth-1);
			}
			if(c+1<=C && wall[r][c]<2 && wall[r][c+1]%2==0) {
				warm(r-1, c+1, direc, depth-1);
			}
			break;
		case 4:
			if(r+1>R) return;
			if(wall[r+1][c]%2==0) {
				warm(r+1, c, direc, depth-1);
			}
			if(wall[r][c]<2 && c+1<=C && wall[r+1][c+1]%2==0) {
				warm(r+1, c+1, direc, depth-1);
			}
			if(c>=2 && wall[r][c-1]<2 && wall[r+1][c-1]%2==0) {
				warm(r+1, c-1, direc, depth-1);
			}
			break;
		}
	}
}
