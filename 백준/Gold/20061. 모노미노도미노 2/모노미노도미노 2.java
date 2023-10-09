import java.util.Scanner;

public class Main {
	static final byte[] dx= {-1, 0, 1, 0};
	static final byte[] dy= {0, 1, 0, -1};
	static boolean[][] green, blue;
	static int ans=0;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		green=new boolean[6][4];
		blue=new boolean[4][6];
		int N=sc.nextInt();
		for(int i=0; i<N; i++) {
			move(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		int left=0;
		for(int i=0; i<4; i++) {
			for(int k=0; k<6; k++) {
				if(blue[i][k]) left++;
				if(green[k][i]) left++;
			}
		}
		System.out.println(ans);
		System.out.println(left);
	}

	private static void move(int t, int x, int y) {
		boolean f1=true;
		boolean f2=true;
		switch(t) {
		case 1:
			for(int i=0; i<6; i++) {
				if(f1 && (green[i][y])) {
					green[i-1][y]=true;
					f1=false;
				}
				if(f2 && blue[x][i]) {
					blue[x][i-1]=true;
					f2=false;
				}
				if(!(f1 || f2)) break;
			}
			if(f1) {
				green[5][y]=true;
			}
			if(f2) {
				blue[x][5]=true;
			}
			break;
		case 2:
			for(int i=0; i<6; i++) {
				if(f1 && (green[i][y] || green[i][y+1])) {
					green[i-1][y]=true;
					green[i-1][y+1]=true;
					f1=false;
				}
				if(f2 && blue[x][i]) {
					blue[x][i-1]=true;
					blue[x][i-2]=true;
					f2=false;
				}
				if(!(f1 || f2)) break;
			}
			if(f1) {
				green[5][y]=true;
				green[5][y+1]=true;
			}
			if(f2) {
				blue[x][5]=true;
				blue[x][4]=true;
			}
			break;
		
		case 3:
			for(int i=0; i<6; i++) {
				if(f1 && green[i][y]) {
					green[i-1][y]=true;
					green[i-2][y]=true;
					f1=false;
				}
				if(f2 && (blue[x+1][i] || blue[x][i])) {
					blue[x+1][i-1]=true;
					blue[x][i-1]=true;
					f2=false;
				}
				if(!(f1 || f2)) break;
			}
			if(f1) {
				green[5][y]=true;
				green[4][y]=true;
			}
			if(f2) {
				blue[x+1][5]=true;
				blue[x][5]=true;
			}
			break;
		}
		check();
		clean();
	}

	private static void check() {
		for(int i=0; i<4; i++) {
			boolean f1=true;
			boolean f2=true;
			for(int j=0; j<4; j++) {
				if(!green[i+2][j]) f1=false;
				if(!blue[j][i+2]) f2=false;
			}
			//그린 가로줄
			if(f1) {
				move(i+2, 0); 
				ans++;
			}
			if(f2) {
				move(i+2, 1);
				ans++;
			}
		}
		
	}

	private static void clean() {
		for(int i=0; i<=1; i++) {
			for(int j=0; j<4; j++) {
				if(green[i][j]) {
					move(5,0);
				}
				if(blue[j][i]) {
					move(5,1);
				}
			}
		}
		
	}
	private static void move(int loc, int status) {
		if(status==0) {
			//녹색
			for(int i=loc-1; i>=0; i--) {
				for(int j=0; j<4; j++) {
					green[i+1][j]=green[i][j];
				}
			}
			for(int i=0; i<4; i++) {
				green[0][i]=false;
			}
		}else {
			//파란색
			for(int i=loc-1; i>=0; i--) {
				for(int j=0; j<4; j++) {
					blue[j][i+1]=blue[j][i];
				}
			}
			for(int i=0; i<4; i++) {
				blue[i][0]=false;
			}
		}
	}
}