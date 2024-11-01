import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, -1, 0, 1};
    static boolean[] exists=new boolean[26];
    static boolean[][] map;
    static int[][] board;
    static int R, C, max=-1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R= Integer.parseInt(st.nextToken());
        C= Integer.parseInt(st.nextToken());
        board=new int[R][C];
        map=new boolean[R][C];
        for(int i=0; i<R; i++){
            String temp=br.readLine();
            for(int j=0; j<C; j++){
                board[i][j]=temp.charAt(j)-'A';
            }
        }
        exists[board[0][0]]=true;
        map[0][0]=true;
        DFS(0, 0, 1);
        System.out.println(max);
    }
    static void DFS(int x, int y, int depth){
        for(int i=0; i<4; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<R && ny>=0 && ny<C && !map[nx][ny] && !exists[board[nx][ny]]){
                exists[board[nx][ny]]=true;
                map[nx][ny]=true;
                DFS(nx, ny, depth+1);
                exists[board[nx][ny]]=false;
                map[nx][ny]=false;
            }
        }
        max=Math.max(depth, max);
    }
}