import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        if(N==2){
            System.out.println(0);
            System.exit(0);
        }
        int M= Integer.parseInt(st.nextToken());
        p=new int[N+1];
        for(int i=1; i<=N; i++){
            p[i]=i;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        long answer=0;
        int counter=0;
        while(counter<N-2){
            int[] temp=pq.poll();
            if(find(temp[0])!=find(temp[1])){
                answer+=temp[2];
                counter++;
                union(temp[0], temp[1]);
            }
        }
        System.out.println(answer);
    }
    static void union(int a, int b){
        if(a>b){
            p[find(a)]=find(b);
        }else{
            p[find(b)]=find(a);
        }
    }
    static int find(int A){
        if(p[A]==A) return p[A];
        else{
            p[A]=find(p[A]);
            return find(p[A]);
        }
    }
}