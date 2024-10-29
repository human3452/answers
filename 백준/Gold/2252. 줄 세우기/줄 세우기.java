import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        HashSet<Integer>[] set=new HashSet[N+1];
        int[] start=new int[N+1];
        for(int i=1; i<=N; i++) set[i]=new HashSet<>();
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            start[to]++;
            set[from].add(to);
        }
        boolean[] what=new boolean[N+1];
        Deque<Integer> deque=new LinkedList<>();
        Queue<Integer> queue=new LinkedList<>();
        while(true){
            boolean flag=true;
            for(int i=1; i<=N; i++){
                if(start[i]==0 && !what[i]){
                    deque.add(i);
                    queue.add(i);
                    what[i]=true;
                    flag=false;
                }
            }
            if(flag) break;
            while(!queue.isEmpty()){
                int temp=queue.poll();
                for(int a:set[temp]){
                    start[a]--;
                }
            }
        }
        while(!deque.isEmpty()) bw.write(deque.pop()+" ");
        bw.flush();
        bw.close();
        br.close();
    }
}