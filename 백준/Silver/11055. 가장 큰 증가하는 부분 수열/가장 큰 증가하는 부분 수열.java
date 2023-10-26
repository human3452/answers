import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main  {
    static int max;
    static int dp[][], list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());

        list=new int[N];

        dp=new int[N][2];
        st=new StringTokenizer(br.readLine());
        boolean flag=true;
        for(int i=0; i<N; i++){
            list[i]= Integer.parseInt(st.nextToken());
        }
        int max=list[0];
        dp[0][0]=list[0];
        dp[0][1]=list[0];
        for(int i=1; i<N; i++){
            dp[i][0]=list[i];
            int tmax= 0;
            for(int j=0; j<i; j++){
                if(dp[i][0]>dp[j][0]){
                    tmax=Math.max(tmax, dp[j][1]);
                }
            }
            dp[i][1]=tmax+list[i];
            max=Math.max(dp[i][1],max);
        }
        System.out.println(max);
    }

}