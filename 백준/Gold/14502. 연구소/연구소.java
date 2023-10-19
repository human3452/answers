import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int[][] board;
	static int[][] copy;
	static int N,M;
	static int max=0;
	static ArrayList<Integer[]> virus=new ArrayList<>();
	static Queue<Integer> ready=new LinkedList<>();
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
 	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		board=new int[N][M];
		copy=new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int a=sc.nextInt();
				if(a==2) {
					Integer temp[]=new Integer[2];
					temp[0]=i;
					temp[1]=j;
					virus.add(temp);
				}
				board[i][j]=a;
			}
		}
		
		//벽 깔기
		for(int i=0; i<N*M-2; i++) {
			for(int j=i+1; j<N*M-1; j++) {
				for(int k=j+1; k<N*M; k++) {
					load();
					int f1=build(i,j,k);
					if(f1==0) spread();
					//바이러스 계산하기
				}
			}
		}
		System.out.println(max);
 	} 
 	static void load() {
 		for(int i=0; i<N; i++) {
 			for(int j=0; j<M; j++) {
 				copy[i][j]=board[i][j];
 			}
 		}
 	}
 	static int build(int a, int b, int c) {
 		int a1=a/M;
 		int a2=a%M;
 		int b1=b/M;
 		int b2=b%M;
 		int c1=c/M;
 		int c2=c%M;
 		if(copy[a1][a2]!=0) return 1;
 		else copy[a1][a2]=1;
 		if(copy[b1][b2]!=0) return 1;
 		else copy[b1][b2]=1;
 		if(copy[c1][c2]!=0) return 1;
 		else copy[c1][c2]=1;
 		return 0;
 	}
 	static void spread() {
 		for(int ts=0; ts<virus.size(); ts++) {
 			Integer[] cur=virus.get(ts);
 			int a=(int)cur[0];
 			int b=(int)cur[1];
 			copy[a][b]=2;
 			int f1=0;
 			do {
 				if(f1==1) {
 					a=(int)ready.poll();
 					b=(int)ready.poll();
 				}else f1=1;
 			for(int i=0; i<4; i++) {
 				Integer nx=a+dx[i];
 				Integer ny=b+dy[i];
 				try {
 				if(copy[(int)nx][(int)ny]==0) {
 					copy[(int)nx][(int)ny]=2;
 					ready.add(nx);
 					ready.add(ny);
 				}
 				}catch(ArrayIndexOutOfBoundsException err) {
 					
 				}
 			}
 			}while(!(ready.isEmpty()));
 		}
 		int ans=0;
 		for(int i=0; i<N; i++) {
 			for(int j=0; j<M; j++) {
 				if(copy[i][j]==0) ans++;
 			}
 		}
 		max=Math.max(ans, max);
 	}
}