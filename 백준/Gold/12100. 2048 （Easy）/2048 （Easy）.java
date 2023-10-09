import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Integer[][] board;
	static int max=0;
	static Stack<Integer[][]> savefile=new Stack<>();
	static int N;
	static int a=0;
	static Queue<Integer> queue=new LinkedList<>();
 	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		board=new Integer[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int a=sc.nextInt();
				if(a==0) board[i][j]=0;
				
				else board[i][j]=a;
				max=Math.max(a, max);
			}
		}
		save();
		for(int i=0; i<4; i++) {
			move(i);
			save();
			for(int j=0; j<4; j++) {
				move(j);
				save();
				for(int k=0; k<4; k++) {
					move(k);
					save();
					for(int l=0; l<4; l++) {
						move(l);
						save();
						for(int m=0; m<4; m++) {
							move(m);
							load();
						}
						pop();
						load();
					}
					pop();
					load();
				}
				pop();
				load();
			}
			pop();
			load();
		}
		System.out.println(max);
	}
 	
	static void move(int a) {
 		switch(a) {
 		case 0:
 			for(int i=0; i<N; i++) {
 				for(int j=N-1; j>=0; j--) {
 					if(board[i][j]!=0) queue.add(board[i][j]);
 					board[i][j]=0;
 				}
 				if(!(queue.isEmpty())) {
 					board[i][N-1]=queue.poll();
 					int f1=0;
 				for(int j=N-2; j>=0; j--) {
 					if(!(queue.isEmpty())) {
 						if(f1==0&&queue.peek().equals(board[i][j+1])) {
 							board[i][j+1]*=2;
 							queue.poll();
 							max=Math.max(board[i][j+1], max);
 							j++;
 							f1=1;
 						}else {
 							board[i][j]=queue.poll();
 							f1=0;
 						}
 					}else break;
 				}
 				}
 			}
 			break;
 		case 1:
 			for(int i=0; i<N; i++) {
 				for(int j=N-1; j>=0; j--) {
 					if(board[j][i]!=0) queue.add(board[j][i]);
 					board[j][i]=0;
 				}
 				if(!(queue.isEmpty())) {
 					board[N-1][i]=queue.poll();
 					int f1=0;
 				for(int j=N-2; j>=0; j--) {
 					if(!(queue.isEmpty())) {
 						if(f1==0&&queue.peek().equals(board[j+1][i])) {
 							board[j+1][i]*=2;
 							queue.poll();
 							max=Math.max(board[j+1][i], max);
 							j++;
 							f1=1;
 						}else {
 							board[j][i]=queue.poll();
 							f1=0;
 						}
 					}else break;
 				}
 				}
 			}
 			break;
 		case 2:
 			for(int i=0; i<N; i++) {
 				for(int j=0; j<N; j++) {
 					if(board[i][j]!=0) queue.add(board[i][j]);
 					board[i][j]=0;
 				}
 				if(!(queue.isEmpty())) {
 					board[i][0]=queue.poll();
 					int f1=0;
 				for(int j=1; j<N; j++) {
 					if(!(queue.isEmpty())) {
 						if(f1==0&&queue.peek().equals(board[i][j-1])) {
 							board[i][j-1]*=2;
 							queue.poll();
 							max=Math.max(board[i][j-1], max);
 							j--;
 							f1=1;
 						}else {
 							board[i][j]=queue.poll();
 							f1=0;
 						}
 					}else break;
 				}
 				}
 			}
 			break;	
 		case 3:
 			for(int i=0; i<N; i++) {
 				for(int j=0; j<N; j++) {
 					if(board[j][i]!=0) queue.add(board[j][i]);
 					board[j][i]=0;
 				}
 				if(!(queue.isEmpty())) {
 					board[0][i]=queue.poll();
 					int f1=0;
 				for(int j=1; j<N; j++) {
 					if(!(queue.isEmpty())) {
 						if(f1==0&&queue.peek().equals(board[j-1][i])) {
 							board[j-1][i]*=2;
 							queue.poll();
 							max=Math.max(board[j-1][i], max);
 							j--;
 							f1=1;	
 						}else {
 							board[j][i]=queue.poll();
 							f1=0;
 						}
 					}else break;
 				}
 				}
 			}
 			break;
 		}
// 		for(int i=0; i<N; i++) {
// 			for(int j=0; j<N; j++) {
// 				System.out.print(board[i][j]+" ");
// 			}
// 			System.out.println();
// 		}
// 		System.out.println();
 	}
 	static void save() {
 		Integer[][] temp=new Integer[N][N];
 		for(int i=0; i<N; i++) {
 			for(int j=0; j<N; j++) {
 				int a=board[i][j];
 				temp[i][j]=(Integer)a;
 			}
 		}
 		savefile.add(temp);
 	}
 	static void load() {
 		Integer[][] temp=new Integer[N][N];
 		Integer[][] temp2=savefile.peek();
 			for(int i=0; i<N; i++) {
 				for(int j=0; j<N; j++) {
 					int a=temp2[i][j];
 	 				temp[i][j]=(Integer)a;
 				}
 			}
 		board=temp;
 	}
 	static void pop() {
 		savefile.pop();
 	}
}
