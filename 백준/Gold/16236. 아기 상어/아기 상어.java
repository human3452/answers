import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dx= {0, 1, 0, -1};
	static int[] dy= {-1, 0, 1, 0};
	static int[][] board;
	static int N;
	static int x,y;
	static int size=2;
	static int counter=0;
	static int time=0;
	static Deque<Integer[]> trees=new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		board=new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j]=sc.nextInt();
				if(board[i][j]==9) {
					x=i;
					y=j;
					board[i][j]=0;
				}
			}		
		}
		while(true) {
			search();
			counter++;
			if(size==counter) {
				counter=0;
				size++;
			}
		}
	}
	private static void search() {
		//찾기
		int nextx=N+2;
		int nexty=N+2;
		int d=Integer.MAX_VALUE;
		ArrayList<Integer[]> list=new ArrayList<>();
		Integer alp[]= {x,y,0};
		list.add(alp);
		int pointer=0;
		while(pointer<list.size()) {
			Integer[] temp=list.get(pointer);
			x=temp[0];
			y=temp[1];
			if(temp[2]<d) {
			inner:for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<0 || ny>=N || nx>=N || ny<0) continue;
				Integer[] temp2= {nx,ny, temp[2]+1};
				for(int j=0; j<list.size(); j++) {
					if(nx==list.get(j)[0] && ny==list.get(j)[1]) continue inner;
				}
				if(list.contains(temp2)) continue;
				if(board[nx][ny]>size) continue;
				if(board[nx][ny]<size && board[nx][ny]!=0) {
					d=temp2[2];
					if(nextx<nx) continue;
					if(nextx==nx) {
						if(nexty<ny) continue;
					}
					nextx=nx;
					nexty=ny;
				}
				list.add(temp2);
			}
			pointer++;
			}else {
				time+=d;
				x=nextx;
				y=nexty;
				board[x][y]=0;
				return;
			}
		}
		System.out.println(time);
		System.exit(0);
	}
	
}