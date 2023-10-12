import java.util.*;


public class Main {
    static int[] p;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int N=sc.nextInt();
        p=new int[N+1];
        for(int i=1; i<=N;i++){
            p[i]=i;
        }
        PriorityQueue<int[]> xPQ=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<int[]> yPQ=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        PriorityQueue<int[]> zPQ=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        for(int i=1; i<=N; i++){
            int temp[]={sc.nextInt(), sc.nextInt(), sc.nextInt(),i};
            xPQ.add(temp);
            yPQ.add(temp);
            zPQ.add(temp);
        }
        //거리 넣기
        int temp[]= xPQ.poll();
        int temp2[]= yPQ.poll();
        int temp3[]= zPQ.poll();
        for(int i=0; i<N-1; i++){
            int xTemp[]= xPQ.poll();
            pq.add(new int[]{xTemp[3],temp[3], xTemp[0]-temp[0]});
            temp=xTemp.clone();
            int yTemp[]= yPQ.poll();
            pq.add(new int[]{yTemp[3],temp2[3], yTemp[1]-temp2[1]});
            temp2=yTemp.clone();
            int zTemp[]= zPQ.poll();
            pq.add(new int[]{zTemp[3],temp3[3], zTemp[2]-temp3[2]});
            temp3=zTemp.clone();
        }
        //크루스칼, union-find
        int cnt=0;
        int answer=0;
        while (true){
            int node[]=pq.poll();
            if(find(node[0])!=find(node[1])){
                union(node[0],node[1]);
                answer+=node[2];
                cnt++;
            }
            if(cnt==N-1) break;
        }
        System.out.println(answer);
    }
    static void union(int a, int b){
        int c=find(a);
        int d=find(b);
        if(c<d){
            p[d]=c;
        }else{
            p[c]=d;
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