import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        StringTokenizer st=new StringTokenizer(br.readLine());
        int position= Integer.parseInt(st.nextToken());
        int height= Integer.parseInt(st.nextToken());
        if(height!=0) pq.add(height);
        int answer=0;
        for(int i=1; i<N; i++){
            st=new StringTokenizer(br.readLine());
            position= Integer.parseInt(st.nextToken());
            height= Integer.parseInt(st.nextToken());
            while(!pq.isEmpty() && pq.peek()>height){
                pq.poll();
                answer++;
            }
            if(height!=0) {
                if (pq.isEmpty() || pq.peek() != height) {
                    pq.add(height);
                }
            }
        }
        System.out.print(answer+pq.size());
    }
}