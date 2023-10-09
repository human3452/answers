import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final byte[] dx= {-1, 0, 1, 0};
	static final byte[] dy= {0, 1, 0, -1};
	static int N, M;
	static int[][] board;
	static boolean chk1[][];
	static int[][] distance;
	static int[] p;
	static Queue<int[]> corner=new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		board=new int[N][M];
		chk1=new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				board[i][j]=sc.nextInt();
			}
		}
		int cnt=2;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j]==1) {
					paint(i, j, cnt);
					cnt++;
				}
			}
		}
		distance=new int[cnt][cnt];
		for(int i=2; i<cnt; i++) {
			for(int j=2; j<cnt; j++) {
				distance[i][j]=Integer.MAX_VALUE;
			}
		}
		// 색칠 완료
		outer:while(!corner.isEmpty()) {
			int[] temp=corner.poll(); // r, c, island, direction
			int nx=temp[0];
			int ny=temp[1];
			for(int i=1; i<12; i++) {
				nx+=dx[temp[3]];
				ny+=dy[temp[3]];
				if(nx<0 || ny<0 || nx==N || ny==M || board[nx][ny]==temp[2]) continue outer;
				if(board[nx][ny]!=0) {
					if(i<=2) continue outer;
					distance[temp[2]][board[nx][ny]]=Math.min(i-1, distance[temp[2]][board[nx][ny]]);
					continue outer;
				}
			}
		}
		PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] p1, int[] p2) {
				return p1[2]-p2[2];
			}
		});
		for(int i=2; i<cnt; i++) {
			for(int j=i+1; j<cnt; j++) {
				if(distance[i][j]!=Integer.MAX_VALUE) {
					pq.add(new int[] {i,j,distance[i][j]});
				}
			}
		}
		//크루스칼
		p=new int[cnt];
		int ans=0;
		for(int i=2; i<cnt; i++) {
			p[i]=i;
		}
		int selected=0;
		while(!pq.isEmpty()) {
			int[] temp=pq.poll();
			if(findset(temp[0])!=findset(temp[1])) {
				union(temp[0], temp[1]);
				ans+=temp[2];
				selected++;
			}
			if(selected==(cnt-3)) break;
		}
		if(selected!=cnt-3) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}
	private static void union(int i, int j) {
		p[findset(j)]=findset(i);
	}
	private static int findset(int i) {
		if(p[i]==i) return p[i];
		else {
			p[i]=findset(p[i]);
			return findset(p[i]);
		}
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
				if(nx<0 || nx>=N || ny<0 || ny>=M || board[nx][ny]==cnt) continue;
				if(board[nx][ny]==0) {
					int cn[]= {temp[0], temp[1], cnt, i};
					corner.add(cn);
					continue;
				}
				board[nx][ny]=cnt;
				int[] temp2= {nx, ny};
				queue.add(temp2);
			}
		}
	}
}