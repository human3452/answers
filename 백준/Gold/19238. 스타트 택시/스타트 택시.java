import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, fuel;
	static int[][] board;
	static int[] taxi=new int[3];
	static ArrayList<int[]> passenger=new ArrayList<>();
	static final int[] dx= {-1, 0, 0, 1};
	static final int[] dy= {0, -1, 1, 0};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		fuel=sc.nextInt();
		board=new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				board[i][j]=-sc.nextInt();
			}
		}
		taxi[0]=sc.nextInt();
		taxi[1]=sc.nextInt();
		for(int i=0; i<M; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			board[x][y]++;
			passenger.add(new int[] {x,y,sc.nextInt(),sc.nextInt()});
		}
		for(int ad=0; ad<M; ad++) {
			//승객 받기
			Queue<int[]> queue=new LinkedList<>();
			int[] current= {500,500,5000};
			boolean seq=false;
			int[] destination=new int[2];
			taxi[2]=0;
			boolean[][] chk=new boolean[N+1][N+1];
			if(board[taxi[0]][taxi[1]]>0) {
				for(int[] x : passenger) {
					if(x[0]==taxi[0] && x[1]==taxi[1]) {
						destination[0]=x[2];
						destination[1]=x[3];
						board[x[0]][x[1]]--;
						seq=true;
						break;
					}
				}
			}else {
			queue.add(taxi);
			while(!queue.isEmpty()) {
				int[] temp=queue.poll();
				if(temp[2]>=fuel || temp[2]>current[2]) break;
				
				chk[temp[0]][temp[1]]=true;
				for(int i=0; i<4; i++) {
					int nx=temp[0]+dx[i];
					int ny=temp[1]+dy[i];
					if(nx>=1 && nx<=N && ny>=1 && ny<=N && board[nx][ny]!=-1 && !chk[nx][ny]) {
						if(board[nx][ny]!=0) {
							if(current[0]>nx || (current[0]==nx && current[1]>ny)) {
								current[0]=nx;
								current[1]=ny;
								current[2]=temp[2];
								seq=true;
							}
						}else {
							chk[nx][ny]=true;
							queue.add(new int[] {nx, ny, temp[2]+1});
						}
					}
				}
			}
			}
			for(int[] x : passenger) {
				if(x[0]==current[0] && x[1]==current[1]) {
					destination[0]=x[2];
					destination[1]=x[3];
					board[current[0]][current[1]]--;
					taxi[0]=x[0];
					taxi[1]=x[1];
					fuel-=(current[2]+1);
					seq=true;
					break;
				}
			}
			if(!seq) {
				System.out.println(-1);
				System.exit(0);
			}
			queue.clear();
			//배달하기
			queue.add(taxi);
			if(destination[0]==taxi[0] && destination[1]==taxi[1]) {
				seq=false;
			}else {
				int[][] chk2=new int[N+1][N+1];
				chk2[destination[0]][destination[1]]=-1;
			outer:while(!queue.isEmpty()) {
				int[] temp=queue.poll();
				if(temp[2]>=fuel) break;
				chk2[temp[0]][temp[1]]=1;
				for(int i=0; i<4; i++) {
					int nx=temp[0]+dx[i];
					int ny=temp[1]+dy[i];
					if(nx>=1 && nx<=N && ny>=1 && ny<=N && board[nx][ny]!=-1 && chk2[nx][ny]!=1) {
						if(chk2[nx][ny]==-1) {
							fuel+=(temp[2]+1);
							taxi[0]=nx;
							taxi[1]=ny;
							seq=false;
							break outer;
						}else {
							chk2[nx][ny]=1;
							queue.add(new int[] {nx, ny, temp[2]+1});
						}
					}
				}
			}
			}
			if(seq) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		System.out.println(fuel);
	}

}