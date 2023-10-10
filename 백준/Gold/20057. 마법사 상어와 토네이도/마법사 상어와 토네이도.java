import java.util.Scanner;

public class Main {
	static int[][] board;
	static int[] dx= {0, 1, 0, -1};
	static int[] dy= {-1, 0, 1, 0};
	static int[] pointer=new int[2];
	static int gear=0;
	static int answer=0;
	static int N;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		board=new int[N][N];
		pointer[0]=N/2;
		pointer[1]=N/2;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j]=sc.nextInt();
			}
		}
		for(int counter=1; counter<N; counter++) {
			move(counter);
			move(counter);
			counter++;
			move(counter);
			move(counter);
		}
		move(N-1);
		System.out.println(answer);
	}
	static void move(int c) {
		for(int i=0; i<c; i++) {
			pointer[0]+=dx[gear];
			pointer[1]+=dy[gear];
			blow(pointer);
		}
		gear++;
		if(gear==4) {
			gear=0;
		}
	}
	private static void blow(int[] p) {
		int sand=board[p[0]][p[1]];
		board[p[0]][p[1]]=0;
		if(sand!=0) {
			int two=sand/50;
			int seven=sand*7/100;
			int ten=sand/10;
			int five=sand/20;
			int one=sand/100;
			int gr=gear+4;
			sand=sand-((two+seven+ten+one)*2+five);
			if(p[0]+dx[gear]*2>=0 && p[0]+dx[gear]*2<N && p[1]+dy[gear]*2>=0 && p[1]+dy[gear]*2<N) {
				board[p[0]+dx[gear]*2][p[1]+dy[gear]*2]+=five;
			}else answer+=five;
			if(p[0]+dx[gear]>=0 && p[0]+dx[gear]<N && p[1]+dy[gear]>=0 && p[1]+dy[gear]<N) {
				board[p[0]+dx[gear]][p[1]+dy[gear]]+=sand;
				if(p[0]+dx[(gr+1)%4]>=0 && p[0]+dx[(gr+1)%4]<N && p[1]+dy[(gr+1)%4]>=0 && p[1]+dy[(gr+1)%4]<N) {
					board[p[0]+dx[(gr+1)%4]+dx[gear]][p[1]+dy[(gr+1)%4]+dy[gear]]+=ten;
				}else {
					answer+=ten;
				}
				if(p[0]+dx[(gr-1)%4]>=0 && p[0]+dx[(gr-1)%4]<N && p[1]+dy[(gr-1)%4]>=0 && p[1]+dy[(gr-1)%4]<N) {
					board[p[0]+dx[(gr-1)%4]+dx[gear]][p[1]+dy[(gr-1)%4]+dy[gear]]+=ten;
				}else answer+=ten;
			}else answer+=(ten*2+sand);
			// 위 아래
			if(p[0]+dx[((gr-1)%4)]*2>=0 && p[0]+dx[((gr-1)%4)]*2<N && p[1]+dy[((gr-1)%4)]*2>=0 && p[1]+dy[((gr-1)%4)]*2<N) {
				board[p[0]+dx[((gr-1)%4)]*2][p[1]+dy[((gr-1)%4)]*2]+=two;
			}else answer+=two;
			if(p[0]+dx[((gr+1)%4)]*2>=0 && p[0]+dx[((gr+1)%4)]*2<N && p[1]+dy[((gr+1)%4)]*2>=0 && p[1]+dy[((gr+1)%4)]*2<N) {
				board[p[0]+dx[((gr+1)%4)]*2][p[1]+dy[((gr+1)%4)]*2]+=two;
			}else answer+=two;
			if(p[0]+dx[(gr+1)%4]>=0 && p[0]+dx[(gr+1)%4]<N && p[1]+dy[(gr+1)%4]>=0 && p[1]+dy[(gr+1)%4]<N) {
				board[p[0]+dx[(gr+1)%4]][p[1]+dy[(gr+1)%4]]+=seven;
			}else {
				answer+=seven;
			}
			if(p[0]+dx[(gr-1)%4]>=0 && p[0]+dx[(gr-1)%4]<N && p[1]+dy[(gr-1)%4]>=0 && p[1]+dy[(gr-1)%4]<N) {
				board[p[0]+dx[(gr-1)%4]][p[1]+dy[(gr-1)%4]]+=seven;
			}else answer+=seven;
			//뒤 쪽
			if(p[0]-dx[gear]>=0 && p[0]-dx[gear]<N && p[1]-dy[gear]>=0 && p[1]-dy[gear]<N) {
				if(p[0]+dx[(gr+1)%4]>=0 && p[0]+dx[(gr+1)%4]<N && p[1]+dy[(gr+1)%4]>=0 && p[1]+dy[(gr+1)%4]<N) {
					board[p[0]+dx[(gr+1)%4]-dx[gear]][p[1]+dy[(gr+1)%4]-dy[gear]]+=one;
				}else {
					answer+=one;
				}
				if(p[0]+dx[(gr-1)%4]>=0 && p[0]+dx[(gr-1)%4]<N && p[1]+dy[(gr-1)%4]>=0 && p[1]+dy[(gr-1)%4]<N) {
					board[p[0]+dx[(gr-1)%4]-dx[gear]][p[1]+dy[(gr-1)%4]-dy[gear]]+=one;
				}else answer+=one;
			}
		}
	}

}