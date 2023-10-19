import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;



public class Main {
	static int board[][] =new int[100][100];
	static int row, col;
	static PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int o2[]) {
			if(o1[1]==o2[1]) return o1[0]-o2[0];
			else return o1[1]-o2[1];
		}
	});
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		int c=sc.nextInt();
		int k=sc.nextInt();
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				board[i][j]=sc.nextInt();
			}
		}
		int cnt=0;
		row=3;
		col=3;
		while(cnt<=100) {
			if(board[r-1][c-1]==k) {
				System.out.println(cnt);
				System.exit(0);
			}
			cnt++;
			if(row>=col) calcR();
			else calcL();
		}
		System.out.println(-1);
	}
	private static void calcR() {
		int nextcol=0;
		
		for(int i=0; i<row; i++) {
			int[] count=new int[101];
			for(int j=0; j<col; j++) {
				count[board[i][j]]++;
			}
			for(int j=1; j<=100; j++) {
				if(count[j]!=0) {
					int[] temp= {j, count[j]};
					pq.add(temp);
				}
			}
			nextcol=Math.max(nextcol, pq.size()*2);
			int max=Math.min(50, pq.size())*2;
			for(int j=0; j<max; j+=2) {
				int[] temp=pq.poll();
				board[i][j]=temp[0];
				board[i][j+1]=temp[1];
			}
			for(int j=max; j<100; j++) {
				board[i][j]=0;
			}
		}
		col=nextcol;
		pq.clear();
	}
	private static void calcL() {
		int nextrow=0;
		for(int i=0; i<col; i++) {
			int[] count=new int[101];
			for(int j=0; j<row; j++) {
				count[board[j][i]]++;
			}
			for(int j=1; j<=100; j++) {
				if(count[j]!=0) {
					int[] temp= {j, count[j]};
					pq.add(temp);
				}
			}
			nextrow=Math.max(nextrow, pq.size()*2);
			int max=Math.min(50, pq.size())*2;
			for(int j=0; j<max; j+=2) {
				int[] temp=pq.poll();
				board[j][i]=temp[0];
				board[j+1][i]=temp[1];
			}
			for(int j=max; j<100; j++) {
				board[j][i]=0;
			}
		}
		row=nextrow;
		pq.clear();
	}
	
}