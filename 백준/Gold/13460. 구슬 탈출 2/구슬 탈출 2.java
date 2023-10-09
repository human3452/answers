import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int[] dx= {0, 0, -1, 1};
	static int[] dy= {1,-1, 0, 0}; 	
	static char[][] board;
	static Integer[][] rbpoint;
	static Integer[] endpoint;
	static ArrayList<Integer[][]> co=new ArrayList<>();
	static int pointer=0;
	static int endcount=1;
 	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		rbpoint=new Integer[2][2];
		endpoint=new Integer[2];
		board=new char[N][M];
		sc.nextLine();
		for(int i=0; i<N; i++) {
			String input=sc.nextLine();
			for(int j=0; j<M; j++) {
				board[i][j]=input.charAt(j);
				if(board[i][j]=='R') {
					rbpoint[0][0]=i;
					rbpoint[0][1]=j;
				}else if(board[i][j]=='B') {
					rbpoint[1][0]=i;
					rbpoint[1][1]=j;
				}else if(board[i][j]=='O') {
					endpoint[0]=i;
					endpoint[1]=j;
				}
			}
		}
		co.add(rbpoint);
		for(int i=1; i<=10; i++) {
			move(i);	
		}
		System.out.println(-1);
	}
 	static void move(int b) {
 		int end=endcount;
 		int f2=0;
 		for(int j=pointer; j<end; j++) {
 			board[rbpoint[0][0]][rbpoint[0][1]]='.';
 			board[rbpoint[1][0]][rbpoint[1][1]]='.';
 			rbpoint=co.get(j);
 			
 		outer:for(int i=0; i<4; i++) {
 			board[rbpoint[0][0]][rbpoint[0][1]]='R';
 			board[rbpoint[1][0]][rbpoint[1][1]]='B';
 			int rnx=rbpoint[0][0]+dx[i];
 			int rny=rbpoint[0][1]+dy[i];
 			int bnx=rbpoint[1][0]+dx[i];
 			int bny=rbpoint[1][1]+dy[i];
 			if(board[rnx][rny]!='#' || board[bnx][bny]!='#') {
 				int f1=0;
 				f2=0;
 				inner : while(true) {
 					switch(board[rnx][rny]) {
 					case '#':
 						rnx-=dx[i];
 	 					rny-=dy[i];
 						break inner;
 					case 'B':
 						rnx+=dx[i];
 	 					rny+=dy[i];
 						f1=1;	
 						break;
 					case 'O':
 						f2=1;
 						board[rbpoint[0][0]][rbpoint[0][1]]='.';
 						board[rbpoint[1][0]][rbpoint[1][1]]='.';
 						if(f1==1) continue outer;
 						break inner;
 					default:
 						rnx+=dx[i];
 						rny+=dy[i];
 						break;
 					}	
 				}
 				board[rbpoint[1][0]][rbpoint[1][1]]='.';
 				if(f1==0) {
 					board[rbpoint[0][0]][rbpoint[0][1]]='.';
 					if(f2!=1) board[rnx][rny]='R';
 					inner2 : while(true) {
 	 					switch(board[bnx][bny]) {
 	 					case '#':
 	 						bnx-=dx[i];
 	 	 					bny-=dy[i];
 	 						break inner2;
 	 					case 'O':
 	 						if(f2!=1) board[rnx][rny]='.';
 	 						continue outer;
 	 					case 'R':
 	 						bnx-=dx[i];
 	 	 					bny-=dy[i];
 	 						break inner2;
 	 					default:
 	 						bnx+=dx[i];
 	 						bny+=dy[i];
 	 						break;	
 	 					}	
 	 				}
 				}else {
 					bnx=rnx;
 					bny=rny;
	 				rnx-=dx[i];
	 				rny-=dy[i];
 				}
 				board[rnx][rny]='.';
 				board[rbpoint[0][0]][rbpoint[0][1]]='.';
 				if(f2==1) {
 					System.out.println(b);
 					System.exit(0);
 				}
 				Integer[][] temp= {{rnx, rny},{bnx, bny}};
 				if(!(co.contains(temp))) {
 					co.add(temp);
 					
 					endcount++;
 				}
 			}
 		}
 		
 		}
 		pointer=end;
 	}
}