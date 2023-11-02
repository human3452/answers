import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int M= Integer.parseInt(st.nextToken());
        int pointer=1;
        dp=new int[N+1];
        dp[0]=1;
        dp[1]=1;
        //피보나치인듯
        int answer=1;
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            answer*=dyn(temp-pointer);
            pointer=temp+1;
        }
        answer*=dyn(N-pointer+1);
        System.out.println(answer);
    }

    private static int dyn(int i) {
        if(dp[i]==0){
            dp[i]=dyn(i-1)+dyn(i-2);
        }
        return dp[i];
    }

}