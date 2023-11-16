import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        M= Integer.parseInt(st.nextToken());
        LinkedList<int[]> pq=new LinkedList<>();
        int max=-1;
        for(int i=1; i<=M; i++){
            st=new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            if(from>to) {
                max=Math.max(max, to);
                to+=N;
            }
            pq.add(new int[]{i, from, to});
        }
        Collections.sort(pq, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o2[2]-o1[2];
                }else{
                    return o1[1]-o2[1];
                }
            }
        });
        int tmax=0;
        for(int i=0; i<M; i++){
            int[] temp=pq.poll();
            if(temp[2]>tmax){
                tmax=temp[2];
                pq.add(temp);
            }
        }
        while(pq.peek()[2]<=max){
            pq.poll();
        }
        PriorityQueue<Integer> answer=new PriorityQueue<>();
        while (!pq.isEmpty()){
            answer.add(pq.poll()[0]);
        }
        while(!answer.isEmpty()){
            System.out.print(answer.poll()+" ");
        }
    }
}
