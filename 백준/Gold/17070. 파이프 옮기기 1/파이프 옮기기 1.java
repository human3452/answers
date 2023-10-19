import java.util.Scanner;

public class Main {
	static int[][] board;
	static int N, cnt;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		cnt=0;
		board=new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j]=sc.nextInt();
			}
		}
		int[] pipe= {0,1};
		move(0,pipe);
		System.out.println(cnt);
	}

	private static void move(int state, int[] pipe) {
		if(pipe[0]==N-1 && pipe[1]==N-1) {
			cnt++;
			return;
		}
		switch(state) {
		case 0:
			if(pipe[1]<N-1 && board[pipe[0]][pipe[1]+1]==0) {
				pipe[1]++;
				move(0, pipe);
				pipe[1]--;
			}
			if(pipe[0]<N-1 && pipe[1]<N-1 && board[pipe[0]+1][pipe[1]]==0 && board[pipe[0]+1][pipe[1]+1]==0 && board[pipe[0]][pipe[1]+1]==0) {
				pipe[0]++;
				pipe[1]++;
				move(1,pipe);
				pipe[0]--;
				pipe[1]--;
			}
			break;
		case 1:
			if(pipe[0]<N-1 && board[pipe[0]+1][pipe[1]]==0) {
				pipe[0]++;
				move(2,pipe);
				pipe[0]--;
			}
			if(pipe[1]<N-1 && board[pipe[0]][pipe[1]+1]==0) {
				pipe[1]++;
				move(0, pipe);
				pipe[1]--;
			}
			if(pipe[0]<N-1 && pipe[1]<N-1 && board[pipe[0]+1][pipe[1]]==0 && board[pipe[0]+1][pipe[1]+1]==0 && board[pipe[0]][pipe[1]+1]==0) {
				pipe[0]++;
				pipe[1]++;
				move(1,pipe);
				pipe[0]--;
				pipe[1]--;
			}
			break;
		case 2:
			if(pipe[0]<N-1 && board[pipe[0]+1][pipe[1]]==0) {
				pipe[0]++;
				move(2, pipe);
				pipe[0]--;
				
			}
			if(pipe[1]<N-1 && pipe[0]<N-1 && board[pipe[0]][pipe[1]+1]==0 && board[pipe[0]+1][pipe[1]+1]==0 && board[pipe[0]+1][pipe[1]]==0) {
				pipe[1]++;
				pipe[0]++;
				move(1,pipe);
				pipe[1]--;
				pipe[0]--;
			}
			break;
		}
		
	}
	
}
