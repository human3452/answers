import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    static int[] candy;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        p=new int[N+1];
        for(int i=1; i<=N; i++) p[i]=i;
        candy=new int[N+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            candy[i]= Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<M; i++) {
            st=new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        HashMap<Integer, int[]> map=new HashMap<>();
        for(int i=1; i<=N; i++){
            if(map.containsKey(find(i))){
                map.get(find(i))[0]++;
                map.get(find(i))[1]+=candy[i];
            }else{
                map.put(find(i), new int[]{1, candy[i]});
            }
        }
        int[][] temp=new int[map.size()+1][2];
        int pointer=0;
        for(int a:map.keySet()){
            pointer++;
            temp[pointer][0]=map.get(a)[0];
            temp[pointer][1]=map.get(a)[1];
        }
        int[][] knapsack=new int[temp.length][K+1];
        //knapsack
        for(int i=1; i<temp.length; i++){
            for(int j=1; j<=K; j++){
                if(temp[i][0]>j){
                    knapsack[i][j]=knapsack[i-1][j];
                }else{
                    knapsack[i][j]=Math.max(knapsack[i-1][j], knapsack[i-1][j-temp[i][0]]+temp[i][1]);
                }
            }
        }
        System.out.println(knapsack[temp.length-1][K-1]);
        bw.flush();
        bw.close();
        br.close();
    }
    static int find(int A){
        if(p[A]==A) return p[A];
        else{
            p[A]=find(p[A]);
            return find(p[A]);
        }
    }
    static void union(int A, int B){
        p[find(Math.max(A, B))]=find(Math.min(A, B));
    }
}
