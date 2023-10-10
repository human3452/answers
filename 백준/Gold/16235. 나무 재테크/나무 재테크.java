import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] land;
	static int[][] board;
	static int N;
	static Deque<Integer[]> trees=new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		int M=sc.nextInt();
		int K=sc.nextInt();
		board=new int[N+1][N+1];
		land=new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				land[i][j]=5;
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				board[i][j]=sc.nextInt();
			}
		}
		Integer[] init= {sc.nextInt(), sc.nextInt(), sc.nextInt()};
		trees.add(init);
		for(int i=1; i<M; i++) {
			Integer[] temp={sc.nextInt(), sc.nextInt(), sc.nextInt()};
			int f1=0;
			for(int j=1; j<=i; j++) {
				Integer[] temp2=trees.poll();
				if(f1==0 && (int)temp[0]==temp2[0] && (int)temp[1]==temp2[1] && (int)temp[2]<=temp2[2]) {
					trees.addLast(temp);
					f1=1;
				}
				trees.add(temp2);
			}
			if(f1==0) trees.add(temp);
		}
		for(int year=0; year<K; year++) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(trees.size());
	}
	
	private static void winter() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				land[i][j]+=board[i][j];
			}
		}
		
	}
	private static void fall() {
		Queue<Integer[]> subtree=new LinkedList<>();
		for(int i=0; i<trees.size(); i++) {
			Integer[] temp=trees.poll();
			if(temp[2]%5==0) {
				Integer[] temp2=temp.clone();
				subtree.add(temp2);
			}
			trees.add(temp);
		}
		while(!(subtree.isEmpty())) {
			Integer[] temp=subtree.poll();
			for(int r=temp[0]-1; r<=temp[0]+1; r++) {
				for(int c=temp[1]-1; c<=temp[1]+1; c++) {
					if(r>=1 && r<=N && c>=1 && c<=N) {
						if(r==temp[0] && c==temp[1]) continue;
						Integer[] temp2= {r,c,1};
						trees.addFirst(temp2);
					}
				}
			}
		}
	}
	private static void summer() {
		for(int i=0; i<trees.size(); i++) {
			Integer[] temp=trees.poll();
			if(temp[2]<0) {
				land[temp[0]][temp[1]]+=Math.abs(temp[2]/2);
				i--;
			}else trees.add(temp);
		}
	}
	private static void spring() {
		for(int i=0; i<trees.size(); i++) {
			Integer[] temp=trees.poll();
			if(temp[2]<=land[temp[0]][temp[1]]) {
				land[temp[0]][temp[1]]-=temp[2];
				temp[2]++;
			}else {
				temp[2]*=-1;
			}
			trees.add(temp);
		}
	}
}