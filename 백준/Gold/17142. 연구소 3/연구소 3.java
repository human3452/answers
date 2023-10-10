import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int dx[]= {-1, 0, 1, 0};
	static final int dy[]= {0, -1, 0, 1};
	static int board[][];
	static ArrayList<int[]> virus=new ArrayList<>();
	static int N, M;
	static int selection[];
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		selection=new int[M];
		board=new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int a=sc.nextInt();
				switch(a) {
				case 2:
					int[] temp= {i, j, 0};
					virus.add(temp);
				default:
					board[i][j]=a;
					break;
				}
			}
		}
		//입력을 받았으니, 해보자
		dup(-1, 1);
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	private static void dup(int a, int depth) {
		if(depth==M) {
			for(int i=a+1; i<virus.size(); i++) {
				selection[M-1]=i;
				check();
			}
		}else {
			for(int i=a+1; i<(virus.size()-M)+depth; i++) {
				selection[depth-1]=i;
				dup(i, depth+1);
			}
		}
	}
	private static void check() {
		//복사
		int[][] copyboard=new int[N][N];
		for(int i=0; i<N; i++) {
			copyboard[i]=board[i].clone();
		}
		Queue<int[]> queue=new LinkedList<>();
		//BFS 시작
		for(int i=0; i<M; i++) {
			queue.add(virus.get(selection[i]));
		}
		int max=0;
		while(!(queue.isEmpty())) {
			int temp[]=queue.poll();
			int x=temp[0];
			int y=temp[1];
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=N || copyboard[nx][ny]==1) continue;
				if(copyboard[nx][ny]==2) {
					copyboard[nx][ny]=1;
					int temp3[]= {nx, ny, temp[2]+1};
					queue.add(temp3);
					continue;
				}
				max=Math.max(max, temp[2]+1);
				copyboard[nx][ny]=1;
				int temp2[]= {nx, ny, temp[2]+1};
				queue.add(temp2);
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(copyboard[i][j]==0) return;
			}
		}
		min=Math.min(min, max);
	}
}