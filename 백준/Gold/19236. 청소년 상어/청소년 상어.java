import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int[] dx= {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy= {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[][][] board=new int[4][4][2];
	static int x, y, sum, ans=0;
	static Stack<int[][][]> savefile=new Stack<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				board[i][j][0]=sc.nextInt();
				board[i][j][1]=sc.nextInt();
			}
		}
		x=0;
		y=0;
		sum+=board[0][0][0];
		board[0][0][0]=0;
		dup();
		System.out.println(ans);
	}
	private static void dup() {
		move();
		save();
		boolean flag=true;
		for(int i=1; i<4; i++) {
			int nx=x+dx[board[x][y][1]]*i;
			int ny=y+dy[board[x][y][1]]*i;
			if(nx<0 || nx>=4 || ny<0 || ny>=4) break;
			if(board[nx][ny][0]==0) continue;
			flag=false;
			int temp=x;
			int temp2=y;
			x=nx;
			y=ny;
			sum+=board[nx][ny][0];
			board[nx][ny][0]=0;
			dup();
			x=temp;
			y=temp2;
			load();
			sum-=board[nx][ny][0];
		}
		if(flag) {
			ans=Math.max(ans, sum);
		}
		savefile.pop();
	}
	private static void move() {
		outer:for(int num=1; num<=16; num++) {
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(board[i][j][0]==num) {
						int nx=i+dx[board[i][j][1]];
						int ny=j+dy[board[i][j][1]];
						while(nx<0 || nx>=4 || ny<0 || ny>=4 || (x==nx && y==ny)) {
							board[i][j][1]++;
							if(board[i][j][1]==9) board[i][j][1]=1; 
							nx=i+dx[board[i][j][1]];
							ny=j+dy[board[i][j][1]];
						}
						int temp=board[i][j][0];
						int temp2=board[i][j][1];
						board[i][j][0]=board[nx][ny][0];
						board[i][j][1]=board[nx][ny][1];
						board[nx][ny][0]=temp;
						board[nx][ny][1]=temp2;
						continue outer;
					}
				}
			}
		}
	}
	private static void save() {
		int[][][] temp=new int[4][4][2];
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				temp[i][j]=board[i][j].clone();
			}
		}
		savefile.add(temp);
	}
	private static void load() {
		int[][][] temp=savefile.peek();
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				board[i][j]=temp[i][j].clone();
			}
		}
	}
}