import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Integer[][] board;
	static int N;
	static int M;
	static int H;
	static int ans=0;
	static int f1=0;
	static int min=4;
	static Stack<Integer[][]> savefile=new Stack<>();
	static ArrayList<Integer[]> lines=new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		H=sc.nextInt();
		board=new Integer[H+1][N+1];
		for(int i=0; i<H+1; i++) {
			for(int j=0; j<N+1; j++) {
				board[i][j]=0;
			}
		}
		
		for(int i=0; i<M; i++) {
			board[sc.nextInt()][sc.nextInt()]=-1;
		}
		move();
		search();
		save();
		for(int i=0; i<lines.size(); i++) {
			ans=1;
			f1=0;
			insert(i);
			move();
			save();
			for(int j=i+1; j<lines.size(); j++) {
				ans=2;
				f1=0;
				insert(j);
				if(f1==0) {
				move();
				save();
				for(int k=j+1; k<lines.size(); k++) {
					f1=0;
					ans=3;
					insert(k);
					if(f1==0) {
					move();
					load();
					}
				}
				pop();
				load();
				}
			}
			pop();
			load();
		}
		if(min==4) System.out.println(-1);
		else System.out.println(min);
	}
	static void search() {
		for(int i=1; i<=H; i++) {
			for(int j=1; j<=N-1; j++) {
				if(board[i][j]!=-1 && board[i][j-1]!=-1 && board[i][j+1]!=-1) {
					Integer[] temp= {i,j};
					lines.add(temp);
				}
			}
		}
	}
	static void save() {
		Integer[][] temp=new Integer[H+1][N+1];
		for(int i=0; i<H+1; i++) {
			for(int j=0; j<N+1; j++) {
				int a=board[i][j];
				temp[i][j]=a;
			}
		}
		savefile.add(temp);
	}
	static void load() {
		Integer[][] temp=savefile.peek();
		for(int i=0; i<H+1; i++) {
			for(int j=0; j<N+1; j++) {
				int a=temp[i][j];
				board[i][j]=a;
			}
		}
	}
	static void pop() {
		savefile.pop();
	}
	static void move() {
		int[] position=new int[N+1];
		for(int i=1; i<=N; i++) {
			position[i]=i;
		}
		for(int i=1; i<H+1; i++) {
			for(int j=1; j<N; j++) {
				if(board[i][j]==-1) {
					int temp=position[j];
					int b=position[j+1];
					position[j]=b;
					position[j+1]=temp;
				}
			}
		}
		for(int i=1; i<=N; i++) {
			if(position[i]!=i) return;
		}
		min=Math.min(ans, min);
	}
	static void insert(int i) {
		int a=lines.get(i)[0];
		int b=lines.get(i)[1];
		if(board[a][b]!=-1 && board[a][b-1]!=-1 && board[a][b+1]!=-1) board[a][b]=-1;
		else f1=1;
	}
}
