import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static final byte[] dx= {-1, 0, 1, 0};
	static final byte[] dy= {0, 1, 0, -1};
	static int N;
	static int[][] board;
	static boolean chk1[][];
	static Queue<int[]> corner=new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		board=new int[N][N];
		chk1=new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j]=sc.nextInt();
			}
		}
		int cnt=2;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(board[i][j]==1) {
					paint(i, j, cnt);
					cnt++;
				}
			}
		}
		//색칠 완료
		//코너에서 찾아보자!
		int min=Integer.MAX_VALUE;
		int[][] checked=new int[N][N];
		while(!(corner.isEmpty())) {
			int[] temp=corner.poll(); // r, c, island, depth
			if(-temp[3]>=min) break;
			for(int i=0; i<4; i++) {
				int nx=temp[0]+dx[i];
				int ny=temp[1]+dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=N || board[nx][ny]==temp[2]) continue;
				if(board[nx][ny]==0) {
					board[nx][ny]=temp[2];
					checked[nx][ny]=temp[3]-1;
					int temp2[]= {nx, ny, temp[2], temp[3]-1};
					corner.add(temp2);
				}else{
					min=Math.min(Math.abs(checked[nx][ny])+Math.abs(checked[temp[0]][temp[1]]), min);
				}
			}
		}
		System.out.println(min);
	}
	private static void paint(int a, int b, int cnt) {
		Queue<int[]> queue=new LinkedList<>();
		int[] init= {a, b};
		board[a][b]=cnt;
		queue.add(init);
		while(!(queue.isEmpty())) {
			int[] temp=queue.poll();
			for(int i=0; i<4; i++) {
				int nx=temp[0]+dx[i];
				int ny=temp[1]+dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=N || board[nx][ny]==cnt) continue;
				if(board[nx][ny]==0) {
					if(!(chk1[temp[0]][temp[1]])) {
					int cn[]= {temp[0], temp[1], cnt, 0};
					corner.add(cn);
					chk1[cn[0]][cn[1]]=true;
					}
					continue;
				}
				board[nx][ny]=cnt;
				int[] temp2= {nx, ny};
				queue.add(temp2);
			}
		}
	}
}