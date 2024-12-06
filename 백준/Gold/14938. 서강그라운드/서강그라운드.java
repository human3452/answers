import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static final int INF=100000000;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st=new StringTokenizer(br.readLine());
            int N= Integer.parseInt(st.nextToken());
            int M= Integer.parseInt(st.nextToken());
            int W= Integer.parseInt(st.nextToken());
            int[][] board=new int[N+1][N+1];
            int[] points=new int[N+1];
            st=new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) points[i]= Integer.parseInt(st.nextToken());
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(i!=j) board[i][j]=INF;
                }
            }
            for(int i=1; i<=W; i++){
                st=new StringTokenizer(br.readLine());
                int from= Integer.parseInt(st.nextToken());
                int to= Integer.parseInt(st.nextToken());
                int cost= Integer.parseInt(st.nextToken());
                board[from][to]= Math.min(cost, board[from][to]);
                board[to][from]= Math.min(cost, board[to][from]);
            }
        for(int m=1; m<=N; m++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++) {
                    board[i][j]=Math.min(board[i][j], board[i][m]+board[m][j]);
                }
            }
        }
        int max=0;
        for(int i=1; i<=N; i++){
            int temp=0;
            for(int j=1; j<=N; j++) {
                if(board[i][j]<=M) temp+=points[j];
            }
            max=Math.max(max, temp);
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
        br.close();
    }
}