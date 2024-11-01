import java.io.*;
import java.util.*;

public class Main {
    static int N, min, max;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        board=new int[N][3];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] maxboard=new int[N][3];
        int[][] minboard=new int[N][3];
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            maxboard[0][j] = board[0][j];
            minboard[0][j] = board[0][j];
        }
        for(int i=0; i<N-1; i++) {
            int maxtemp=Math.max(maxboard[i][0], maxboard[i][1]);
            int mintemp=Math.min(minboard[i][0], minboard[i][1]);
            maxboard[i+1][0]=maxtemp+board[i+1][0];
            maxboard[i+1][2]=Math.max(maxboard[i][1], maxboard[i][2])+board[i+1][2];
            maxboard[i+1][1]=Math.max(maxtemp, maxboard[i][2])+board[i+1][1];
            minboard[i+1][0]=mintemp+board[i+1][0];
            minboard[i+1][2]=Math.min(minboard[i][1], minboard[i][2])+board[i+1][2];
            minboard[i+1][1]=Math.min(mintemp, minboard[i][2])+board[i+1][1];
        }
        max=Math.max(Math.max(maxboard[N-1][0], maxboard[N-1][1]), maxboard[N-1][2]);
        min=Math.min(Math.min(minboard[N-1][0], minboard[N-1][1]), minboard[N-1][2]);
        System.out.println(max+" "+min);
        bw.flush();
        bw.close();
        br.close();
    }
}