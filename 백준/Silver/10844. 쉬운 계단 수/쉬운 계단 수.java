import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main  {
    static int max;
    static int list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        long[][] dp=new long[N][10];
        for(int i=1; i<10; i++){
            dp[0][i]=1;
        }
        for(int i=1; i<N; i++){
            for(int j=0; j<10; j++){
                for(int k=j-1; k<=j+1; k+=2){
                    if(k>=0 && k<10){
                        dp[i][j]+=dp[i-1][k]%1000000000;
                    }
                }
            }
        }
        long answer=0;
        for(int i=0; i<10; i++){
            answer+=dp[N-1][i];
        }
        System.out.println(answer%1000000000);

    }

}