import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int gear=0;
	static int[] dx= {0, -1, 0, 1};
	static int[] dy= {1, 0, -1, 0};
	static int board[][];
	static ArrayList<Integer> ways=new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int ans=0;
		board=new int[101][101];
		for(int i=0; i<N; i++) {
			int y=sc.nextInt();
			int x=sc.nextInt();
			int d=sc.nextInt();
			int g=sc.nextInt();
			dragoncurve(d,g);
			paint(x,y);
			ways.clear();
		}
		for(int i=0; i<100; i++) {
			inner:for(int j=0; j<100; j++) {
				if(board[i][j]==1) {
					for(int i2=i; i2<=i+1; i2++) {
						for(int j2=j; j2<=j+1; j2++) {
							if(board[i2][j2]!=1) continue inner;
						}
					}
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	static void dragoncurve(int d, int g) {
		ways.add(d);
		for(int i=1; i<=g; i++) {
			for(int j=ways.size()-1; j>=0; j--) {
				ways.add((ways.get(j)+1)%4);
			}
		}
	}
	static void paint(int x, int y) {
		board[x][y]=1;
		for(int i=0; i<ways.size(); i++) {
			x+=dx[ways.get(i)];
			y+=dy[ways.get(i)];
			board[x][y]=1;
		}
		
	}
}