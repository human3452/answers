import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int date[][]=new int[N+1][2];
        int dp[]=new int[N+2];
        for(int i=1; i<=N; i++){
            st=new StringTokenizer(br.readLine());
            date[i][0]=Integer.parseInt(st.nextToken());
            date[i][1]=Integer.parseInt(st.nextToken());
        }
        for(int i=N; i>=1; i--){
            if(date[i][0]+i<=N+1){
                if(date[i][1]+dp[i+date[i][0]]>dp[i+1]){
                    dp[i]=date[i][1]+dp[i+date[i][0]];
                }else{
                    dp[i]=dp[i+1];
                }
            }else{
                dp[i]=dp[i+1];
            }
        }
        System.out.println(dp[1]);
    }
}
