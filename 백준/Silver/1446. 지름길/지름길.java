import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dp;
    static class shortcut{
        int end, length;
        shortcut(int b, int c){
            end=b;
            length=c;
        }


    }
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int D= Integer.parseInt(st.nextToken());
        ArrayList<shortcut> road[]=new ArrayList[D+1];
        for(int i=0; i<=D; i++){
            road[i]=new ArrayList<>();
        }
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance= Integer.parseInt(st.nextToken());
            if(end<=D && distance<end-start && start<D){
                road[start].add(new shortcut(end,distance));
            }
        }

        int dp[]=new int[D+1];
        for(int i=0; i<road[0].size(); i++){
            if(dp[road[0].get(i).end]!=0){
                dp[road[0].get(i).end]=Math.min(dp[road[0].get(i).end], dp[0]+road[0].get(i).length);
            }else{
                dp[road[0].get(i).end]=dp[0]+road[0].get(i).length;
            }
        }
        for(int i=1; i<=D; i++){
            if(dp[i]!=0){
                dp[i]=Math.min(dp[i-1]+1, dp[i]);
            }else{
                dp[i]=dp[i-1]+1;
            }
            if(!road[i].isEmpty()){
                for(int j=0; j<road[i].size(); j++){
                    if(dp[road[i].get(j).end]!=0){
                        dp[road[i].get(j).end]=Math.min(dp[road[i].get(j).end], dp[i]+road[i].get(j).length);
                    }else{
                        dp[road[i].get(j).end]=dp[i]+road[i].get(j).length;
                    }
                }
            }
        }
        System.out.println(dp[D]);
    }

}