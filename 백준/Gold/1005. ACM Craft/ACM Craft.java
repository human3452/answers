import java.io.*;
import java.util.*;

public class Main {
    static class node{

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T= Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int N= Integer.parseInt(st.nextToken());
            int K= Integer.parseInt(st.nextToken());
            int[] time=new int[N+1];
            st=new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) time[i]= Integer.parseInt(st.nextToken());
            //node
            HashSet<Integer> SubsetNodes=new HashSet<>();
            HashMap<Integer, ArrayList<Integer>> reverse=new HashMap<>();
            HashMap<Integer, ArrayList<Integer>> nodes=new HashMap<>();
            int[] what=new int[N+1];
            for(int i=0; i<K; i++){
                st=new StringTokenizer(br.readLine());
                int from= Integer.parseInt(st.nextToken());
                int to= Integer.parseInt(st.nextToken());
                if(nodes.containsKey(from)) nodes.get(from).add(to);
                else {
                    nodes.put(from, new ArrayList<>());
                    nodes.get(from).add(to);
                }
                if(reverse.containsKey(to)) reverse.get(to).add(from);
                else {
                    reverse.put(to, new ArrayList<>(from));
                    reverse.get(to).add(from);
                }
                what[to]++;
            }
            int target= Integer.parseInt(br.readLine());
            //서브셋 찾기(BFS)
            Queue<Integer> queue=new LinkedList<>();
            queue.add(target);
            while(!queue.isEmpty()){
                int temp=queue.poll();
                if(reverse.containsKey(temp)) {
                    for (int a : reverse.get(temp)) {
                        if (!SubsetNodes.contains(a)) {
                            SubsetNodes.add(a);
                            queue.add(a);
                        }
                    }
                }
            }
            //서브셋에서 시작(DAG 탐색)
            int answer=0;
            int counter=0;
            int[] realtime=new int[N+1];
            Deque<Integer> deque=new LinkedList<>();
            Queue<Integer> queue2=new LinkedList<>();
            boolean[] visited=new boolean[N+1];
            for(int temp:SubsetNodes){
                if(what[temp]==0 && !visited[temp]){
                    deque.add(temp);
                    queue2.add(temp);
                    visited[temp]=true;
                }
            }
            while(!queue2.isEmpty()){
                int temp=queue2.poll();
                for(int a:nodes.get(temp)){
                    if(SubsetNodes.contains(a)){
                        what[a]--;
                        if(what[a]==0){
                            queue2.add(a);
                            deque.add(a);
                        }
                    }
                }
            }
            deque.add(target);
            while(!deque.isEmpty()){
                int p=deque.pop();
                if(!reverse.containsKey(p)){
                    realtime[p]=time[p];
                }else{
                    int max=0;
                    for(int k:reverse.get(p)){
                        max=Math.max(realtime[k], max);
                    }
                    realtime[p]=max+time[p];
                }
            }
            System.out.println(realtime[target]);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}