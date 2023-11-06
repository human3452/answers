import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dp;
    static int[][] temp;
    public static void main(String[] args) throws IOException {
        int tc=0;
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            while(true){
            tc++;
            StringTokenizer st=new StringTokenizer(br.readLine());
            int N= Integer.parseInt(st.nextToken());
            if(N==0) break;
            dp=new int[N][3];
            temp=new int[N][3];
            for(int i=0; i<N; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<3; j++){
                    temp[i][j]= Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0]=1001;
            dp[0][1]=temp[0][1];
            dp[0][2]=dp[0][1]+temp[0][2];
            for(int i=1; i<N; i++){
                dp[i][0]=Math.min(dp[i-1][0],dp[i-1][1])+temp[i][0];
                int tmp1=Math.min(dp[i][0], dp[i-1][0]);
                int tmp2=Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1]=Math.min(tmp1, tmp2)+temp[i][1];
                dp[i][2]=Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][2]=Math.min(dp[i][2], dp[i][1])+temp[i][2];
            }
            System.out.println(tc+". "+dp[N-1][1]);
        }
    }

}
