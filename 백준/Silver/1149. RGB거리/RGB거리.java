import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][] memo;
    static int[][] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        memo=new int[N][3];
        cost=new int[N][3];

        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                cost[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        memo[0][0]=cost[0][0];
        memo[0][1]=cost[0][1];
        memo[0][2]=cost[0][2];
        int answer=Math.min(dp(N-1, 0), dp(N-1,1));
        answer=Math.min(dp(N-1,2), answer);

        System.out.println(answer);

    }
    static int dp(int x,int y){
        if(memo[x][y]==0){
            switch (y){
                case 0:
                    memo[x][y]=Math.min(dp(x-1, 1), dp(x-1,2))+cost[x][y];
                    break;
                case 1:
                    memo[x][y]=Math.min(dp(x-1, 0), dp(x-1,2))+cost[x][y];
                    break;
                case 2:
                    memo[x][y]=Math.min(dp(x-1, 1), dp(x-1,0))+cost[x][y];
                    break;
            }
        }
        return memo[x][y];
    }
}
