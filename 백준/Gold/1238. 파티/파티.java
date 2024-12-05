import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.zip.Inflater;


public class Main {
    static final int INF=100000000;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int X= Integer.parseInt(st.nextToken());
        int[][] reverse=new int[N+1][N+1];
        int[][] board=new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++) {
                if(i!=j){
                    reverse[i][j]= INF;
                    board[i][j]=INF;
                }
            }
        }
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());
            int cost= Integer.parseInt(st.nextToken());
            reverse[to][from]=cost;
            board[from][to]=cost;
        }
        //다익스트라 2번
        boolean[] visited=new boolean[N+1];
        visited[X]=true;
        while(true){
            int pointer=-1;
            int min=INF;
            for(int i=1; i<=N; i++){
                if(!visited[i]){
                    if(min>board[X][i]){
                        pointer=i;
                        min=board[X][i];
                    }
                }
            }
            if(pointer==-1) break;
            visited[pointer]=true;
            for(int i=1; i<=N; i++){
                board[X][i]=Math.min(board[X][i], board[X][pointer]+board[pointer][i]);
            }
        }
        visited=new boolean[N+1];
        visited[X]=true;
        while(true){
            int pointer=-1;
            int min=INF;
            for(int i=1; i<=N; i++){
                if(!visited[i]){
                    if(min>reverse[X][i]){
                        pointer=i;
                        min=reverse[X][i];
                    }
                }
            }
            if(pointer==-1) break;
            visited[pointer]=true;
            for(int i=1; i<=N; i++){
                reverse[X][i]=Math.min(reverse[X][i], reverse[X][pointer]+reverse[pointer][i]);
            }
        }
        int answer=-1;
        for(int i=1; i<=N; i++) answer=Math.max(answer, board[X][i]+reverse[X][i]);
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
}