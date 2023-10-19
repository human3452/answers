import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer[]> BFS=new ArrayList<>();
    static int board[][][];
    static int N, L, R;
    static int[] dx= {1, 0, -1, 0};
    static int[] dy= {0, 1, 0, -1};
    static int f1=0;
    static int day=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        L=sc.nextInt();
        R=sc.nextInt();
        board=new int[N][N][2];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                board[i][j][0]=sc.nextInt();
            }
        }

        move();
        
    }
    static void move() {
    	while(true) {
    	f1=0;
    	
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
            	if(board[i][j][1]==day) {
            	int p=-1;
            	int x=i;
            	int y=j;
            	Integer[] temp2= {x,y};
            	BFS.add(temp2);
            	board[x][y][1]++;
            	do {
            		p++;
            		Integer[] temp3=BFS.get(p);
            		x=temp3[0];
                	y=temp3[1];
                for(int k=0; k<4; k++) {
                    int nx=x+dx[k];
                    int ny=y+dy[k];
                    if(nx<0 || nx>=N || ny<0 || ny>=N || board[nx][ny][1]!=day) continue;
                    if(Math.abs(board[nx][ny][0]-board[x][y][0])<=R && Math.abs(board[nx][ny][0]-board[x][y][0])>=L) {
                    	board[nx][ny][1]++;
                    	Integer[] t4=new Integer[2];
                    	t4[0]=nx;
                    	t4[1]=ny;
                    	BFS.add(t4);
                        f1=1;
                    }
                }
            	}while(p<BFS.size()-1);
            	//계산
            	int sum=0;
            	for(int k=0; k<BFS.size(); k++) {
            		sum+=board[BFS.get(k)[0]][BFS.get(k)[1]][0];
            	}
            	sum/=BFS.size();
            	for(int k=0; k<BFS.size(); k++) {
            		board[BFS.get(k)[0]][BFS.get(k)[1]][0]=sum;
            	}
            	BFS.clear();
            	}
            }
        }
        if(f1==0) {
            System.out.println(day);
            System.exit(0);
        }
        day++;
    	}
    }
}