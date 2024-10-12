import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1;
        int answer=0;
        st1=new StringTokenizer(br.readLine(), " ");
        int N=Integer.parseInt(st1.nextToken());
        int M=Integer.parseInt(st1.nextToken());
        int[] map=new int[101];
        for(int i=0; i<101; i++){
            map[i]=i;
        }
        boolean[] visited=new boolean[101];
        //사다리 정보 받기(맵 업데이트)
        for(int i=0; i<N; i++){
            st1=new StringTokenizer(br.readLine(), " ");
            map[Integer.parseInt(st1.nextToken())]=Integer.parseInt(st1.nextToken());
        }
        // 뱀 정보 받기(맵 업데이트)
        for(int i=0; i<M; i++){
            st1=new StringTokenizer(br.readLine(), " ");
            map[Integer.parseInt(st1.nextToken())]=Integer.parseInt(st1.nextToken());
        }
        //BFS 사용
        Queue<int[]> queue=new LinkedList<>(); // [현재 위치, 이동횟수]
        queue.add(new int[] {1,0});
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            if(current[0]>=94){
                answer=current[1]+1;
                break;
            }
            for(int i=1; i<=6; i++){
                int now=current[0]+i;
                if(!visited[now]){
                    visited[now]=true;
                    now=map[now];
                    visited[now]=true;
                    queue.add(new int[] {now,current[1]+1});
                }
            }
        }
        System.out.print(answer);
    }
}