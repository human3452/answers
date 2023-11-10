import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int group= Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        PriorityQueue<Integer> pq2=new PriorityQueue<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }
        int answer=0;
        int from=pq.poll();
        int to=0;
        int se=1;
        while(!pq.isEmpty()){
            to=pq.poll();
            if(from==to) continue;
            pq2.add(to-from);
            from=to;
            se++;
        }
        if(se<=group) System.out.println(0);
        else {
            for (int i = 0; i < se - group; i++) {
                answer+=pq2.poll();
            }
            System.out.println(answer);
        }
        
    }
}
