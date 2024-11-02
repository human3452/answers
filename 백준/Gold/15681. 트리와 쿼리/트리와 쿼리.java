import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
    static boolean[] visited;
    static ArrayList<Integer>[] nodes;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        nodes=new ArrayList[N+1];
        answer=new int[N+1];
        for(int i=1; i<=N; i++) nodes[i]=new ArrayList<>();
        visited=new boolean[N+1];
        for(int i=1; i<N; i++){
            st=new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            nodes[from].add(to);
            nodes[to].add(from);
        }
        //DFS
        visited[R]=true;
        DFS(R);
        //Query
        for(int i=0; i<Q; i++){
            bw.write(answer[Integer.parseInt(br.readLine())]+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void DFS(int now){
        int temp=0;
        for(int i=0; i<nodes[now].size(); i++){
            if(!visited[nodes[now].get(i)]){
                visited[nodes[now].get(i)]=true;
                DFS(nodes[now].get(i));
                temp+=answer[nodes[now].get(i)];
            }
        }
        answer[now]+=temp;
        answer[now]++;
    }
}