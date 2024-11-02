import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
    static boolean[] visited;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        p=new int[V+1];
        for(int i=1; i<=V; i++) p[i]=i;
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        for(int i=0; i<E; i++){
            st=new StringTokenizer(br.readLine());
            pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        int answer=0;
        int counter=0;
        while(counter<V-1){
            int[] temp=pq.poll();
            if(find(temp[0])!=find(temp[1])) {
                union(temp[0], temp[1]);
                answer += temp[2];
                counter++;
            }
        }
        System.out.println(answer);
    }
    static void union(int a, int b){
        if(a>b) p[find(a)]=find(b);
        else p[find(b)]=find(a);
    }

    static int find(int a){
        if(p[a]==a) return a;
        else {
            p[a]=find(p[a]);
            return find(p[a]);
        }
    }
}