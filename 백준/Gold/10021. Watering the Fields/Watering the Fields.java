import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int C= Integer.parseInt(st.nextToken());
        int[][] position=new int[N+1][2];
        p=new int[N+1];
        for(int i=1; i<=N; i++) p[i]=i;
        for(int i=1; i<=N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                position[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        for(int i=1; i<=N; i++){
            for(int j=i+1; j<=N; j++){
                pq.add(new int[]{i, j, (position[i][0]-position[j][0])*(position[i][0]-position[j][0])+(position[i][1]-position[j][1])*(position[i][1]-position[j][1])});
            }
        }
        while(pq.peek()[2]<C) pq.poll();
        int counter=0;
        int answer=0;
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            if(find(temp[0])!=find(temp[1])){
                answer+=temp[2];
                counter++;
                union(temp[0], temp[1]);
            }
            if(counter==N-1) break;
        }
        if(counter!=N-1) System.out.print(-1);
        else System.out.print(answer);
    }
    static void union(int a, int b){
        if(a>b){
            p[find(a)]=find(b);
        }else{
            p[find(b)]=find(a);
        }
    }
    static int find(int a){
        if(p[a]==a){
            return p[a];
        }else{
            return find(p[a]);
        }
    }
}