import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int[][] board=new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                board[i][j]=board[i][j-1]+ Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                board[i][j]+=board[i-1][j];
            }
        }
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int[] from={Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] to={Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            long temp=board[to[0]][to[1]]-board[to[0]][from[1]-1]-board[from[0]-1][to[1]]+board[from[0]-1][from[1]-1];
            bw.write(temp+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}