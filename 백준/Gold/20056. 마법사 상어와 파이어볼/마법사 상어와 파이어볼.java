import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static int N, M, K;
	static final int[] dx= {-1, -1, 0, 1, 1, 1, 0, -1};
	static final int[] dy= {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		K=sc.nextInt();
		ArrayList<int[]> fireball=new ArrayList<>();
		for(int i=0; i<M; i++) {
			fireball.add(new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()});
		}
		//row column mass speed direction
		for(int i=0; i<K; i++) {
			int[][] board=new int[N+1][N+1];
			HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
			for(int j=0; j<fireball.size(); j++) {
				int nx=fireball.get(j)[0]+fireball.get(j)[3]*dx[fireball.get(j)[4]];
				int ny=fireball.get(j)[1]+fireball.get(j)[3]*dy[fireball.get(j)[4]];
				if(nx>0) nx=(nx%N);
				else nx=(nx%N)+N;
				if(ny>0) ny=(ny%N);
				else ny=(ny%N)+N;
				
				if(nx==0) nx=N;
				if(ny==0) ny=N;
				fireball.get(j)[0]=nx;
				fireball.get(j)[1]=ny;
				if(board[nx][ny]==0) {
					board[nx][ny]=j+1;
				}else {
					if(map.get(board[nx][ny]-1)==null) {
						ArrayList<Integer> af=new ArrayList<>();
						af.add(j);
						map.put(board[nx][ny]-1, af);
					}else {
						map.get(board[nx][ny]-1).add(j);
					}
				}
			}
			for(int x:map.keySet()) {
				int even=fireball.get(x)[4]%2;
				boolean isit=true;
				ArrayList<Integer> list=map.get(x);
				for(int v:list) {
					if(isit && fireball.get(v)[4]%2!=even) {
						isit=false;
					}
					fireball.get(x)[3]+=fireball.get(v)[3];
					fireball.get(x)[2]+=fireball.get(v)[2];
					fireball.get(v)[2]=0;
				}
				if(fireball.get(x)[2]>=5) {
					int speed=fireball.get(x)[3]/(list.size()+1);
					int mass=fireball.get(x)[2]/5;
					int nx=fireball.get(x)[0];
					int ny=fireball.get(x)[1];
					if(isit) {
						for(int j=0; j<=6; j+=2) {
							fireball.add(new int[] {nx, ny, mass, speed, j});
						}
					}else {
						for(int j=1; j<=7; j+=2) {
							fireball.add(new int[] {nx, ny, mass, speed, j});
						}
					}
				}
				fireball.get(x)[2]=0;
			}
			for(int j=fireball.size()-1; j>=0; j--) {
				if(fireball.get(j)[2]==0) {
					fireball.remove(j);
				}
			}
		}
		int ans=0;
		for(int i=0; i<fireball.size(); i++) {
			ans+=fireball.get(i)[2];
		}
		System.out.println(ans);
	}

}