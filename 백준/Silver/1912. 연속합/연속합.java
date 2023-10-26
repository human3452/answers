import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main  {
    static int max;
    static int dp[], list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());

        list=new int[N];

        dp=new int[N];
        st=new StringTokenizer(br.readLine());
        boolean flag=true;
        for(int i=0; i<N; i++){
            list[i]= Integer.parseInt(st.nextToken());
            if(flag && list[i]!=0){
                flag=false;
                dp[i]=list[i];
                max=list[i];
            }
        }
        dyn(dp.length-1);
        System.out.println(max);
    }

    private static int dyn(int i) {
        if(dp[i]==0){
            dp[i]=Math.max(dyn(i-1)+list[i], list[i]);
            max=Math.max(dp[i], max);
        }
        return dp[i];
    }
}
