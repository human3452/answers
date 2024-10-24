import java.io.*;
import java.util.*;

public class Main {
    static int[] temp;
    static int[] temp2;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        N= Integer.parseInt(br.readLine());
        M= Integer.parseInt(br.readLine());
        int[][] map=new int[N+1][N+1];
        for(int i=1; i<=N;  i++){
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        StringTokenizer st;
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());
            int cost= Integer.parseInt(st.nextToken());
            if(map[from][to]!=Integer.MAX_VALUE && cost>=map[from][to]) continue;
            map[from][to]=cost;
        }
        for(int i=1; i<=N; i++) map[i][i]=0;
        boolean[] visited=new boolean[N+1];
        st=new StringTokenizer(br.readLine());
        int A= Integer.parseInt(st.nextToken());
        int B= Integer.parseInt(st.nextToken());
        visited[A]=true;
        while(true){
            int min=Integer.MAX_VALUE;
            int position=-1;
            for(int i=1; i<=N; i++){
                if(visited[i]) continue;
                if(map[A][i]<min){
                    position=i;
                    min=map[A][i];
                }
            }
            if(position==-1) break;
            visited[position]=true;
            for(int i=1; i<=N; i++){
                if(map[position][i]==Integer.MAX_VALUE) continue;
                map[A][i]=Math.min(map[A][i], map[A][position]+map[position][i]);
            }
        }
        System.out.println(map[A][B]);
//        bw.flush();
//        bw.close();
        br.close();
    }
}