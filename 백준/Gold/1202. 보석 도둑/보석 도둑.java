import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> temp=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //보석들
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            int weight=Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());
            temp.add(new int[]{weight, value});

        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0; i<K; i++){
            st=new StringTokenizer(br.readLine());
            int value=Integer.parseInt(st.nextToken());
            pq.add(value);
        }
        long answer=0;
        PriorityQueue<Integer> pq2=new PriorityQueue<>(Collections.reverseOrder());

        while(!pq.isEmpty()){
            int v=pq.poll();
            while(!temp.isEmpty() && temp.peek()[0]<=v){
                pq2.add(temp.poll()[1]);
            }
            if(pq2.isEmpty()) continue;
            answer+=pq2.poll();
        }
        System.out.println(answer);
    }

}
