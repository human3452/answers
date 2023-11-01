import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int[] dp, wine;
    static boolean[] check;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        wine=new int[N+1];
        dp=new int[N+1];
        check=new boolean[N+1];
        for(int i=1; i<=N; i++){
            st=new StringTokenizer(br.readLine());
            wine[i]=Integer.parseInt(st.nextToken());
        }
        switch (N){
            default:
                check[2]=true;
                dp[2]=wine[2]+wine[1];
            case 1:
                check[1]=true;
                dp[1]=wine[1];
                break;
        }
        for(int i=3; i<=N; i++){
            int temp=0;
            if(!check[i]){
                temp=Math.max(dp[i-3]+wine[i-1], dp[i-2])+wine[i];
                dp[i]=Math.max(temp, dp[i-1]);
            }
            check[i]=true;
        }
        System.out.println(dp[N]);
    }



}
