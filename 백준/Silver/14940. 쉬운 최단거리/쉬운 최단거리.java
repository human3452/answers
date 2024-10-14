import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st1.nextToken());
        int M= Integer.parseInt(st1.nextToken());
        int[][] board=new int[N][M];
        boolean[][] wall=new boolean[N][M];
        int startx=0;
        int starty=0;
        for(int i=0; i<N; i++){
            st1=new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                switch (Integer.parseInt(st1.nextToken())){
                    case 0:
                        wall[i][j]=true;
                        break;
                    case 2:
                        startx=i;
                        starty=j;
                        break;
                    case 1:
                        break;
                }
            }
        }
        wall[startx][starty]=true;
        Queue<int[]> BFS=new LinkedList<>();
        BFS.add(new int[]{startx, starty});
        while(!BFS.isEmpty()){
            int[] temp=BFS.poll();
            for(int i=0; i<4; i++){
                int nx=temp[0]+dx[i];
                int ny=temp[1]+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && board[nx][ny]==0 && !wall[nx][ny]){
                    board[nx][ny]=board[temp[0]][temp[1]]+1;
                    BFS.add(new int[]{nx,ny});
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j]==0 && !wall[i][j]) board[i][j]=-1;
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M-1; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.print(board[i][M-1]);
            System.out.println();
        }
    }
}