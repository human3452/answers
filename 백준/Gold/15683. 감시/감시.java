import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Integer[][] board;
	static int N, M;
	static int[] dx= {1, 0, -1, 0};
	static int[] dy= {0, 1, 0, -1};
	static int cctv=0;
	static int min=Integer.MAX_VALUE;
	static ArrayList<Integer[]> spot=new ArrayList<>();
	static Stack<Integer[][]> savefile=new Stack<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		board=new Integer[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int a=sc.nextInt();
				board[i][j]=a;
				if(a!=0 && a!=6) {
					Integer[] temp= {i, j};
					spot.add(temp);
					cctv++;
				}
			}
		}
		int ans=0;
		if(cctv==0) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(board[i][j]==0) ans++;
				}
			}
			System.out.println(ans);
			System.exit(0);
		}
		save();
		dup(0);
		System.out.println(min);
	}
	static void dup(int i) {
		if(i==cctv-1) {
			 for(int k=0; k<4; k++) {
				 fire(spot.get(i),k);
				 int asdw=count();
				 min=Math.min(asdw,min);
				 load();
			 }
		}else {
			for(int j=0; j<4; j++) {
				 fire(spot.get(i),j);
				 save();
				 dup(i+1);
				 pop();
				 load();
			 }
		}
	}
	static void save() {
		Integer[][] temp=new Integer[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int a=board[i][j];
				temp[i][j]=a;
			}
		}
		savefile.add(temp);
	}
	static void pop() {
		savefile.pop();
	}
	static void load() {
		Integer[][] temp=savefile.peek();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int a=temp[i][j];
				board[i][j]=a;
			}
		}
	}
	static void fire(Integer[] position, int direction) {
		int num=board[position[0]][position[1]];
		int x=position[0];
		int y=position[1];
			switch(num) {
			case 1:
				draw(direction,x,y);
				break;
			case 2:
				draw(direction,x,y);
				draw((direction+2)%4,x,y);
				break;
			case 3:
				draw(direction,x,y);
				draw((direction+1)%4,x,y);
				break;
			case 4:
				draw(direction,x,y);
				draw((direction+1)%4,x,y);
				draw((direction+2)%4,x,y);
				break;
			case 5:
				draw(direction,x,y);
				draw((direction+1)%4,x,y);
				draw((direction+2)%4,x,y);
				draw((direction+3)%4,x,y);
				break;
			}
	}
	static void draw(int a, int x, int y) {
		while(true) {
			int nx=x+dx[a];
			int ny=y+dy[a];
			if(nx<0 || nx>=N || ny<0 || ny>=M || board[nx][ny]==6) return;
			x=nx;
			y=ny;
			if(board[x][y]==0) board[x][y]=7;
		}
	}
	static int count() {
		int a=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				if(board[i][j]==0) a++;
			}

		}

		return a;
	}
}
