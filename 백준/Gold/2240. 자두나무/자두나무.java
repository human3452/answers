import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main  {
    static int[][] dp;
    static boolean[][] check;
    static int[] plum;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int T= Integer.parseInt(st.nextToken());
        int W=Integer.parseInt(st.nextToken());
        dp=new int[W+1][T+1];
        check=new boolean[W+1][T+1];
        plum=new int[T+1];
        for(int i=1; i<=T; i++){
            st=new StringTokenizer(br.readLine());
            plum[i]= Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<=W; i++){
            check[i][0]=true;
        }
        for(int i=0; i<=T; i++){
            if(plum[i]==1){
                dp[0][i]=dp[0][i-1]+1;
            }
            check[0][i]=true;
        }
        dyn(W, T);
        int answer=0;
        for(int i=0; i<=W; i++){
            answer=Math.max(answer, dp[i][T]);
        }
        System.out.println(answer);
    }

    private static int dyn(int w, int t) {
        if(!check[w][t] ) {
            if (w % 2 == 0) {
                if (plum[t] == 1) {
                    dp[w][t] = Math.max(dyn(w - 1, t - 1), dyn(w, t - 1)) + 1;
                } else {
                    dp[w][t] = Math.max(dyn(w - 1, t - 1), dyn(w, t - 1));
                }
            } else {
                if (plum[t] == 2) {
                    dp[w][t] = Math.max(dyn(w - 1, t - 1), dyn(w, t - 1)) + 1;
                } else {
                    dp[w][t] = Math.max(dyn(w - 1, t - 1), dyn(w, t - 1));
                }
            }
            check[w][t]=true;
        }

        return dp[w][t];
    }

}
