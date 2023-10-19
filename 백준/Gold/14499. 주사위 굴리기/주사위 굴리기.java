import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dx= {-1231, 0, 0, -1, 1};
	static int[] dy= {-1231, 1,-1, 0, 0}; 	
	static int[][] dice={{0, 0, 0},{0, 0, 0},{0, 0, 0},{0, 0, 0}};
	static int[][] map;
	static int[] pointer=new int[2];
 	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		map=new int[N][M];
		pointer[0]=sc.nextInt();
		pointer[1]=sc.nextInt();
		int K=sc.nextInt();
		for(int i=0; i<N; i++) { 
			for(int j=0; j<M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0; i<K; i++) {
			roll(sc.nextInt());
		}

	}
	static void roll(int D) {
		int nx=pointer[0]+dx[D];
		int ny=pointer[1]+dy[D];
		int f1=0;
		try {
			if(map[nx][ny]==0) f1=1;
		}catch(ArrayIndexOutOfBoundsException err) {
			return;
		}
		//굴려보자
		Queue<Integer> temp=new LinkedList<>();
		switch(D) {
		case 1:
			temp.add(dice[1][0]);
			temp.add(dice[1][1]);
			temp.add(dice[1][2]);
			dice[1][0]=dice[3][1];
			dice[1][1]=temp.poll();
			dice[1][2]=temp.poll();
			dice[3][1]=temp.poll();
			break;
		case 2:
			temp.add(dice[1][0]);
			temp.add(dice[1][1]);
			temp.add(dice[1][2]);
			dice[1][2]=dice[3][1];
			dice[3][1]=temp.poll();
			dice[1][0]=temp.poll();
			dice[1][1]=temp.poll();
			break;
		case 3:
			temp.add(dice[1][1]);
			temp.add(dice[2][1]);
			temp.add(dice[3][1]);
			dice[3][1]=dice[0][1];
			dice[0][1]=temp.poll();
			dice[1][1]=temp.poll();
			dice[2][1]=temp.poll();
			break;
		case 4:
			temp.add(dice[0][1]);
			temp.add(dice[1][1]);
			temp.add(dice[2][1]);
			dice[0][1]=dice[3][1];
			dice[1][1]=temp.poll();
			dice[2][1]=temp.poll();
			dice[3][1]=temp.poll();
			break;
		}
		if(f1==1) {
			map[nx][ny]=dice[3][1];
		}else {
			dice[3][1]=map[nx][ny];
			map[nx][ny]=0;
		}
		System.out.println(dice[1][1]);
		pointer[0]=nx;
		pointer[1]=ny;
	}
}
