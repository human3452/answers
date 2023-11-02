import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dp, price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        dp=new int[N+1];
        price=new int[N+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            price[i]= Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++){
            int temp=price[i];
            for(int j=1; j<=i/2; j++){
                temp=Math.max(temp, dp[j]+dp[i-j]);
            }
            dp[i]=temp;
        }
        System.out.println(dp[N]);
    }

    private static int dyn(int i) {
        if(dp[i]==0){
            dp[i]=dyn(i-1)+dyn(i-2);
        }
        return dp[i];
    }

}