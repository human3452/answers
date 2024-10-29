import java.io.*;
import java.util.*;

public class Main {
    static class node{

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer>[] arrayList=new HashMap[N+1];
        for(int i=1; i<=N; i++){
            arrayList[i]=new HashMap<>();
        }
        int start= Integer.parseInt(br.readLine());
        int[] answer=new int[N+1];
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());
            int cost= Integer.parseInt(st.nextToken());
            if(arrayList[from].containsKey(to) && arrayList[from].get(to)<=cost) continue;
            arrayList[from].put(to, cost);
        }
        for(int i=1; i<=N; i++){
            answer[i]=1000000000;
        }
        answer[start]=0;
        for(int a:arrayList[start].keySet()){
            answer[a]=arrayList[start].get(a);
        }
        boolean[] visited=new boolean[N+1];
        visited[start]=true;
        while(true){
            int min=Integer.MAX_VALUE;
            int temp2=-1;
            for(int i=1; i<=N; i++){
                if(!visited[i] && min>answer[i]){
                    temp2=i;
                    min=answer[i];
                }
            }
            if(temp2==-1) break;
            visited[temp2]=true;
            for(int temp:arrayList[temp2].keySet()){
                answer[temp]=Math.min(answer[temp], answer[temp2]+arrayList[temp2].get(temp));
            }
        }
        for(int i=1; i<=N; i++) {
            if(answer[i]<1000000000) bw.write(answer[i]+"\n");
            else bw.write("INF"+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}