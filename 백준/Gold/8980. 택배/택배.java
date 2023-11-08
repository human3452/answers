import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class packets implements Comparable<packets>{
        int from, to, quantity, distance;
        packets(int a, int b, int c){
            from=a;
            to=b;
            quantity=c;
        }

        @Override
        public int compareTo(packets o) {
            if(this.to==o.to){
                return o.from-this.from;
            }else{
                return this.to-o.to;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int C= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int M= Integer.parseInt(st.nextToken());
        PriorityQueue<packets> pq= new PriorityQueue<>();
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            pq.add(new packets(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int load[]=new int[N+1];
        int answer=0;
        for(int i=0; i<M; i++){
            packets p=pq.poll();
            int min=p.quantity;
            for(int j=p.from; j<p.to; j++){
                min=Math.min(min, C-load[j]);
            }
            if(min==0) continue;
            answer+=min;
            for(int j=p.from; j<p.to; j++){
                load[j]+=min;
            }
        }
        System.out.println(answer);
    }
}
