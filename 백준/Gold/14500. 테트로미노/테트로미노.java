import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int[][] board;
 	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int max=0;
		board=new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				board[i][j]=sc.nextInt();
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				max=Math.max(check(i,j),max);
			}
		}
		System.out.println(max);
 	}  
 	
 	static int check(int a,int b) {
 		int max=0;
 		try {
 			int cnt=0;
 			for(int i=0; i<4; i++) {
 				cnt+=board[a][b+i];
 			}
 			max=Math.max(max, cnt);
 		}catch(ArrayIndexOutOfBoundsException er) {
 			
 		}
 			int f1=0;
 			int cnt=0;
 			try {
 			for(int i=0; i<3; i++) {
 				cnt+=board[a][b+i];
 			}
 			}catch(ArrayIndexOutOfBoundsException er) {
 				f1=1;
 			}
 			if(f1==0) {
 			for(int i=0; i<3; i++) {
 				try{max=Math.max(max, cnt+board[a+1][b+i]);
 				if(i==2) {
 					cnt-=board[a][b+i];
	 				cnt+=board[a+1][b+1];
	 				cnt+=board[a+1][b+i];
	 				max=Math.max(max, cnt);
 				}
 				}
 				catch(ArrayIndexOutOfBoundsException er) {
 					
 				}
 			}
 			}
 			f1=0;
 			cnt=0;
 			try {
 	 			for(int i=0; i<3; i++) {
 	 				cnt+=board[a+1][b+i];
 	 			}
 	 			}catch(ArrayIndexOutOfBoundsException er) {
 	 				f1=1;
 	 			}
 	 			if(f1==0) {
 	 			for(int i=0; i<3; i++) {
 	 				try{max=Math.max(max, cnt+board[a][b+i]);
 	 				if(i==2) {
 	 					cnt-=board[a+1][b+i];
 		 				cnt+=board[a][b+1];
 		 				cnt+=board[a][b+i];
 		 				max=Math.max(max, cnt);
 	 				}
 	 				}
 	 				catch(ArrayIndexOutOfBoundsException er) {
 	 					
 	 				}
 	 			}
 	 		}
 	 			f1=0;
 	 			cnt=0;
 	 			try {
 	 			for(int i=0; i<3; i++) {
 	 				cnt+=board[a+i][b];
 	 			}
 	 			}catch(ArrayIndexOutOfBoundsException er) {
 	 				f1=1;
 	 			}
 	 			if(f1==0) {
 	 			for(int i=0; i<3; i++) {
 	 				try{max=Math.max(max, cnt+board[a+i][b+1]);
 	 				if(i==2) {
 	 					cnt-=board[a+i][b];
 	 					cnt+=board[a+1][b+1];
 	 					cnt+=board[a+i][b+1];
 	 					max=Math.max(max, cnt);
 	 				}
 	 				}
 	 				catch(ArrayIndexOutOfBoundsException er) {
 	 					
 	 				}
 	 			}
 	 			}
 	 			f1=0;
 	 			cnt=0;
 	 			try {
 	 	 			for(int i=0; i<3; i++) {
 	 	 				cnt+=board[a+i][b+1];
 	 	 			}
 	 	 			}catch(ArrayIndexOutOfBoundsException er) {
 	 	 				f1=1;
 	 	 			}
 	 	 			if(f1==0) {
 	 	 			for(int i=0; i<3; i++) {
 	 	 				try{max=Math.max(max, cnt+board[a+i][b]);
 	 	 				if(i==2) {
 	 	 					cnt-=board[a+i][b+1];
 	 	 					cnt+=board[a+1][b];
 	 	 					cnt+=board[a+i][b];
 	 	 					max=Math.max(max, cnt);
 	 	 				}
 	 	 				}
 	 	 				
 	 	 				catch(ArrayIndexOutOfBoundsException er) {
 	 	 					
 	 	 				}
 	 	 			}
 	 	 		}	
 			try {
 			cnt=0;
 			for(int i=0; i<4; i++) {
 				cnt+=board[a+i][b];
 			}
 			max=Math.max(max, cnt);
 		}catch(ArrayIndexOutOfBoundsException er) {
 			
 		}
 		cnt=0;
 		try {
 			for(int i=0; i<2; i++) {
 				for(int j=0; j<2; j++) {
 					cnt+=board[a+i][b+j];
 				}
 			}
 			max=Math.max(max,cnt);
 		}catch (ArrayIndexOutOfBoundsException e) {
			
		}
 		return max;
 	}
}