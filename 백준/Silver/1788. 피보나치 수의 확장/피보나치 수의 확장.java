import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dp;
    static int[] temp;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        dp=new int[Math.abs(N)+1];
        dp[0]=0;
        if(N==0){
            System.out.println(0);
            System.out.println(0);
        }else {
            dp[1] = 1;

            if (Math.abs(N) % 2 == 0 && N < 0) System.out.println(-1);
            else System.out.println(1);
            for (int i = 2; i < dp.length; i++) {
                dp[i] = (dp[i - 1] % 1000000000 + dp[i - 2] % 1000000000) % 1000000000;
            }
            System.out.println(dp[Math.abs(N)]);
        }
    }

}
