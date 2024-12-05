import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[][] cost=new int[N+1][N+1];
        int M= Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                cost[i][j]=100000000;
            }
        }
        for(int i=1; i<=M; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());
            int cost2= Integer.parseInt(st.nextToken());
            cost[from][to]=Math.min(cost2, cost[from][to]);
        }
        for(int i=1; i<=N; i++) cost[i][i]=0;
        for(int m=1; m<=N; m++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    cost[s][e]=Math.min(cost[s][e], cost[s][m]+cost[m][e]);
                }
            }
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(cost[i][j]>=100000000) bw.write(0+" ");
                else bw.write(cost[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}