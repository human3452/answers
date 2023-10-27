import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main  {
    static int[][] dp;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        num=new int[N];
        dp=new int[N][2];
        for(int i=0; i<N; i++){
            num[i]= Integer.parseInt(st.nextToken());
            dp[i][1]=-1;
        }
        dp[0][0]=1;
        int answer=1;
        int answerpointer=-1;
        for(int i=1; i<N; i++){
            int pointer=-1;
            int max=0;
            boolean flag=false;
            for(int j=i-1; j>=0; j--){
               if(num[i]>num[j]){
                   if(max<dp[j][0]){
                       pointer=j;
                       max=dp[j][0];
                       flag=true;
                   }
               }
               dp[i][1] = pointer;
               dp[i][0] = max + 1;
            }
            if(answer<dp[i][0]){
                answer=dp[i][0];
                answerpointer=i;
            }
        }
        System.out.println(answer);
        Stack<Integer> stack=new Stack<>();
        while(answerpointer>=0){
            stack.add(num[answerpointer]);
            answerpointer=dp[answerpointer][1];
        }
        if(stack.isEmpty()){
            System.out.println(num[0]);
        }else {
            while (stack.size() != 1) System.out.print(stack.pop() + " ");
            System.out.print(stack.pop());
        }
    }


}
