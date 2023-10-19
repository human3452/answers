import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
 
	static Queue<Integer[]> queue=new LinkedList<>();
	public static void main(String[] args) {
		int[] dx= {-1, 0, 1, 0};
		int[] dy= {0, -1, 0, 1};
		Scanner sc=new Scanner(System.in);
		int M=sc.nextInt();
		int N=sc.nextInt();
		int[][] board=new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				board[i][j]=sc.nextInt();
				Integer temp[]= {i,j,0};
				if(board[i][j]==1) queue.add(temp);
			}
		}
		int max=0;
		while(!(queue.isEmpty())) {
			int x=queue.peek()[0];
			int y=queue.peek()[1];
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=M || board[nx][ny]!=0) continue;
				board[nx][ny]=1;
				int cnt=queue.peek()[2];
				cnt++;
				max=Math.max(cnt, max);
				Integer[] temp= {nx,ny, cnt};
				queue.add(temp);
			}
			queue.poll();
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j]==0) 
					{
					System.out.println(-1);
					System.exit(0);
					}
			}
		}
		System.out.println(max);
	}
}