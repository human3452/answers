import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main  {
    static int[] memo=new int[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        memo[1]=1;
        memo[2]=2;
        memo[3]=4;
        for(int tc=0; tc<N; tc++){
            st=new StringTokenizer(br.readLine());
            int num=Integer.parseInt(st.nextToken());
            System.out.println(dp(num));
        }

    }
    static int dp(int a){
        if (memo[a] == 0) {
            memo[a] = dp(a - 1) + dp(a - 2) + dp(a - 3);
        }
        return memo[a];
    }
}
